package MRunit;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

public class UniteTest {
	@Test
	public void testMapper() throws Exception{
		
		System.setProperty("hadoop.home.dir", "C:\\hadoop-2.7.3");
		wordCountMapper mapper = new wordCountMapper();
	
		MapDriver<LongWritable, Text, Text, IntWritable> driver = new MapDriver<>(mapper);
		driver.withInput(new LongWritable(1), new Text("I love Beijing"));
		driver.withOutput(new Text("I"), new IntWritable(1))
			  .withOutput(new Text("love"), new IntWritable(1))
			  .withOutput(new Text("Beijing"), new IntWritable(1));
		driver.runTest();
	}
	
	@Test
	public void testReducer() throws Exception{
		wordCountReducer reducer = new wordCountReducer();
		ReduceDriver<Text, IntWritable, Text, IntWritable> driver = new ReduceDriver<>(reducer);
		List<IntWritable> value3 = new ArrayList<>();
		value3.add(new IntWritable(1));
		value3.add(new IntWritable(1));
		value3.add(new IntWritable(1));
		driver.withInput(new Text("Beijing"), value3);		
		driver.withOutput(new Text("Beijing"),new IntWritable(3));
		driver.runTest();
	}
	
	@Test
	public void testJob() throws Exception{
		wordCountMapper mapper = new wordCountMapper();
		wordCountReducer reducer = new wordCountReducer();
		MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> driver = new MapReduceDriver<>(mapper, reducer);
		driver.withInput(new LongWritable(1), new Text("I love Beijing"))
			  .withInput(new LongWritable(1), new Text("I love China"))
			  .withInput(new LongWritable(1), new Text("Beijing is the capital of China"));
		driver.withOutput(new Text("Beijing"), new IntWritable(2))
		.withOutput(new Text("China"), new IntWritable(2))	
		.withOutput(new Text("I"), new IntWritable(2))
		.withOutput(new Text("capital"), new IntWritable(1))
		.withOutput(new Text("is"), new IntWritable(1))
			.withOutput(new Text("love"), new IntWritable(2))
			
			.withOutput(new Text("of"), new IntWritable(1))		

			.withOutput(new Text("the"), new IntWritable(1));
		driver.runTest();
			

		
	}
}
