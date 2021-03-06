package networkWordCount

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.storage.StorageLevel

object totalnetworkWordCount {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("wordCount").setMaster("local[2]")
      val ssc = new StreamingContext(conf,Seconds(3))
      ssc.checkpoint("hdfs://192.168.137.111:9000/wordCount/ckpt")      
      val lines = ssc.socketTextStream("192.168.137.111", 1234, StorageLevel.MEMORY_ONLY) //
      val words = lines.flatMap(_.split(" "))
      val wordCount = words.map((_,1))
      val addFunc = (curreValues:Seq[Int],previousValues:Option[Int]) => {
        val currentTotal = curreValues.sum
        Some(currentTotal + previousValues.getOrElse(0))
      }
      val total = wordCount.updateStateByKey(addFunc)
      total.print()
      ssc.start()
      ssc.awaitTermination()

  }
}