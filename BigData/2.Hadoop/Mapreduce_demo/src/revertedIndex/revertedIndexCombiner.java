package revertedIndex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class revertedIndexCombiner extends Reducer<Text, Text, Text, Text>{
@Override
protected void reduce(Text k21, Iterable<Text> v21, Reducer<Text, Text, Text, Text>.Context context)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	int total = 0;
	for (Text v:v21) {
		total = total + Integer.parseInt(v.toString());
	}
	String data = k21.toString();
	int index = data.indexOf(":");
	String word = data.substring(0, index);
	String fileName = data.substring(index + 1);
	
	context.write(new Text(word), new Text(fileName + ":" + total));
	}
}
