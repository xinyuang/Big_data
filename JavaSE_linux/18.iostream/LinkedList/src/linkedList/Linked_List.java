package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class Linked_List {
	public static void main(String[] args) {
		LinkedList<String> linkedlist1 = new LinkedList<String>();
		linkedlist1.add("a");
		linkedlist1.add("b");
		linkedlist1.add("c");
		linkedlist1.add("d");
		Iterator it = linkedlist1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		List list2 = linkedlist1.subList(2, 4);
		System.out.println(list2);
	}
}
