package networkWordCount

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.storage.StorageLevel

object windowWordCount {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("windowWC").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(3))
    ssc.checkpoint("hdfs://192.168.137.111:9000/wordCount/ckpt")
    val lines = ssc.socketTextStream("192.168.137.111",1234,StorageLevel.MEMORY_ONLY)
    val words = lines.flatMap(_.split(" ")).map((_,1))
    val result = words.reduceByKeyAndWindow((x:Int,y:Int)=>x+y,Seconds(30),Seconds(9))
    result.print()
    ssc.start()
    ssc.awaitTermination()
  }
}