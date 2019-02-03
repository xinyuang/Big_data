package selfjoin;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class selfjoinReducer extends Reducer<IntWritable, Text, Text, Text>{
	protected void reduce(IntWritable k3, Iterable<Text> v3, Context context) throws java.io.IOException ,InterruptedException {
		String bossName = "";
		String empNameList = "";
		
		for(Text v:v3) {
			String str = v.toString();
			int index = str.indexOf("*");
			if(index >= 0) {
				bossName = str.substring(1);
			} else {
				empNameList = str + ";" + empNameList;
			}
		}
		if(bossName.length() > 0 && empNameList.length() > 0) {
			context.write(new Text(bossName), new Text(empNameList));
		}
		
	}

}
