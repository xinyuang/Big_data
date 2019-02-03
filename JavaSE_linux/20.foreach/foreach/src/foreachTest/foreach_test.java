package foreachTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class foreach_test {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("1");
		s.add("2");
		s.add("22");
		s.add("23");
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		s.forEach(temps->{
			System.out.println(temps);
		});
		
	}
}
