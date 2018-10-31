package WC;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class wordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	@Override
	protected void reduce(Text k3, Iterable<IntWritable> v3,
			Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int total = 0;
		for(IntWritable v:v3) {
			total = total + v.get();
		}
		context.write(k3, new IntWritable(total));
	}
}
