package selfjoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class selfjoinMapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String data = value1.toString();
		
		String[] words = data.split(",");
		
		context.write(new IntWritable(Integer.parseInt(words[0])), new Text("*" + words[1]));
		context.write(new IntWritable(Integer.parseInt(words[3])), new Text(words[1]));
	}
}
