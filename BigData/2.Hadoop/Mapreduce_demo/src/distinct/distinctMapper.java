package distinct;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class distinctMapper extends Mapper<LongWritable, Text, Text, NullWritable>{
	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String data = value1.toString();
		
		String[] words = data.split(",");
		context.write(new Text(words[2]), NullWritable.get());
	}
}
