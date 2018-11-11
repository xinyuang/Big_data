package equal_join;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class equaljoinMapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String data = value1.toString();
		String[] words = data.split(",");
		if(words.length == 3) {
			context.write(new IntWritable(Integer.parseInt(words[0])), new Text("*" + words[1]));
		} else {
			context.write(new IntWritable(Integer.parseInt(words[7])), new Text(words[1]));
		}
	}
}
