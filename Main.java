
public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer,Integer> map = new MyHashMap<>();
		System.out.println("Should be True ===== " + map.isEmpty()); 
		map.printTable();
		
		map.put(21, 30);
		map.put(68, 25);
		map.put(24, 40);
		map.put(70, 20);
		map.put(40, 22);
		map.put(100, 10);
		map.put(151, 21);
		map.put(1, 2);
		map.put(30, 5);
		
		System.out.println();
		System.out.println(map.keySet());
		System.out.println();
		System.out.println("Should be True ===== " + map.containsKey(21)); 
		System.out.println("Should be True ===== " + map.containsKey(68));
		System.out.println("Should be True ===== " + map.containsKey(24));
		System.out.println("Should be True ===== " + map.containsKey(70));
		System.out.println("Should be True ===== " + map.containsKey(40));
		System.out.println("Should be True ===== " + map.containsKey(100));
		System.out.println("Should be True ===== " + map.containsKey(151));
		System.out.println("Should be True ===== " + map.containsKey(1));
		System.out.println("Should be True ===== " + map.containsKey(30));
		
		System.out.println("Should be False ===== " + map.containsKey(42));
		System.out.println("Should be False ===== " + map.containsKey(9));
		System.out.println("Should be False ===== " + map.containsKey(11));	
		System.out.println("Should be False ===== " + map.containsKey(0));
		System.out.println("Should be False ===== " + map.containsKey(-2));
		System.out.println("Should be 30 ===== " + map.get(21));
		
		map.put(21, 7);
		System.out.println("Should be False ===== " + map.containsValue(30));
		System.out.println("Should be True ===== " + map.containsKey(21));
		System.out.println("Should be True ===== " + map.containsValue(7));
		System.out.println("Should be 7 ===== " + map.get(21));

		System.out.println("Should be True ===== " + map.containsValue(7)); 
		System.out.println("Should be True ===== " + map.containsValue(20));
		System.out.println("Should be True ===== " + map.containsValue(40));
		System.out.println("Should be True ===== " + map.containsValue(10));
		System.out.println("Should be True ===== " + map.containsValue(2));
		System.out.println("Should be True ===== " + map.containsValue(5));
		System.out.println("Should be True ===== " + map.containsValue(25));
		System.out.println("Should be True ===== " + map.containsValue(22));
		System.out.println("Should be True ===== " + map.containsValue(21));

		System.out.println("Should be False ===== " + map.containsValue(1));
		System.out.println("Should be False ===== " + map.containsValue(29));
		System.out.println("Should be False ===== " + map.containsValue(31));	
		System.out.println("Should be False ===== " + map.containsValue(12));
		System.out.println("Should be False ===== " + map.containsValue(-2));
		
		System.out.println("Should be False ===== " + map.isEmpty());

		System.out.println("Should be 9 ==== " +map.size());
		map.put(140, 99);
		System.out.println("Should be 10 ==== " +map.size());
		map.put(150, 111);
		System.out.println("Should be 11 ==== " +map.size());
		map.remove(68);
		System.out.println("Should be False ===== " + map.containsValue(25));
		System.out.println("Should be True ===== " + map.containsValue(111));
		System.out.println("Should be 10 ==== " +map.size());
		map.remove(140);
		System.out.println("Should be 9 ==== " +map.size());
		
		System.out.println();
		map.printTable();
		System.out.println();

		map.clear();
		System.out.println("Should be True ===== " + map.isEmpty());
		System.out.println();

		System.out.println("Should be empty table");
		map.printTable();
		  
	} 
}
