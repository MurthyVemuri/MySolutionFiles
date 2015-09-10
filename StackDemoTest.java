import java.util.Scanner;

class Node {
	
	private Node next;
	private int value;

	public Node() {
		next = null;
		value = 0;
	}

	public Node(int value) {
		this.value = value;
		next = null;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

class StackTest {
	
	Node head;
	int size;

	public StackTest() {
		head = new Node(0);
		size = -1;
	}

	public void push(int data) {
		Node temp = new Node(data);
		Node current = head;

		while(current.getNext()!= null) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}

	public int getTop() {
		if(size == -1){
			return 0;
		}else {
			Node current = head;
			return current.getNext().getValue();
		}
	}

	public void pop(){
		if (size == -1) {
			System.out.println("Stack is underflow");
		} else {
			Node current = head;
			current.setNext(current.getNext().getNext());
			size--; 
		}
	}

	public String toString() {
		Node current = head.getNext();
		String output = "";

		while (current != null) {
			output +=  current.getValue() + " ";
			current = current.getNext();
		}
		return output;
	}
}

public class StackDemoTest {
	public static void main(String[] args) {
		StackTest stackTest = new StackTest();
		StackTest stackTestNegative = new StackTest();

		Scanner scan = new Scanner(System.in);
		String full = scan.nextLine();
		String array[] = full.split(",");

		for(int i = 0; i < array.length; i++) {
			String record[] = array[i].split(" ");
			
			if(record[0].equals("push")) {
				int val = Integer.valueOf(record[1]);
				if(val > 0) {
					stackTest.push(val);
				}else {
					stackTestNegative.push(val);
				}
			}else if(record[0].equals("pop")){
				int check = (int)stackTest.getTop();
				if(check > 0){	
					stackTest.pop();
				}else {
					stackTestNegative.pop();
				}
			}
		}
		System.out.print(stackTest);
		System.out.print(stackTestNegative);
	}
}

/* inputs are : push 1,pop,push -2,push -3,push -4,push 5,push 6,pop*/
