package MRpartition;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class myPartitionerReducer extends Reducer<IntWritable, Emp, IntWritable, Emp>{
	@Override
	protected void reduce(IntWritable k3, Iterable<Emp> v3,
			Reducer<IntWritable, Emp, IntWritable, Emp>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		for(Emp e:v3) {
			context.write(k3, e);
		}
		
	}
}
