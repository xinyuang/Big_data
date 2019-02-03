package multitask_2.copy;
/**
 * 
 * @author xinyu
 *
 */
public class SaleTicket {
	public static void main(String[] args) {
		Ticket tk = new Ticket(100);
		Thread th = new Thread(tk);
		th.setName("窗口1");
		Thread th2 = new Thread(tk);
		th2.setName("窗口2");
		th.start();
		th2.start();
	}

}
