package threadpool;

public class task implements Runnable{
	private int taskNum;
	public task(int taskNum) {
		this.taskNum = taskNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task running" + taskNum);
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task" + taskNum + "finish!");
	}
	
}
