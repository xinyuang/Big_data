package notify_wait;

public class Wait_Notify {
	public static Object mutex = new Object();
	public static void main(String[] args) {
		thread2 td2 = new thread2();
		thread1 td1 = new thread1();
		Thread th2 = new Thread(td2);
		Thread th1 = new Thread(td1);
		th2.setName("线程2---有wait");
		th2.start();
		try { 
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		th1.start();
		th1.setName("线程1--有notify");
	}



static class thread1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
			synchronized (mutex) {
				mutex.notify();
				System.out.println(Thread.currentThread().getName() + "调用了notify");
				
			}	
			System.out.println(Thread.currentThread().getName() + "释放了锁");
	}

}

static class thread2 implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (mutex) {
			try {
			mutex.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "获取了锁");
			
		}
		
	}

}
}