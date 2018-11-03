package sort.MR;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class EmpMain {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(EmpMain.class);
		
		job.setMapperClass(EmpMapper.class);
		job.setMapOutputKeyClass(Emp.class);
		job.setMapOutputValueClass(NullWritable.class);
		
		job.setOutputKeyClass(Emp.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}

}
