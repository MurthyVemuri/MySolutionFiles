class Node {

	private int key;
	private Object keyData;
	private Node next;

	Node(int key, Object keyData) {
		this.key = key;
		this.keyData = keyData;
		this.next = null;
	}

	public Object getKeyData() {
		return keyData;
	}

	public void setKeyData(Object keyData) {
		this.keyData = keyData;
	}

	public int getKey() {
		return key;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}




class HashMapDemo {
	private final static int maxSize = 1000;
	Node[] table;

	HashMapDemo() {
		table = new Node[maxSize];
		for (int i = 0; i < maxSize; i++)
			table[i] = null;
	}

	public Object getDataFromKey(int key) {
		int hash = (key % maxSize);
		if (table[hash] == null)
			return -1;
		else {
			Node data = table[hash];
			while (data != null && data.getKey() != key)
				data = data.getNext();
			if (data == null)
				return -1;
			else
				return data.getKeyData();
		}
	}

	public void putKeyAndData(int key, Object keyData) {
		int hash = (key % maxSize);

		if (table[hash] == null)
			table[hash] = new Node(key, keyData);
		else {
			Node data = table[hash];
			while (data.getNext() != null && data.getKey() != key)
				data = data.getNext();

			if (data.getKey() == key)
				data.setKeyData(keyData);
			else
				data.setNext(new Node(key, keyData));
		}
	}

	public void removeKey(int key) {
		int hash = (key % maxSize);
		if (table[hash] != null) {
			Node prevEntry = null;
			Node data = table[hash];
			while (data.getNext() != null && data.getKey() != key) {
				prevEntry = data;
				data = data.getNext();
			}
			if (data.getKey() == key) {
				if (prevEntry == null)
					table[hash] = data.getNext();
				else
					prevEntry.setNext(data.getNext());
			}
		}
	}
}

public class HashDemoTest {
	public static void main(String[] args) {
		HashMapDemo hmd = new HashMapDemo();
		hmd.putKeyAndData(8,"96");
		hmd.putKeyAndData(10,"43");
		hmd.putKeyAndData(6,"72");
		hmd.putKeyAndData(2,"68");
		hmd.putKeyAndData(8,"63");
		hmd.putKeyAndData(6,"28");

		System.out.println(hmd.getDataFromKey(8) );
		System.out.println(hmd.getDataFromKey(10) );
		System.out.println(hmd.getDataFromKey(6) );
		System.out.println(hmd.getDataFromKey(2) );
	}
}
