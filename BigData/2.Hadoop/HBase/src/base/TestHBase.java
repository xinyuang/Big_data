package base;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

public class TestHBase {
	@Test
	public void testCreateTable() throws Exception{
		//创建表
		//配置ZooKeeper地址
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "192.168.118.113");
		
		//得到一个HBase的客户端
		HBaseAdmin client = new HBaseAdmin(conf);
		
		//采用：面向对象的思想来建表
		//1、指定表的描述符
		HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("mytable10"));
		
		//2、指定列族
		htd.addFamily(new HColumnDescriptor("info"));
		htd.addFamily(new HColumnDescriptor("grade"));
		
		//创建表
		client.createTable(htd);
		
		//关闭客户端
		client.close();
	}
	
	@Test
	public void testPutData() throws Exception{
		//插入数据
		//配置ZooKeeper地址
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable client = new HTable(conf, "student");
		
		//构造一个Put对象：一条数据
		Put put = new Put(Bytes.toBytes("id001"));
		
		//指定列的值
		/*
		put.addColumn(family,   列族的名字
		               qualifier,  列的名字
		               value)   值
		*/
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("Ted"));
		
		// 一次插入多条记录client.put(List);
		
		client.put(put);
		
		client.close();
	}
	
	@Test
	public void testGetData() throws Exception{
		//查询数据:指定Rowkey
		//配置ZooKeeper地址
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable client = new HTable(conf, "student");
		
		//构造一个Get对象
		Get get = new Get(Bytes.toBytes("stu1"));
		
		//执行查询: 相当于  select * from mytable where rowkey=???
		Result r = client.get(get);
		
		//输出:注意：HBase中，没有数据的类型，所有类型都是二进制
		String name = Bytes.toString(r.getValue(Bytes.toBytes("info"), Bytes.toBytes("name")));
		System.out.println("名字是：" + name);
		
		client.close();
	}

	@Test
	public void testScanData() throws Exception{
		//查询数据
		//配置ZooKeeper地址
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable client = new HTable(conf, "student");
		
		//定义一个扫描器
		Scan scan = new Scan();
		//过滤器：scan.setFilter(filter)
		
		//通过扫描器查询所有的数据
		//相当于：JDBC：ResultSet
		ResultScanner rs = client.getScanner(scan);
		
		//输出
		for(Result r:rs){
			String name = Bytes.toString(r.getValue(Bytes.toBytes("info"), Bytes.toBytes("name")));
			System.out.println("名字是：" + name);			
		}
		
		client.close();
	}
}
