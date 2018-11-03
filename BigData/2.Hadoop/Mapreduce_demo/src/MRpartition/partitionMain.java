package MRpartition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class partitionMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(partitionMain.class);
		
		job.setMapperClass(myPartitionerMapper.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Emp.class);
		
		job.setPartitionerClass(partitioner.class);
		job.setNumReduceTasks(3);
		
		job.setReducerClass(myPartitionerReducer.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Emp.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}

}
