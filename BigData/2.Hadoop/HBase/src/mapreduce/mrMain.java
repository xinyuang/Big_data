package mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;


public class mrMain {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");	
		
		Job job = Job.getInstance(conf);
		job.setJarByClass(mrMain.class);
		
		Scan scan = new Scan();
		scan.addColumn(Bytes.toBytes("content"), Bytes.toBytes("info"));
		TableMapReduceUtil.initTableMapperJob(Bytes.toBytes("word"),
												scan, 
												mrMapper.class, 
												Text.class, 
												IntWritable.class,
												job);
		
		TableMapReduceUtil.initTableReducerJob("stat",
												mrReducer.class,
												job);
		
		job.waitForCompletion(true);
	}
}
