package set;

import java.util.Iterator;
import java.util.TreeSet;

public class treeSet {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("b");
		ts.add("c");
		ts.add("a");
		ts.add("0");
		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
