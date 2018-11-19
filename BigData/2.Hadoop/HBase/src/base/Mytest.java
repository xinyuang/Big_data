package base;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.Test;

public class Mytest {
	@Test
	public void testGet() throws Exception{
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "192.168.118.113");
		Connection connection = ConnectionFactory.createConnection(conf);
		Admin admin = connection.getAdmin();
		HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("mytable9"));
		
		//2、指定列族
		htd.addFamily(new HColumnDescriptor("info"));
		htd.addFamily(new HColumnDescriptor("grade"));
		
		//创建表
		admin.createTable(htd);
		
		//关闭客户端
		admin.close();
		
	}

}
