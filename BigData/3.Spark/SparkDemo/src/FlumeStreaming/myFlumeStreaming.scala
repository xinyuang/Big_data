package FlumeStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.StreamingContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.streaming.Seconds

object myFlumeStreaming {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("windowWC").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(3))
    
    val flumeEventDStream = FlumeUtils.createStream(ssc, "192.168.137.1", 1234)
    val receiveStringDStream = flumeEventDStream.map(e => {
      new String(e.event.getBody.array())
    })
    receiveStringDStream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}