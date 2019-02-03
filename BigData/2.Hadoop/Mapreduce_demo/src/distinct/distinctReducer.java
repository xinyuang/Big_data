package distinct;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class distinctReducer extends Reducer<Text, NullWritable, Text, NullWritable>{
	protected void reduce(Text k3, Iterable<NullWritable> v3, Context context) throws java.io.IOException ,InterruptedException {
		context.write(k3, NullWritable.get());
	}
}
