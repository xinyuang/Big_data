package map;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashTable_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("10000", "ct");
		ht.put("10086", "mv");
		ht.put("10010", "un");
		System.out.println("hashtable:" + ht);
		Set<String> set = ht.keySet();
		for (String s : set) {
			System.out.println(ht.get(s));
		}
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(ht.get(it.next()));
		}
		
		Enumeration<String> enu = ht.keys();
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
		Collection cs = ht.values();
		Iterator it1 = cs.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		Iterator it2 = ht.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry<String, String> m = (Map.Entry<String, String>) it2.next();
			System.out.println(m.getValue()+ m.getKey());
		}
		System.out.println(ht.containsKey("10000"));
		System.out.println(ht.containsKey("10010"));
	}

}
