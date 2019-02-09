package demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class JavaSparkWC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf conf = new SparkConf().setAppName("javaWC").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.137.111:9000/user/root/input/myword.txt");
		JavaRDD<String> rdd2 = rdd1.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterator<String> call(String input) throws Exception {
				// TODO Auto-generated method stub
				return Arrays.asList(input.split(" ")).iterator();
			}
			
		});
		
		JavaPairRDD<String, Integer> rdd3 = rdd2.mapToPair(new PairFunction<String,String,Integer>() {

			@Override
			public Tuple2<String, Integer> call(String word) throws Exception {
				// TODO Auto-generated method stub
				return new Tuple2<String, Integer>(word, 1);
			}
			
		});
		
		JavaPairRDD<String, Integer> rdd4 = rdd3.reduceByKey(new Function2<Integer, Integer, Integer>() {
			
			@Override
			public Integer call(Integer a, Integer b) throws Exception {
				// TODO Auto-generated method stub
				return a+b;
			}
		});
		
		List<Tuple2<String, Integer>> result = rdd4.collect();
		
		for(Tuple2<String, Integer> tuple:result) {
			System.out.println(tuple._1 + "\t" + tuple._2);
		}
		
		sc.stop();
	}

}
