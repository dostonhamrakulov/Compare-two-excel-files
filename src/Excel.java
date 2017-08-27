//import statements
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

// hashmap test class
public class Excel {

	public static void main(String args[]) {

		HashMap<Integer,String> hashMap = new HashMap<Integer,String>(); 

		hashMap.put(91, "India");
		hashMap.put(34, "Spain");
		hashMap.put(63, "Philippines");
		hashMap.put(41, "Switzerland");

		// sorting elements
		System.out.println("Unsorted HashMap: " + hashMap);
		TreeMap<Integer,String> sortedHashMap = new TreeMap<Integer,String>(hashMap);
		System.out.println("Sorted HashMap: " + sortedHashMap);

		// hashmap empty check
		boolean isHashMapEmpty = hashMap.isEmpty();
		System.out.println("HashMap Empty: " + isHashMapEmpty);

		// hashmap size
		System.out.println("HashMap Size: " + hashMap.size());

		// hashmap iteration and printing
		Iterator<Integer> keyIterator = hashMap.keySet().iterator();
		while(keyIterator.hasNext()) {
			Integer key = keyIterator.next();
			System.out.println("Code=" + key + "  Country=" + hashMap.get(key));
		}

		// searching element by key and value
		System.out.println("Does HashMap contains 91 as key: " + hashMap.containsKey(91));
		System.out.println("Does HashMap contains India as value: " + hashMap.containsValue("India"));

		// deleting element by key
		Integer key = 91;
		Object value = hashMap.remove(key);
		System.out.println("Following item is removed from HashMap: " + value);

		// searching element by key and value
		System.out.println("\n\nDoes HashMap contains 91 as key: " + hashMap.containsKey(91));
		System.out.println("Does HashMap contains India as value: " + hashMap.containsValue("India"));

	}

}
//
//Java Hashmap key value example:
//
//
//public void processHashMap() {
//	//add keys->value pairs to a hashmap:
//	HashMap hm = new HashMap();
//	hm.put(1, "godric gryfindor");
//	hm.put(2, "helga hufflepuff");
//	hm.put(3, "rowena ravenclaw");
//	hm.put(4, "salazaar slytherin");
//
//	//Then get data back out of it:
//	LinkedList ll = new LinkedList();
//	Iterator itr = hm.keySet().iterator();
//	while(itr.hasNext()) {
//		String key = itr.next();
//		ll.add(key);
//	}
//
//	System.out.print(ll);  //The key list will be printed.
//}