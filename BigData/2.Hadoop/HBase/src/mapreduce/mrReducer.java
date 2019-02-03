package mapreduce;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class mrReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable>{
	
	@Override
	protected void reduce(Text k3, Iterable<IntWritable> v3,
			org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, ImmutableBytesWritable, Mutation>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int total = 0;
		for(IntWritable v:v3) {
			total = total + v.get();
		}
		
		Put put = new Put(Bytes.toBytes(k3.toString()));
		put.add(Bytes.toBytes("content"),
				Bytes.toBytes("result"),
				Bytes.toBytes(String.valueOf(total)));
		
		context.write(new ImmutableBytesWritable(Bytes.toBytes(k3.toString())) , put);
		
		
	}
	
	}
