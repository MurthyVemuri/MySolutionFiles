import java.util.*;
import java.io.*;

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

	@SuppressWarnings("unchecked")
	public MyHashtable(int size){
		nodes = new MyHashnode[size];
		keys = new ArrayList<K>();
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

public class AssessmentProblemOne {
	public static void main(String[] args) {
		MyHashtable<String,Integer> table = new MyHashtable<String,Integer>(100);
		Scanner scan = new Scanner(System.in);
		String outValue = scan.nextLine();
		StringTokenizer st = new StringTokenizer(outValue , ",");
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (!(table.containsKey(word)) ) {
				table.insert(word , 1);						
			} else {
				int countwords = (table.get(word) );
				table.insert(word , countwords + 1);
			}
		}
		List<String> allWords = table.keys;
		for(String wordKey: allWords) {
			int a = table.get(wordKey);
			if(a >= 2)
				System.out.print(wordKey + " ");

		}
	}
}
