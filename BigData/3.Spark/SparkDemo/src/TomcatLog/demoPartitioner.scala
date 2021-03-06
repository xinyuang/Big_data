package TomcatLog

import scala.collection.mutable.HashMap
import org.apache.spark.Partitioner
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object demoPartitioner {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\BaiduNetdiskDownload\\hadoop-2.4.1\\hadoop-2.4.1\\hadoop-2.4.1")
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
          (jspName,line)
        }
      )
      
    val rdd2 = rdd1.map(_._1).distinct().collect()
    val myPartitioner = new MyWebPartitioner(rdd2)
    
    
    val rdd3 = rdd1.partitionBy(myPartitioner)
    rdd3.saveAsTextFile("D:\\BaiduNetdiskDownload\\partition")
    sc.stop()
  }
}

//partition rule
class MyWebPartitioner(jspList:Array[String]) extends Partitioner{
  val partitionMap = new HashMap[String, Int]()
  var partID = 0
  for(jsp <- jspList){
    partitionMap.put(jsp,partID)
    partID += 1
  }
  override def numPartitions = partitionMap.size
  
  override def getPartition(key:Any) = {
    partitionMap.getOrElse(key.toString,0)
  }
}