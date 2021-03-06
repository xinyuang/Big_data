package HDFS_mkdir_up_download;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class TestUpload {
	@Test
	public void testMkdir() throws Exception{
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		FileSystem client = FileSystem.get(conf);
		InputStream input = new FileInputStream("C:\\Users\\xinyu\\Dropbox\\gg\\Job_hunting\\big data\\BigData\\2.Hadoop\\jar\\avro-1.7.4.jar");
		OutputStream output = client.create(new Path("/folder113/a.jar"));
		
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=input.read(buffer)) > 0) {
			output.write(buffer,0,len);
		}
		output.flush();
		input.close();
		output.close();
		client.close();
	}	
	
	@Test
	public void testMkdir4() throws Exception{
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		FileSystem client = FileSystem.get(conf);
		InputStream input = new FileInputStream("C:\\Users\\xinyu\\Dropbox\\gg\\Job_hunting\\big data\\BigData\\2.Hadoop\\jar\\avro-1.7.4.jar");
		OutputStream output = client.create(new Path("/folder114/a.jar"));
		
		IOUtils.copyBytes(input, output, 1024);
		client.close();
	}
	
	@Test
	public void testDownload() throws Exception{
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		FileSystem client = FileSystem.get(conf);
		InputStream input = client.open(new Path("/folder114/a.jar"));
				
		OutputStream output = new FileOutputStream("C:\\Users\\xinyu\\Dropbox\\gg\\Job_hunting\\big data\\BigData\\2.Hadoop\\tmp\\c.jar");
		IOUtils.copyBytes(input, output, 1024);	
	}
	
	@Test
	public void testDataNode() throws Exception{
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		DistributedFileSystem fs = (DistributedFileSystem) FileSystem.get(conf);
		DatanodeInfo[] list = fs.getDataNodeStats();
		for(DatanodeInfo info:list) {
			System.out.println(info);
		}
	}
	
	@Test
	public void testFileBlockLocation() throws Exception{
		System.setProperty("HADOOP_USER_NAME", "root");
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.113:9000");
		
		FileSystem client = FileSystem.get(conf);
		
		FileStatus fileStatus = client.getFileStatus(new Path("/folder114/a.jar"));
		
		
		BlockLocation[] locations = client.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
		for(BlockLocation loc:locations) {
			System.out.println(Arrays.toString(loc.getHosts()) + '/' + Arrays.toString(loc.getNames()));
		}
	}
}
