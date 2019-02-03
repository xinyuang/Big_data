package thread;

public class threadRunnable implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			long id = Thread.currentThread().getId();
			String name = Thread.currentThread().getName();
			System.out.println("name" + name + "---->" + id);
		}
	}

}
