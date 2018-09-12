package rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyInterface extends VersionedProtocol{
	
	public static long versionID = 1;
	
	public String sayHello(String name);
	
}
