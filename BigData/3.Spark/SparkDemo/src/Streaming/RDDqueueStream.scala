package Streaming

import scala.collection.mutable.Queue

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext

object RDDqueueStream {
    def main(args: Array[String]): Unit = {
      Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
      Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
      
      val conf = new SparkConf().setAppName("windowWC").setMaster("local[2]")
      val ssc = new StreamingContext(conf, Seconds(1))
      
      //Queue
      val rddQueue = new Queue[RDD[Int]]()
      for(i<- 1 to 3){
        rddQueue += ssc.sparkContext.makeRDD(1 to 10)
        Thread.sleep(5000)
      }
      val inputDStream = ssc.queueStream(rddQueue)
      val result = inputDStream.map(x => (x,x*2))
      result.print()
      ssc.start()
      ssc.awaitTermination()  
    }
 
}