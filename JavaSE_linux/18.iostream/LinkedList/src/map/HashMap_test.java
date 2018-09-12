package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMap_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, User> hm = new HashMap<String, User>();
		hm.put("110", new User("TZ", 23));
		hm.put("111", new User("sy", 18));
		hm.put("112", new User("xy", 24));
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			System.out.println(hm.get(key));
		}
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String Key = it.next();
			User user = hm.get(Key);
			System.out.println(user);
		}
	}

}
