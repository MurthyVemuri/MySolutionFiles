import java.util.Scanner;

class HeapDemo {
	
	int[] heapArray;
	int arraySize;
	int curIndex;
	int newIndex;

	HeapDemo(int size) {
		curIndex = 0;
		arraySize = size;
		heapArray = new int[size];
	}

	public void insert(int element) {
		if(curIndex < arraySize) {
			curIndex++;
			heapArray[curIndex] = element;
			newIndex = curIndex;
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

			if(heapArray[value] > heapArray[m])
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

	public void modifyValue(int index , int elevalue) {
		heapArray[index] = elevalue;
		siftDown(index);
		siftUp(index);
	}

/*	public void removedElements() {
		int index = curIndex;
		System.out.println("After sorting");
		for(int i = 1; i <= index; i++) {
			System.out.print(deleteMin() + " ");
		}
	}*/

	public void display() {
		for (int i = 1;i <= curIndex ; i++ ) {
			System.out.print(heapArray[i] + " ");
		}
	}
}

public class HeapTest {
	public static void main(String[] args) {
		HeapDemo heapObject = new HeapDemo(100);
		int count = 0;
		Scanner scan = new Scanner(System.in);
		String out = scan.nextLine();
		String[] function = out.split(",");
		for(int i = 0; i <function.length;i++) {
			function[i] = function[i].trim();
		}
		for(int i = 0; i <function.length;i++) {

			if( function[i].contains("i") ) {
				String[] forI = function[i].split(" ");
				int num = Integer.parseInt(forI[1]);
				heapObject.insert(num);
				heapObject.display();
				System.out.println();

			}else if(function[i].contains("mo")) {
				String[] modI = function[i].split(" ");
				int ind = Integer.parseInt(modI[1]);
				int nVal = Integer.parseInt(modI[2]);
				heapObject.modifyValue(ind , nVal);
				heapObject.display();
				System.out.println();

			}else if(function[i].equals("d")){
				heapObject.deleteMin();
				heapObject.display();
				System.out.println();
			}else
				break;
		}
	}
}
