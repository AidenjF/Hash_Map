/**
 * file: MyHashMap.java
 * class: CSC210
 * instructor: David Claveau
 * author: Aiden Foster
 * purpose: The purpose of this file is to implement a HashTable using a dynamic array
 */
import java.util.*;

public class MyHashMap<K, V> {
	HashTable<K, V> ht;
	
	/**
	 * This is the constructor for the hash table that we will use
	 */
	public MyHashMap() {
		ht = new HashTable<>();
	}
	
	/**
	 * This method calls the put method from the hash table class
	 * @param key :this the key of the values
	 * @param value :this is the value of the key
	 * @return this returns a value of the key is already in use
	 */
	public V put(K key, V value) {
		return ht.put(key, value);
	}
	
	/**
	 * This method calls the get method from the hash table class
	 * @param key :this the key of the values
	 * @return this returns the value if there is a key there
	 */
	public V get(K key) {
		return ht.get(key);
	}
	
	/**
	 * This method checks if the map has a value in it
	 * @param value :this is the value of the key
	 * @return true or false depending on if it is there or not
	 */
	public boolean containsValue(V value) {
		return ht.containsValue(value);
	}
	
	/**
	 * This method checks if the map has a key in it
	 * @param key :this is the key
	 * @return true or false depending on if it is there or not
	 */
	public boolean containsKey(K key) {
		return ht.containsKey(key);
	}
	
	/**
	 * This method checks if the map is empty or not
	 * @return true or false depending on if there is values in it
	 */
	public boolean isEmpty() {
		return ht.isEmpty();
	}
	
	/**
	 * This method returns the size of the hash table
	 * @return the integer of the size
	 */
	public int size() {
		return ht.size();
	}
	
	/**
	 * This method removes a key and value if it is there
	 * @param key is the key we want to have removed
	 * @return the value that was removed
	 */
	public V remove(K key) {
		return ht.remove(key);
	}
	
	/**
	 * This method makes the entire hash table empty
	 */
	public void clear() {
		ht.clear();
	}
	
	/**
	 * This method returns a set of all the keys that are in the hash table
	 * @return a set of keys
	 */
	public java.util.Set<K> keySet() {
		return ht.keySet();
	}
	
	/**
	 * This method prints out the hash table that we were told to print out
	 */
	public void printTable() {
		ht.printTable();
	}
}


class Node<K,V> {
	K key;
	V value;
	/**
	 * This is the constructor that creates the nodes with a key and value
	 * @param key is the key we want to use
	 * @param value is the value we want to use
	 */
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class HashTable<K,V> {
	
	final static int TABLE_SIZE	= 8;
	ArrayList<LinkedList<Node<K,V>>> hashTable = new ArrayList<>(TABLE_SIZE);
	java.util.Set<K> setOfKeys = new HashSet<>();
	java.util.Set<V> setOfValues = new HashSet<>();
	
	/**
	 * This method creates a hash table full of linked list
	 */
	public HashTable() {
		for(int i=0; i < TABLE_SIZE; i++) {
			hashTable.add(new LinkedList<Node<K,V>>());
		}
	}
	
	/**
	 * This method created a specific hash code for each value
	 * @param key is the key we will manipulate
	 * @return the hash code
	 */
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % TABLE_SIZE;
		return Math.abs(index);
	}
	
	/**
	 * This method calls the put method from the hash table class
	 * @param key :this the key of the values
	 * @param value :this is the value of the key
	 * @return this returns a value of the key is already in use
	 */
	public V put(K key, V value) {
		int index = hash(key);
		boolean flag = false;
		Node<K,V> node = new Node<>(key,value);
		if(hashTable.get(index).size() != 0) {
			var list = hashTable.get(index);
			for(Node<K,V> nodeTwo : list) {
				if(nodeTwo.key == key) {
					flag = true;
					V valueToReturn = nodeTwo.value;
					setOfValues.remove(nodeTwo.value);
					nodeTwo.value = value;
					setOfValues.add(nodeTwo.value);
					return valueToReturn;
				}
			}
		}
		if(!flag) {
			hashTable.get(index).addFirst(node);
			setOfKeys.add(node.key);		
			setOfValues.add(node.value);

		}
		return null;
	}
	
	/**
	 * This method calls the get method from the hash table class
	 * @param key :this the key of the values
	 * @return this returns the value if there is a key there
	 */
	public V get(K key) {
		int index = hash(key);
		var list = hashTable.get(index);
		for(Node<K,V> node : list) {
			if(node.key == key) {
				return node.value;
			}
		}
		return null;
	}
	
	/**
	 * This method checks if the map has a value in it
	 * @param value :this is the value of the key
	 * @return true or false depending on if it is there or not
	 */
	public boolean containsValue(V value) {
		if(setOfValues.contains(value)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if the map has a key in it
	 * @param key :this is the key
	 * @return true or false depending on if it is there or not
	 */
	public boolean containsKey(K key) {
		if(setOfKeys.contains(key)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if the map is empty or not
	 * @return true or false depending on if there is values in it
	 */
	public boolean isEmpty() {
		for(int i=0; i<TABLE_SIZE;i++) {
			var list = hashTable.get(i);
			if(list.size() != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method returns the size of the hash table
	 * @return the integer of the size
	 */
	public int size() {
		int totalSize = 0;
		for(int i=0; i<TABLE_SIZE;i++) {
			var list = hashTable.get(i);
			totalSize += list.size();
		}
		return totalSize;
	}
	
	/**
	 * This method removes a key and value if it is there
	 * @param key is the key we want to have removed
	 * @return the value that was removed
	 */
	public V remove(K key) {
		int index = hash(key);
		var list = hashTable.get(index);
		if(list.size() != 0) {
			for(Node<K,V> node: list) {
				if(key.equals(node.key)) {
					V valueToRemove = node.value;
					setOfValues.remove(node.value);
					setOfKeys.remove(node.key);
					list.remove(node);
					return valueToRemove;
				}
			}
		}
		return null;
	}
	
	/**
	 * This method makes the entire hash table empty
	 */
	public void clear() {
		for(int i=0; i<TABLE_SIZE;i++) {
			var list = hashTable.get(i);
			list.clear();

		}
		setOfKeys.clear();
		setOfValues.clear();
	}
	
	/**
	 * This method returns a set of all the keys that are in the hash table
	 * @return a set of keys
	 */
	public java.util.Set<K> keySet() {
		return setOfKeys;
	}
	
	/**
	 * This method prints out the hash table that we were told to print out
	 */
	public void printTable() {
		int totalConflicts = 0;
		for(int i=0; i<TABLE_SIZE;i++) {
			System.out.print("Index " +i+ ": ");
			var list = hashTable.get(i);
			if(list.size() <= 1)
				System.out.print("(0 conflicts), [");
			else {
				System.out.print("(" +String.valueOf(list.size()-1)+ " conflicts), [");
				totalConflicts += list.size()-1;
			}
			for(Node<K,V> node: list) { 
				System.out.print(node.key+", ");
			}
			System.out.print("]");
			System.out.println();
		}
		System.out.println("Total # of conflicts: " + totalConflicts);
	}
}