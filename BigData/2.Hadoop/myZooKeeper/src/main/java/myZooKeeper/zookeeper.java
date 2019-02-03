package myZooKeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class zookeeper {
	private static int NUMBER = 10;
	private static void getNumber() {
		System.out.println("*******start job************");
		System.out.println("current value: " + NUMBER);
		NUMBER --;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("*******job done************");
}

	public static void main(String[] args) {
		RetryPolicy policy = new ExponentialBackoffRetry(1000, 10);
		CuratorFramework cf = CuratorFrameworkFactory.builder()
								.connectString("192.168.137.111:2181")
								.retryPolicy(policy)
								.build();
		cf.start();
		
		final InterProcessMutex lock = new InterProcessMutex(cf,"/mylock");
		
		
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable(){
				public void run() {
					try {
						lock.acquire();
						getNumber();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						try {
							lock.release();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}).start();
		}
	}
}