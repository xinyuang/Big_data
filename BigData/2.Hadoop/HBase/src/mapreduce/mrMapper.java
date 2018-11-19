package mapreduce;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mrMapper extends TableMapper<Text, IntWritable>{
	@Override
	protected void map(ImmutableBytesWritable key, Result value,
			org.apache.hadoop.mapreduce.Mapper<ImmutableBytesWritable, Result, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String data = Bytes.toString(value.getValue(Bytes.toBytes("content"), Bytes.toBytes("info")));
		String[] words = data.split(" ");
		for(String w:words) {
			context.write(new Text(w), new IntWritable(1));
		}
	}

}
