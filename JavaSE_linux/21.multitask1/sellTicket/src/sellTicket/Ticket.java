package sellTicket;

public class Ticket implements Runnable{
	private int total;
	Ticket(int total) {
		this.total = total;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(total>0) {
			if(total > 0) {
				total--;
				String name = Thread.currentThread().getName();
				System.out.println(name + "正在售票， 还有余票" + total);
			}
		}
	}

}
