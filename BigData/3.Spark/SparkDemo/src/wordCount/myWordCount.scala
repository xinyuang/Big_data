package wordCount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object myWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("myWordCount").setMaster("local")
    val sc = new SparkContext(conf)
    val result = sc.textFile("hdfs://192.168.137.111:9000/user/root/input/myword.txt")
      .flatMap(_.split(" "))
      .map((_,1))
			.reduceByKey(_+_)
		result.foreach(println)
		sc.stop()
  }
}