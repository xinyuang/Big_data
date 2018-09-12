package string_api;

public class demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function();
		
	}
	
	public static void function() {
		byte[] bytes = {97,98,99};
		String s = new String(bytes);
		System.out.println(s);
		
		String s1 = new String(bytes, 1, 2);
		System.out.println(s1);
	}

}
