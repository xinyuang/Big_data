package serializable.MR_serialize;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class SalaryTotalReducer extends Reducer<IntWritable, Emp, IntWritable, IntWritable>{
	@Override
	protected void reduce(IntWritable k3, Iterable<Emp> v3,
			Reducer<IntWritable, Emp, IntWritable, IntWritable>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int total = 0;
		for(Emp v:v3) {
			total = total + v.getSal();
		}
		context.write(k3, new IntWritable(total));
	}
}
