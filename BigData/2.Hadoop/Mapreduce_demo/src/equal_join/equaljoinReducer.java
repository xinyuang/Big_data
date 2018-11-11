package equal_join;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class equaljoinReducer extends Reducer<IntWritable, Text, Text, Text>{
	@Override
	protected void reduce(IntWritable k3, Iterable<Text> v3, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String dname = "";
		String ename_list = "";
		
		for(Text v:v3) {
			String str = v.toString();
			int index = str.indexOf("*");
			if (index == 0) {
				dname = str.substring(1);
			} else {
				ename_list = str + ";" + ename_list;
			}
		}
		
		context.write(new Text(dname), new Text(ename_list));
	}
}
