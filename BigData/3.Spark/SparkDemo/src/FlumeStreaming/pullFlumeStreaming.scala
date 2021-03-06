package FlumeStreaming

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.flume.FlumeUtils

object pullFlumeStreaming {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("windowWC").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(3))
    
    val flumeEvenStream = FlumeUtils.createPollingStream(ssc, "192.168.137.111",1234,StorageLevel.MEMORY_ONLY)
    val stringDStream = flumeEvenStream.map(e => {
      new String(e.event.getBody.array())
    })
    stringDStream.print
    ssc.start()
    ssc.awaitTermination()
  }
}