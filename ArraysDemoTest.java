// Unbounded arrays

import java.util.*;

class ArraysConcept<E> {

	public int alpha;
	public int beta; 
	private E[] values;
	private int size;
	private int curIndex;
	private ArrayList<Integer> capacity;

	public void setAlpha(int a) {
		alpha = a;
	}

	public void setBeta(int b) {
		beta = b;
	}

	@SuppressWarnings("unchecked")
	public ArraysConcept(int arraySize) {
		capacity = new ArrayList<Integer>();
		size = arraySize;
		curIndex = 0;
		values = (E[])new Object[size];
		capacity.add(size);
	}

	public void addValue(E e) {
		if(curIndex == size) {
			growArray(beta * curIndex);
		}
			values[curIndex] = e;
			curIndex++;
	}


	public void removeValue() { 
			curIndex--;
			if( (alpha*curIndex)<=size && (curIndex > 0)) {
				int mul = (beta * curIndex);
				growArray(mul);
			}
	}

	@SuppressWarnings("unchecked")
	private void growArray(int nsize) {
		E[] t = (E[])new Object[nsize];
		System.arraycopy(values , 0 , t , 0 , curIndex);
		values = t;
		size = nsize;
		capacity.add(size);
	}

	public void printCapacity() {
		
		for (int i =0; i < capacity.size() - 1;i++ ) {
			System.out.print(capacity.get(i) + ",");
		}
		System.out.println(capacity.get(capacity.size() - 1));
	}
}

public class ArraysDemoTest {
	public static void main(String[] args) {
		ArraysConcept<Integer> arraysConceptIntegers = new ArraysConcept<Integer>(1);
		Scanner scan = new Scanner(System.in);
		String output = scan.nextLine();
		String numbers[] = output.split(",");
		
		arraysConceptIntegers.setBeta(Integer.valueOf(numbers[0]));
		arraysConceptIntegers.setAlpha(Integer.valueOf(numbers[1]));
		int j = 8;
		String outputFunctions = scan.nextLine();
		String record[] = outputFunctions.split(",");

		for(int i = 0 ; i < record.length; i++) {
			if(record[i].equals("push")){
				arraysConceptIntegers.addValue(j++);
			}else if(record[i].equals("pop")) {
				arraysConceptIntegers.removeValue();
			}
		}
		arraysConceptIntegers.printCapacity();
	}
}
