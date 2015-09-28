/*Module 21: Problem 1 using MyHashtable */

import java.util.*;
import java.io.*;
import java.util.*;


class MyHashnode<K,V> {

	final K key;
	V data;
	MyHashnode<K,V> next;
	final int hash;
	

	public MyHashnode(K key, V value, MyHashnode<K,V> next, int hash){
		this.key = key;
		this.data = value;
		this.next = next;
		this.hash = hash;
		
	}
}


class MyHashtable<K,V> {

	private MyHashnode<K,V>[] nodes;
	List<K> keys;
	Set<K> keySet;

	@SuppressWarnings("unchecked")
	public MyHashtable(int size){
		nodes = new MyHashnode[size];
		keys = new ArrayList<K>();
		keySet = new HashSet<K>();
	}

	private int myHashFunction(K key){
		int hash = key.hashCode() % nodes.length;
		if(hash < 0){
			hash = hash + nodes.length;
		}
		return hash;
	}

	public V insert(K key, V data){
		int hash = myHashFunction(key);

		for(MyHashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if((hash == node.hash) && key.equals(node.key)){
				V oldData = node.data;
				node.data = data;
				return oldData;
			}
		}
		MyHashnode<K,V> node = new MyHashnode<K,V>(key, data, nodes[hash], hash);
		keySet.add(key);
		keys.add(key);
		nodes[hash] = node;
		return null;
	}

	public boolean containsKey(K key) {
		int hash = myHashFunction(key);
		MyHashnode<K,V> previous = null;
		for(MyHashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if((hash == node.hash) && key.equals(node.key)){
				return true;
			}
			previous = node;    
		}
		return false;
	}

	public boolean remove(K key){
		int hash = myHashFunction(key);
		MyHashnode<K,V> previous = null;
		for(MyHashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if((hash == node.hash) && key.equals(node.key)){
				if(previous != null){
					previous.next = node.next;
				}else{
					nodes[hash] = node.next;
				}
				return true;
			}
			//previous = node;    
		}
		return false;
	}

	public V get(K key){
		int hash = myHashFunction(key);

		for(MyHashnode<K,V> node = nodes[hash]; node != null; node = node.next){
			if(key.equals(node.key))
				return node.data;
			}
		return null;
	}


}

class Heap {
	
	private int[] heapArray;
	private int arraySize;
	private int curIndex;
	List<Integer> resultArray;

	Heap(int size) {
		curIndex = 0;
		arraySize = size;
		heapArray = new int[size];
		resultArray = new ArrayList<Integer>();
	}

	public List<Integer> getList() {
		return resultArray;
	}

	public void insert(int element) {
		if(curIndex < arraySize) {
			curIndex++;
			heapArray[curIndex] = element;
			siftUp(curIndex);
		}
	}

	private void siftUp(int n) {
		if( n == 1 || heapArray[n/2] >= heapArray[n]) {
			return;
		}
		swap(n,n/2);
		siftUp(n/2);
	}

	public int deleteMin() {
		int result = 0;
		if(curIndex > 0) {
			result = heapArray[1];
			heapArray[1] = heapArray[curIndex];
			curIndex--;
			siftDown(1);
		}
		return result;
	}

	public void siftDown(int value) {
		int m;
		if((2*value) <= curIndex) {
			if( ((2 * value) + 1) > curIndex || heapArray[2*value] >= heapArray[(2*value) + 1] )
				m = 2*value;
			else
				m = (2*value) + 1;

			if(heapArray[value] < heapArray[m])
				swap(value,m);
			siftDown(m);
		}
	}

	private void swap(int a ,int b) {
		int temp = 0;
		temp = heapArray[a];
		heapArray[a] = heapArray[b];
		heapArray[b] = temp;
	}

	

	public void removedElements() {
		int newIndex = curIndex;
		for(int i = 1; i <= newIndex; i++) {
			resultArray.add(deleteMin());
		}
	}
}

class WordFrequency {

	Heap heap = new Heap(1000);
	MyHashtable<String, Integer> table;

	public WordFrequency() {
		table = new MyHashtable<String, Integer>(1000);
	}

	public void getWordFrequency() {
		try {
			Scanner input = new Scanner(new FileInputStream("in.txt"));
			while (input.hasNextLine()) {
				String word;
				StringTokenizer st = new StringTokenizer(input.nextLine());
				while (st.hasMoreTokens()) {
					word = st.nextToken().toLowerCase();
					if (!(table.containsKey(word)) ) {
						table.insert(word , 1);						
					} else {
						int countwords = (table.get(word) );
						table.insert(word , countwords + 1);
					}
					// System.out.println(word + " " + table.get(word));
				}
			}
			input.close();
		} catch(Exception ex) {}
	}


	public void printFrequencies() {
		List<String> enums = table.keys;
		for(String wordKey: enums) {
			int a = table.get(wordKey);
			// System.out.println(wordKey + " " + a);
			heap.insert(a);
		}
		heap.removedElements();
	}

	public void getAllOutput() {
		Set<String> key_All = table.keySet;
		for(String key_name: key_All) {
		for(int i = 0; i < 5 ; i++) {
				if((heap.resultArray.get(i)) == (table.get(key_name)) ) {
					System.out.println(key_name + " " + heap.resultArray.get(i));
					break;
				}
				
			}
		}
	}
}


public class HashTableGeneric {
	public static void main(String[] args) {
		WordFrequency wf = new WordFrequency();
		wf.getWordFrequency();
		wf.printFrequencies();
		wf.getAllOutput();
	}
}


