package revertedIndex;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class revertedIndexReducer extends Reducer<Text, Text, Text, Text>{
	protected void reduce(Text k3, Iterable<Text> v3, Context context) throws java.io.IOException ,InterruptedException {
		String str = "";
		for (Text t : v3) {
			str = "(" + t.toString() + ")" + str;
		}
		context.write(k3, new Text(str));
	}
}
