package demo

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka.KafkaUtils

object KafkaReceiver {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("windowWC").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(3))
    val topics = Map("mydemo1"->1)
    val kafkaDStream = KafkaUtils.createStream(ssc,"192.168.137.111:2181","myGroup", topics)
    val stringDStream = kafkaDStream.map(e=>{
      new String(e.toString())
    })
    stringDStream.print()
    ssc.start()
    ssc.awaitTermination()
    
  }
}