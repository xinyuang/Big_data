package string;

public class string_api {
	public static void main(String[] args) {
//		function();
		int count = function2();
		System.out.println(count);
		System.out.println("ses");
	}
	public static void function() {
		String str = "itstar.com";
		boolean b = str.contains("it");
		System.out.println(b);
		int idx = str.indexOf("s");
		System.out.println(idx);
		byte[] bs = str.getBytes();
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i]);
		}
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		String s2 = "itstar";
		boolean equal = str.equals(s2);
		System.out.println(equal);
	}
	public static int function2() {
		String s = "abc_abc+sg+abcslkfjabc";
		int count = 0;
		int idx = 0;
		String key = "abc";
		while ((idx = s.indexOf(key)) != -1) {
			count++;
			s = s.substring(idx + key.length());
		}
		return count;
	}
}
