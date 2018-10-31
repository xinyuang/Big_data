package totalSalary;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class salaryReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>{
	@Override
	protected void reduce(IntWritable k3, Iterable<IntWritable> v3,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int total = 0;
		for(IntWritable v:v3) {
			total = total + v.get();
		}
		context.write(k3, new IntWritable(total));
	}

}
