# -*- coding: utf-8 -*-
"""
Created on Sat Feb  2 23:45:00 2019

@author: xinyu
"""
import happybase
from pyspark.sql import SparkSession
from pyspark import SparkContext,SparkConf
 

##connect
#connection = happybase.Connection('192.168.137.111')
#connection.open()
#print('------------table_name------------')
#print(connection.tables())
#connection.close()

#spark=SparkSession.builder.appName("abv").getOrCreate() #创建spark对象
conf = (SparkConf()
         .setAppName("My app")
#         .setMaster("local")
#         .set("spark.executor.extraClassPath", "hbase/*")
#         .set("spark.driver.extraClassPath", "hbase/*")
         )
#out = SparkContext(conf = conf).textFile("hdfs://192.168.137.111:9000/user/root/input/myword.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect()
#print(out)
print('spark sc created')
sc = SparkContext(conf = conf)
result = sc.textFile("hdfs://192.168.137.111:9000/user/root/input/myword.txt").collect()
for (k) in result:
        print (k)
sc.stop()
#host = '192.168.137.111'
##192.168.137.112,192.168.137.113
#inputtable='traxen_test'
#hbaseconf={"hbase.zookeeper.quorum":host,"hbase.mapreduce.inputtable":inputtable}
#keyConv="org.apache.spark.examples.pythonconverters.ImmutableBytesWritableToStringConverter"
#valueConv="org.apache.spark.examples.pythonconverters.HBaseResultToStringConverter"
#try:
#    hbase_rdd = sc.newAPIHadoopRDD("org.apache.hadoop.hbase.mapreduce.TableInputFormat","org.apache.hadoop.hbase.io.ImmutableBytesWritable","org.apache.hadoop.hbase.client.Result",keyConverter=keyConv,valueConverter=valueConv,conf=hbaseconf)
#    count = hbase_rdd.count()
#    hbase_rdd.cache()
#    output = hbase_rdd.collect()
#    for (k, v) in output:
#            print (k, v)
#except:
#    sc.stop()