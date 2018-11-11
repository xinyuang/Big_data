package MRunit;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class wordCountMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		//1. create task
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(wordCountMain.class);
		
		//2. set map and output type
		job.setMapperClass(wordCountMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setSortComparatorClass(MyTextComparator.class);
		
		job.setCombinerClass(wordCountReducer.class);
		
		//3. set reduce and output type
		job.setReducerClass(wordCountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//4. set input path, output path
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//5. Execute job
		job.waitForCompletion(true);
	}

}
