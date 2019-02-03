package sellTicket;

public class sell {
	public static void main(String[] args) {
		Ticket tk = new Ticket(100);
		Thread thtk = new Thread(tk);
		thtk.setName("窗口1");


		Thread thtk2 = new Thread(tk);
		thtk2.setName("窗口2");
		thtk2.start();
		thtk.start();
		for (int i = 0; i < 10; i++) {
			long id = Thread.currentThread().getId();
			String name = Thread.currentThread().getName();
			System.out.println(name + "--->" + id);
		}
	}
}
