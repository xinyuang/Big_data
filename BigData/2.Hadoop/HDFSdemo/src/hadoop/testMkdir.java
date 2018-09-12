package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class testMkdir {
	@Test
	public void testMkdir() throws Exception{
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		FileSystem client = FileSystem.get(conf);
		client.mkdirs(new Path("/folder1"));
		client.close();
	}


	@Test
	public void testMkdir2() throws Exception{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		FileSystem client = FileSystem.get(conf);
		client.mkdirs(new Path("/folder222"));
		client.close();
	}
}
