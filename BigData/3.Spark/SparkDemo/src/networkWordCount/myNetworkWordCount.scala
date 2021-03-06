package networkWordCount

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object myNetworkWordCount {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("wordCount").setMaster("local[2]")
      val ssc = new StreamingContext(conf,Seconds(3))
      val lines = ssc.socketTextStream("192.168.137.111", 9999) //, StorageLevel.MEMORY_ONLY
      val words = lines.flatMap(_.split(" "))
      val wordCount = words.map((_,1)).reduceByKey(_+_)
      wordCount.print()
      ssc.start()
      ssc.awaitTermination()
    }
}