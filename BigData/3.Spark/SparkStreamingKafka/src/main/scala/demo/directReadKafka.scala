package demo

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka.KafkaUtils
import kafka.serializer.StringDecoder

object directReadKafka {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("windowWC").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(3))
    val topics = Set("mydemo1")
    val kafkaParam = Map[String,String]("metadata.broker.list"->"192.168.137.111:9092")
    val kafkaDirectStream = KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](ssc,kafkaParam,topics)
    
    val stringDStream = kafkaDirectStream.map(e=>{
      new String(e.toString())
    })
      
    stringDStream.print()
    ssc.start()
    ssc.awaitTermination()
}