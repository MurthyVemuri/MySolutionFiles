import java.util.*;

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

	public void modifyValue(int index , int elevalue) {
		heapArray[index] = elevalue;
		siftDown(index);
		siftUp(index);
	}

	public void removedElements(int kthValue) {
		int index = curIndex;
		for(int i = 1; i <= index; i++) {
			int outVal = deleteMin();
			if(kthValue == i ){
				System.out.print(outVal);
				break;
			}
		}
	}
}

public class AssessmentTwoProblemOne {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		HeapDemo hd = new HeapDemo(size+1);
		String outputValues = scan.nextLine();
		int kthValue = Integer.parseInt(scan.nextLine());
		StringTokenizer st = new StringTokenizer(outputValues,",");
		while(st.hasMoreTokens()) {
			hd.insert(Integer.parseInt(st.nextToken()));
		}
		hd.removedElements(kthValue);
	}
}
