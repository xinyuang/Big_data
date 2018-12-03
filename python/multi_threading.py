#! /usr/bin/python
from __future__ import division
from __future__ import print_function
import smbus
import math
import time
import can
import os
from gps import *
import threading
import thread
import datetime
import sys

# set CAN conversion parameters
gyro_offset = -250
accel_offset = -320
angle_offset = -250
gps_offset = -210

gyro_factor = 1/128
accel_factor = 0.01
angle_factor = 1/32768
gps_factor = 0.0000001

gyro_id = int('0xCF02A80', 16)
accel_id = int('0x8F02D80',16)
angle_id = int('0xCF02980', 16)
gps_id = int('0x18FEF34A', 16)

data_log_path = "/home/pi/traxen/can_gps/can_test/logged_data/"
file_size = 100000
# Power management registers
power_mgmt_1 = 0x6b
power_mgmt_2 = 0x6c

def read_byte(adr):
  return bus.read_byte_data(address, adr)

def read_word(adr):
  high = bus.read_byte_data(address, adr)
  low = bus.read_byte_data(address, adr+1)
  val = (high << 8) + low
  return val

def read_word_2c(adr):
  val = read_word(adr)
  if (val >= 0x8000):
    return -((65535 - val) + 1)
  else:
    return val

def dist(a,b):
  return math.sqrt((a*a)+(b*b))

def get_y_rotation(x,y,z):
  radians = math.atan2(x, dist(y,z))
  return -math.degrees(radians)

def get_x_rotation(x,y,z):
  radians = math.atan2(y, dist(x,z))
  return math.degrees(radians)

# convert physical value to raw value
def real2raw(real, offset, factor, form):
    if real != real: return format(0xffffffff,'#10x')
    return format(int((real - offset) / factor), form)

def file_check():
    global file_name
    global start
    if os.path.getsize(data_log_path + file_name) > file_size:
        os.rename(data_log_path + file_name, data_log_path + "complete_" + file_name)
        imu_send = False
        time.sleep(0.01)

        file_name = time.strftime("GPS_%m-%d-%02Y_%H-%M-%S.asc")
        with open(data_log_path + file_name, 'a') as f:
            f.write('date ' +  time.ctime() + '\r\n')
            f.write('base hex  timestamps absolute\r\n')
            f.write('internal events logged\r\n')
            f.write('Begin Triggerblock  ' +  time.ctime() + '\r\n')
            start = time.time()
            end = time.time()
            f.write("   {0:.6f}".format(end - start)+ ' Start of measurement\r\n')

def log_ecu():
    msg = can_bus.recv()
    logged_time = "   {0:.6f}".format(msg.timestamp - start)

    data = list(msg.data)
    end = time.time()
    timeStamp = "   {0:.6f}".format(end - start)
    channel = " 1 "
    data_len = msg.dlc
    msg_id = format(msg.arbitration_id, "#10x").upper()[2:].replace('X',' ') + 'x' + " Tx d " + str(msg.dlc) + " "
    strs = ''.join(' ' + format(e, '#04x')[2:].upper() for e in data)
    logged_data = timeStamp + channel + msg_id + strs + '\r\n'
    with open(data_log_path + file_name, 'a') as f:
        f.write(logged_data)

def send_gps(gps_id, gps_offset, gps_factor, can_bus, data_log_path, file_name, start):
      # read and send GPS signal
      latitude_real = gpsd.fix.latitude
      longitude_real = gpsd.fix.longitude
      raw_latitude = real2raw(latitude_real, gps_offset, gps_factor, '#10x')
      raw_longitude = real2raw(longitude_real, gps_offset, gps_factor, '#10x')
      data=[int(raw_latitude[8:10], 16),
                                    int(raw_latitude[6:8], 16),
                                    int(raw_latitude[4:6], 16),
                                    int(raw_latitude[2:4], 16),
                                    int(raw_longitude[8:10], 16),
                                    int(raw_longitude[6:8], 16),
                                    int(raw_longitude[4:6], 16),
                                    int(raw_longitude[2:4], 16)]
      msg = can.Message(arbitration_id=gps_id,
                              data=data,
                              extended_id=True)
      can_bus.send(msg)
      end = time.time()
      timeStamp_GPS = "   {0:.6f}".format(end - start)
      channel = " 1 "
      msg_id = format(gps_id, '#09x').upper()[2:] + 'x' + " Tx d 8 "
      strs = ''.join(' ' + format(e, '#04x')[2:].upper() for e in data)
      with open(data_log_path + file_name, 'a') as f:
          f.write(timeStamp_GPS + channel + msg_id + strs + '\r\n')

def send_imu(imu_send, gyro_id, gyro_offset, gyro_factor, accel_id, \
             accel_offset, accel_factor, can_bus):
      # read and write gyro_x, y, z signal
      gyro_xout = read_word_2c(0x43)
      gyro_yout = read_word_2c(0x45)
      gyro_zout = read_word_2c(0x47)

      raw_gyro_xout = real2raw((gyro_xout / 131), gyro_offset, gyro_factor, '#06x')
      raw_gyro_yout = real2raw((gyro_yout / 131), gyro_offset, gyro_factor, '#06x')
      raw_gyro_zout = real2raw((gyro_zout / 131), gyro_offset, gyro_factor, '#06x')
      
      data=[int(raw_gyro_yout[4:6], 16),
            int(raw_gyro_yout[2:4], 16),
            int(raw_gyro_xout[4:6], 16),
            int(raw_gyro_xout[2:4], 16),
            int(raw_gyro_zout[4:6], 16),
            int(raw_gyro_zout[2:4], 16),
            0xff, 0xff]
      msg = can.Message(arbitration_id=gyro_id,
                              data=data,
                              extended_id=True)
      can_bus.send(msg)
      end = time.time()
      timeStamp = "   {0:.6f}".format(end - start)
      channel = " 1 "
      msg_id = format(gyro_id, '#09x').upper()[2:] + 'x' + " Tx d 8 "
      strs = ''.join(' ' + format(e, '#04x')[2:].upper()  for e in data)
      with open(data_log_path + file_name, 'a') as f:
          if imu_send:
              f.write(timeStamp + channel + msg_id + strs + '\r\n')
      

      # read and send accel_x, y, z signal
      accel_xout = read_word_2c(0x3b)
      accel_yout = read_word_2c(0x3d)
      accel_zout = read_word_2c(0x3f)
      accel_xout_scaled = accel_xout / 16384.0
      accel_yout_scaled = accel_yout / 16384.0
      accel_zout_scaled = accel_zout / 16384.0
     
      raw_accel_xout = real2raw(accel_xout_scaled, accel_offset, accel_factor, '#06x')
      raw_accel_yout = real2raw(accel_yout_scaled, accel_offset, accel_factor, '#06x')
      raw_accel_zout = real2raw(accel_zout_scaled, accel_offset, accel_factor, '#06x')
      
      data=[int(raw_accel_yout[4:6], 16),
            int(raw_accel_yout[2:4], 16),
            int(raw_accel_xout[4:6], 16),
            int(raw_accel_xout[2:4], 16),
            int(raw_accel_zout[4:6], 16),
            int(raw_accel_zout[2:4], 16),
            0xff, 0xff]
      msg = can.Message(arbitration_id=accel_id,
                              data=data,
                              extended_id=True)
      can_bus.send(msg)
      end = time.time()
      timeStamp = "   {0:.6f}".format(end - start)
      channel = " 1 "
      msg_id = format(accel_id, '#09x').upper()[2:] + 'x' + " Tx d 8 "
      strs = ''.join(' ' + format(e, '#04x')[2:].upper()  for e in data)
      with open(data_log_path + file_name, 'a') as f:
          if imu_send:
              f.write(timeStamp + channel + msg_id + strs + '\r\n')

      # read and send x,y angle signal
      x_angle = get_x_rotation(accel_xout_scaled, accel_yout_scaled, accel_zout_scaled)
      y_angle = get_y_rotation(accel_xout_scaled, accel_yout_scaled, accel_zout_scaled)
      
      raw_angle_xout = real2raw(x_angle, angle_offset, angle_factor, '#08x')
      raw_angle_yout = real2raw(y_angle, angle_offset, angle_factor, '#08x')
      
      data=[int(raw_angle_yout[6:8], 16),
            int(raw_angle_yout[4:6], 16),
            int(raw_angle_yout[2:4], 16),
            int(raw_angle_xout[6:8], 16),
            int(raw_angle_xout[4:6], 16),
            int(raw_angle_xout[2:4], 16),
            0xff, 0xff]
      msg = can.Message(arbitration_id=angle_id,
                              data=[int(raw_angle_yout[6:8], 16),
                                    int(raw_angle_yout[4:6], 16),
                                    int(raw_angle_yout[2:4], 16),
                                    int(raw_angle_xout[6:8], 16),
                                    int(raw_angle_xout[4:6], 16),
                                    int(raw_angle_xout[2:4], 16),
                                    0xff, 0xff],
                              extended_id=True)
      can_bus.send(msg)
      end = time.time()
      timeStamp = "   {0:.6f}".format(end - start)
      channel = " 1 "
      msg_id = format(angle_id, '#09x').upper()[2:] + 'x' + " Tx d 8 "
      strs = ''.join(' ' + format(e, '#04x')[2:].upper()  for e in data)
      with open(data_log_path + file_name, 'a') as f:
          if imu_send:
              f.write(timeStamp + channel + msg_id + strs + '\r\n')
 


# initiate CAN bus
can_bus = can.interface.Bus(channel='can0', bustype='socketcan_ctypes')


bus = smbus.SMBus(1) # or bus = smbus.SMBus(1) for Revision 2 boards
address = 0x68 # This is the address value read via the i2cdetect command
INT_PIN_CFG = 0x37
INT_ENABLE  = 0x38

# Now wake the 6050 up as it starts in sleep mode
bus.write_byte_data(address, power_mgmt_1, 0)
bus.write_byte_data(address, INT_PIN_CFG, 0x02)
bus.write_byte_data(address, INT_ENABLE, 0x01)

gpsd = None #seting the global variable
class GpsPoller(threading.Thread):
  def __init__(self):
    threading.Thread.__init__(self)
    global gpsd #bring it in scope
    gpsd = gps(mode=WATCH_ENABLE) #starting the stream of info
    self.current_value = None
    self.running = True #setting the thread running to true
 
  def run(self):
    global gpsd
    while gpsp.running:
      gpsd.next() #this will continue to loop and grab EACH set of gpsd info to clear the buffer
 
class gpsThread (threading.Thread):
    def __init__(self, name, counter):
        threading.Thread.__init__(self)
        self.threadID = counter
        self.name = name
        self.counter = counter
    def run(self):
        while True:
            print ("Starting " + str(self.counter))           
            end = time.time()
            global start
            if round((end - start) * 1000) % 20 == 0:
                threadLock.acquire()
                send_gps(gps_id, gps_offset, gps_factor, can_bus, data_log_path, file_name, start)
                threadLock.release()
                print ("Exiting " + self.name)

class imuThread (threading.Thread):
    def __init__(self, name, counter):
        threading.Thread.__init__(self)
        self.threadID = counter
        self.name = name
        self.counter = counter
    def run(self):
        while True:
            print ("Starting " + str(self.counter))
            end = time.time()
            global start
            if round((end - start) * 1000) % 20 == 0:
                # Acquire lock to synchronize thread
                threadLock.acquire()
                # send imu message
                send_imu(imu_send, gyro_id, gyro_offset, gyro_factor, accel_id, accel_offset, accel_factor, can_bus)
                # Release lock for the next thread
                threadLock.release()
            print ("Exiting " + self.name)
        
class ecuThread (threading.Thread):
    def __init__(self, name, counter):
        threading.Thread.__init__(self)
        self.threadID = counter
        self.name = name
        self.counter = counter
        self.kill_received = False
    def run(self):
        while True:
            print ("Starting " + str(self.counter))
            # Acquire lock to synchronize thread
            threadLock.acquire()
            # log ecu message
            log_ecu()
            # Release lock for the next thread
            threadLock.release()
            print ("Exiting " + self.name)  


if __name__ == '__main__':
  threadLock = threading.Lock()
  for data in os.listdir(data_log_path):
      if data.split('_')[0] == 'GPS':
          file_src = data_log_path + data
          os.remove(file_src)  
  gpsp = GpsPoller() # create the thread

  file_name = time.strftime("GPS_%m-%d-%02Y_%H-%M-%S.asc")
  with open(data_log_path + file_name, 'a') as f:
      f.write('date ' +  time.ctime() + '\r\n')
      f.write('base hex  timestamps absolute\r\n')
      f.write('internal events logged\n')
      f.write('Begin Triggerblock  ' +  time.ctime() + '\r\n')
      start = time.time()
      end = time.time()
      f.write("   {0:.6f}".format(end - start)+ ' Start of measurement\r\n')
  imu_send = True
  #file = fileThread("file", 0)
  gps = gpsThread("test", 1)
  gps.deamon = True
  imu = imuThread("rest", 2)
  ecu = ecuThread("ecu",3)
  try:
    gpsp.start() # start it up
    
    gps.daemon = True
    gps.start()
    
    imu.daemon = True
    imu.start()
    
    ecu.daemon = True
    ecu.start()    
    while True:
        # Acquire lock to synchronize thread
        threadLock.acquire()
        #print_date(self.name, self.counter)
        file_check()
        # Release lock for the next thread
        threadLock.release()
    
  except (KeyboardInterrupt, SystemExit): #when you press ctrl+c
    print ("\nKilling Thread...")
    gpsp.running = False
    print ("Done.\nExiting.")
    sys.exit()
