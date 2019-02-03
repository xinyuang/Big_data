package multitask_2.copy;
/**
 * 
 * @author xinyu
 * 同步方法
 *
 */
public class Ticket implements Runnable{

	private int total;
	public Ticket(int total) {
		this.total = total;
	}
	public synchronized void sellTicket() {
		if(total>0) {
			total--;
			String name = Thread.currentThread().getName();
			System.out.println(name + "selling ticket, left: " + total);
		} else {
			System.out.println("done");
		}

	}
	
	
	
	
	@Override
	public void run() {
		while(total>0) {
			sellTicket();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
