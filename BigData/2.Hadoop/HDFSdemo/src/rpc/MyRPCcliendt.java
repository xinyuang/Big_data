package rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class MyRPCcliendt {
	public static void main(String[] args) throws IOException {
		MyInterface proxy = RPC.getProxy(MyInterface.class,
				                                 MyInterface.versionID, 
				                                 new InetSocketAddress("192.168.1.113", 7789),
				                                 new Configuration());
		
		String result = proxy.sayHello("tom");
		System.out.println(result);
	}
}