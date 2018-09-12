package stringBuffer;

public class stringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "my_email@qq.com";
		System.out.println(checkEmail(s));
	}
	public static void function() {
		StringBuffer s = new StringBuffer();
		StringBuffer buffer = s.append(7);
		buffer.append("qowieu");
		System.out.println(buffer);
		
	}
	public static boolean checkEmail(String email) {
		return email.matches("[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-z]+)+");
		
	}
}
