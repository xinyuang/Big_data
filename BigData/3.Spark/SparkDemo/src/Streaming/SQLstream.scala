package Streaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SQLstream {
  def main(args: Array[String]): Unit = {
      Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
      Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
      val conf = new SparkConf().setAppName("wordCount").setMaster("local[2]")
      val ssc = new StreamingContext(conf,Seconds(3))    
      val lines = ssc.socketTextStream("192.168.137.111", 1234, StorageLevel.MEMORY_ONLY) //
      val words = lines.flatMap(_.split(" "))
      words.print()
      words.foreachRDD(rdd => {
        val spark = SparkSession.builder().config(rdd.sparkContext.getConf).getOrCreate()
        import spark.implicits._
        val df1 = rdd.toDF("word")
        df1.createOrReplaceTempView("words")
        spark.sql(" select word, count(*) from words group by word").show() 
      })
      ssc.start()
      ssc.awaitTermination()
  }
}