package wordCount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object outputWordCount {
   def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("myWordCount")
    val sc = new SparkContext(conf)
    val result = sc.textFile(args(0))
      .flatMap(_.split(" "))
      .map((_,1))
			.reduceByKey(_+_)
		result.saveAsTextFile(args(1))
		sc.stop()
  }
}