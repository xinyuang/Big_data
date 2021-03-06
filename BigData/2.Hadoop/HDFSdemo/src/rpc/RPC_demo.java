package rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class RPC_demo {
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		RPC.Builder builder = new RPC.Builder(new Configuration());
		builder.setBindAddress("192.168.1.113");
		builder.setPort(7789);
		
		builder.setProtocol(MyInterface.class);
		builder.setInstance(new MyInterfaceImpl());
		
		Server server = builder.build();
		
		server.start();
	}

}
