import java.util.*;
import java.io.*;

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
	Hashtable<String,Integer> table;

	public WordFrequency() {
		table = new Hashtable<String,Integer>();
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
						table.put(word , 1);						
					} else {
						int countwords = (table.get(word) );
						table.put(word , countwords + 1);
					}
				}
			}
			input.close();
		} catch(Exception ex) {}
	}


	public void printFrequencies() {
		Enumeration<String> enums = table.keys();
		while (enums.hasMoreElements()) {
			String word = enums.nextElement();
			int a = table.get(word);
			System.out.println(word + " " + a);
			heap.insert(a);
		}
		heap.removedElements();
	}

	public void getAllOutput() {
		Set<String> key_All = table.keySet();
		for(int i = 0; i < 5 ; i++) {
		for(String key_name: key_All) {
				if((heap.resultArray.get(i)).equals(table.get(key_name)) ) {
					System.out.println(key_name + " " + heap.resultArray.get(i));
				}
			}
		}
	}
}


public class FrequencyTest {
	public static void main(String[] args) {
		WordFrequency wf = new WordFrequency();
		wf.getWordFrequency();
		wf.printFrequencies();
		wf.getAllOutput();
	}
}
