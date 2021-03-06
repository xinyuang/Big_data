package TomcatLog

import org.apache.derby.impl.tools.sysinfo.Main
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object count {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MyTomcatLog").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("D:\\BaiduNetdiskDownload\\localhost_access_log.2017-07-30.txt").map(
        line => {
          val index1 = line.indexOf("\"")
          val index2 = line.lastIndexOf("\"")
          val line1 = line.substring(index1+1,index2)
          val index3 = line1.indexOf(" ")
          val index4 = line1.lastIndexOf(" ")
          val line2 = line1.substring(index3+1,index4)
          val jspName = line2.substring(line2.lastIndexOf("/") + 1)
          (jspName,1)
        }
      )
      
    val rdd2 = rdd1.reduceByKey(_+_)
    val rdd3 = rdd2.sortBy(_._2,false)
    println(rdd3.take(2).toBuffer)
    sc.stop()
        
  }
}