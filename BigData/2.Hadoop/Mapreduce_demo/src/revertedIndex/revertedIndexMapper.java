package revertedIndex;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class revertedIndexMapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key1, Text value1, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String path = ((FileSplit)context.getInputSplit()).getPath().toString();
		int index = path.lastIndexOf("/");
		String fileName = path.substring(index + 1);
		
		String data = value1.toString();
		String[] words = data.split(" ");
		
		for(String word:words) {
			context.write(new Text(word + ":" + fileName), new Text("1"));
		}
	}
}
