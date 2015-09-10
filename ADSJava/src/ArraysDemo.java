import java.util.Scanner;


class ArraysConcept<E> {

	public E[] values;
	private int size;
	private int curIndex;
	private int count;

	
	@SuppressWarnings("unchecked")
	public ArraysConcept(int arraySize) {
		size = arraySize;
		curIndex = -1;
		count = 0;
		values = (E[])new Object[size];
	}

	public void addValue(E e) {
		if(curIndex % 4 == 0) {
			growArray();
		}
		curIndex++;
		values[curIndex] = e;
		count++;
	}

	public void removeValueElement(E e) {
		for (curIndex = 0; curIndex < values.length; curIndex++) {
			if (e == values[curIndex] || e.equals(values[curIndex])) {
				break;
			}
		}
		if(curIndex == values.length) {
			System.out.println("Array is empty");
		}else {
			while(curIndex < values.length - 1) {
				values[curIndex] = values[curIndex + 1];
				curIndex++;
			}
			count--;
		}
	}

	public void removeValue() {
		removeValueElement(values[curIndex]);
		curIndex--;
	}

	@SuppressWarnings("unchecked")
	private void growArray() {
		E[] t = (E[])new Object[values.length * 2];
		System.arraycopy(values , 0 , t , 0 , values.length);
		values = t;
	}

	public void getSize() {
		System.out.println(count);
	}

	public void getCapacity() {
		System.out.println(values.length);
	}

	public void printValues() {
		if(curIndex == 0) {
			System.out.println("Array is empty");
		}
		for (int i = 0; i < curIndex + 1; ++i) {
			if(values[i]!=null){
				System.out.print(values[i] + " ");
			}
		}
	}
}

public class ArraysDemo {
	public static void main(String[] args) {
		ArraysConcept<Integer> ac = new ArraysConcept<Integer>(4);
		ArraysConcept<Float> acf = new ArraysConcept<Float>(4);
		ArraysConcept<String> acs = new ArraysConcept<String>(4);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String record = scan.nextLine();
		if(record.equals("I")) {
			while(true) {
				String function = scan.next();
				if(function.equals("push")){
					int num = scan.nextInt();
					ac.addValue(num);
				}else if(function.equals("pop")) {
					ac.removeValue();
				}else if(function.equals("size")){
					ac.getSize();
				}else if(function.equals("capacity")) {
					ac.getCapacity();
				}else if(function.equals("print")) {
					ac.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		} else if(record.equals("F")) {
			while(true) {
				String function = scan.next();
				if(function.equals("push")){
					float num = scan.nextFloat();
					acf.addValue(num);
				}else if(function.equals("pop")) {
					acf.removeValue();
				}else if(function.equals("size")){
					acf.getSize();
				}else if(function.equals("capacity")) {
					acf.getCapacity();
				}else if(function.equals("print")) {
					acf.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		} else if(record.equals("S") || record.equals("C")) {
			while(true) {
				String function = scan.next();
				if(function.equals("push")){
					String num = scan.next();
					acs.addValue(num);
				}else if(function.equals("pop")) {
					acs.removeValue();
				}else if(function.equals("size")){
					acs.getSize();
				}else if(function.equals("capacity")) {
					acs.getCapacity();
				}else if(function.equals("print")) {
					acs.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		}
	}
}