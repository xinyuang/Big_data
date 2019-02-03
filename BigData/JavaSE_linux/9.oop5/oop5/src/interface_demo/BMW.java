package interface_demo;

public class BMW extends Car{
	
	public BMW(Engine engine) {
		this.engine = engine;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("BMW is running");
	}

}
