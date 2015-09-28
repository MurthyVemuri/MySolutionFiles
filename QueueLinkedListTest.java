import java.util.*;

class MyLinkedList {

	private Node head;
	private int listCount;


	public MyLinkedList() {

		head = new Node(null);
		listCount = 0;
	}

	public void addElementLast(Object data){
		Node temp = new Node(data);
		Node current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(temp);
		listCount++;
	}

	// Inserting node at a given Index position
	public void add(Object data, int index){
		Node temp = new Node(data);
		Node current = head;

		for (int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}

		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}

	public void addElementFirst(Object data){
		Node temp = new Node(data);
		Node current = head;

		for (int i = 1; i < 1 && current.getNext() != null; i++) {
			current = current.getNext();
		}

		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}


	//Object value of the given Index position.
	public Object get(int index){
		if (index <= 0)
			return null;

		Node current = head.getNext();
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;

			current = current.getNext();
		}
		return current.getData();
	}

	public void getAfterElement(Object data , Object newData) {
		Node temp = new Node(newData);
		Node current = head.getNext();
		Node ref = null;
		boolean flag = false;
		while(current != null) {
			if(current.getData().equals(data)) {
				ref = current;
				flag = true;
				break;
			}
			current = current.getNext();
		}
		if(flag) {
			temp.setNext(current.getNext());
			ref.setNext(temp);
		}

		listCount++;
	}

	public void getBeforeElement(Object data , Object newData) {
		Node temp = new Node(newData);
		Node current = head;
		Node ref = null;
		boolean flag = false;
		while(current != null) {
			if(current.getNext().getData().equals(data)) {
				ref = current;
				flag = true;
				break;
			}
			current = current.getNext();
		}
		if(flag) {
			temp.setNext(current.getNext());
			ref.setNext(temp);
		}
		listCount++;
	}

	public void remove(int index){
		if (index < 1 || index > size())
			System.out.println("Invalid Index");

		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				System.out.println("Invalid Index");
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
	}

	public int size(){
		return listCount;
	}


	public String toString() {
		Node current = head.getNext();

		String output = "";
		if(current == null) 
			return "LinkedList is empty";

		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
}

class Node {

	Node next;
	Object data;

	public Node(Object dataValue) {
		next = null;
		data = dataValue;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object dataValue) {
		data = dataValue;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node nextValue) {
		next = nextValue;
	}
}


public class QueueLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList linkedlist = new MyLinkedList();
		MyLinkedList linkedlistIntegers = new MyLinkedList();
		MyLinkedList linkedlistFloat = new MyLinkedList();
		Scanner scan = new Scanner(System.in);

		String record = scan.nextLine();
		if(record.equals("S")) {
			do{
				System.out.println("1. PushBack ");
				System.out.println("2. LinkedList size ");
				System.out.println("3. PopFront");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						String value = scan.next();
						linkedlist.addElementLast(value);
					break;

					case 2:
						System.out.println(linkedlist.size());
					break;

					case 3:
						linkedlist.remove(1);
					break;

					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlist);
				if(choice >= 4) {
					break;
				}
			} while(true);
		}else if(record.equals("I")) {
			do{
				System.out.println("1. PushBack ");
				System.out.println("2. LinkedList size ");
				System.out.println("3. PopFront");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						String value = scan.next();
						linkedlistIntegers.addElementLast(value);
					break;

					case 2:
						System.out.println(linkedlistIntegers.size());
					break;

					case 3:
						linkedlistIntegers.remove(1);
					break;

					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlistIntegers);
				if(choice >= 11) {
					break;
				}
			} while(true);
		} else if(record.equals("F")) {
			do{
				System.out.println("1. PushBack ");
				System.out.println("2. LinkedList size ");
				System.out.println("3. PopFront");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						String value = scan.next();
						linkedlistFloat.addElementLast(value);
					break;

					case 2:
						System.out.println(linkedlistFloat.size());
					break;

					case 3:
						linkedlistFloat.remove(1);
					break;

					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlistFloat);
				if(choice >= 11) {
					break;
				}
			} while(true);
		}

	}
}
