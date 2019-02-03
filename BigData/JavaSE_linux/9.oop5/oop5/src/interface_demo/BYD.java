package interface_demo;

public class BYD extends Car{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("BYD is running");
	} 
	public BYD(Engine engine) {
		this.engine = engine;
	}
}
