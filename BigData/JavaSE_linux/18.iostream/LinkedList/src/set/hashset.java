package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String>  hs = new HashSet<String>();
		hs.add("a");
		hs.add("b");
		hs.add("b");
		hs.add("c");
		hs.add("b");
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			String tem = it.next();
			System.out.println(tem);
			System.out.println(tem.hashCode());
		}
	}

}
