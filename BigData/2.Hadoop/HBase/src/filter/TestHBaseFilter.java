package filter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

public class TestHBaseFilter {
	@Test
	public void testSingleColumnValueFilter() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable table = new HTable(conf, "emp");
		
		SingleColumnValueFilter filter = new SingleColumnValueFilter(
											Bytes.toBytes("empinfo"), 
											Bytes.toBytes("sal"), 
											CompareOp.EQUAL, 
											Bytes.toBytes("3000"));
		Scan scan = new Scan();
		scan.setFilter(filter);
		ResultScanner rs = table.getScanner(scan);
		for(Result r:rs) {
			String name = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("ename")));
			System.out.println(name);
		}
		table.close();
	}
	
	
	@Test
	public void testColumnPrefixFilter() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable table = new HTable(conf, "emp");
		
		ColumnPrefixFilter filter = new ColumnPrefixFilter(Bytes.toBytes("ename"));
		Scan scan = new Scan();
		scan.setFilter(filter);
		ResultScanner rs = table.getScanner(scan);
		for(Result r:rs) {
			String name = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("ename")));
			String sal = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("sal")));
			System.out.println(name);
			System.out.println(sal);
		}	
		table.close();
	}
	
	
	@Test
	public void testMultipleCloumnPrefixFilter() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable table = new HTable(conf, "emp");
		
		byte[][] names = {Bytes.toBytes("ename"),Bytes.toBytes("sal")};
		
		MultipleColumnPrefixFilter filter = new MultipleColumnPrefixFilter(names);
		Scan scan = new Scan();
		scan.setFilter(filter);
		ResultScanner rs = table.getScanner(scan);
		for(Result r:rs) {
			String name = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("ename")));
			String sal = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("sal")));
			System.out.println(name);
			System.out.println(sal);
		}	
		table.close();
	}
	
	@Test
	public void testRowFilter() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable table = new HTable(conf, "emp");
		
		RowFilter filter = new RowFilter(CompareOp.EQUAL,
										new RegexStringComparator("7839"));
		Scan scan = new Scan();
		scan.setFilter(filter);
		ResultScanner rs = table.getScanner(scan);
		for(Result r:rs) {
			String name = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("ename")));
			String sal = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("sal")));
			System.out.println(name);
			System.out.println(sal);
		}	
		table.close();
	}
	
	@Test
	public void testFilter() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.quorum", "bigdata113");		
		
		//得到一个客户端
		HTable table = new HTable(conf, "emp");
		SingleColumnValueFilter filter1 = new SingleColumnValueFilter(
				Bytes.toBytes("empinfo"), 
				Bytes.toBytes("sal"), 
				CompareOp.EQUAL, 
				Bytes.toBytes("3000"));		
		ColumnPrefixFilter filter2 = new ColumnPrefixFilter(Bytes.toBytes("ename"));
		FilterList list = new FilterList(Operator.MUST_PASS_ALL);
		list.addFilter(filter1);
		list.addFilter(filter2);
		Scan scan = new Scan();
		scan.setFilter(list);
		ResultScanner rs = table.getScanner(scan);
		for(Result r:rs) {
			String name = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("ename")));
			String sal = Bytes.toString(r.getValue(Bytes.toBytes("empinfo"), Bytes.toBytes("sal")));
			System.out.println(name);
			System.out.println(sal);
		}	
		table.close();
	}
	
}
