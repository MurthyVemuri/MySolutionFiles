import java.util.*;

class MyLinkedList {

	private Node head;
	private int listCount;


	public MyLinkedList() {

		head = new Node(null);
		listCount = 0;
	}

	//adding a node to the last i.e before the null value.
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
		System.out.println("Index " + index + "is removed");
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


public class LinkedListTest {

	public static void main(String[] args) {
		MyLinkedList linkedlist = new MyLinkedList();
		MyLinkedList linkedlistIntegers = new MyLinkedList();
		MyLinkedList linkedlistFloat = new MyLinkedList();
		Scanner scan = new Scanner(System.in);

		String record = scan.nextLine();
		if(record.equals("S")) {
			do{
				System.out.println("1. PushBack ");
				System.out.println("2. Adding a value in given position");
				System.out.println("3. PushFront");
				System.out.println("4. Remove value at given index");
				System.out.println("5. LinkedList size ");
				System.out.println("6. Value at a particular position");
				System.out.println("7. PopBack ");
				System.out.println("8. PopFront");
				System.out.println("9. Add After element");
				System.out.println("10. Add Before element");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						String value = scan.next();
						linkedlist.addElementLast(value);
					break;

					case 2:
						String valueIndex = scan.next();
						int index = scan.nextInt();
						linkedlist.add(valueIndex , index);
					break;

					case 3:
						String elementFirst = scan.next();
						linkedlist.addElementFirst(elementFirst);
					break;

					case 4:
						int removeIndex = scan.nextInt();
						linkedlist.remove(removeIndex);
					break;

					case 5:
						System.out.println(linkedlist.size());
					break;

					case 6:
						int indexVal = scan.nextInt();
						System.out.println(linkedlist.get(indexVal));
					break;

					case 7:
						linkedlist.remove(linkedlist.size());
					break;	

					case 8:
						linkedlist.remove(1);
					break;

					case 9:
						String presentObject = scan.next();
						String newObject = scan.next(); 
						linkedlist.getAfterElement(presentObject , newObject);	
					break;

					case 10:
						String currentObject = scan.next();
						String givenObject = scan.next(); 
						linkedlist.getBeforeElement(currentObject , givenObject);	
					break;

					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlist);
				if(choice >= 11) {
					break;
				}
			} while(true);
		}else if(record.equals("I")) {
			do{
				System.out.println("1. PushBack ");
				System.out.println("2. Adding a value in given position");
				System.out.println("3. PushFront");
				System.out.println("4. Remove value at given index");
				System.out.println("5. LinkedList size ");
				System.out.println("6. Value at a particular position");
				System.out.println("7. PopBack ");
				System.out.println("8. PopFront");
				System.out.println("9. Add After element");
				System.out.println("10. Add Before element");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						int value = scan.nextInt();
						linkedlistIntegers.addElementLast(value);
					break;

					case 2:
						int valueIndex = scan.nextInt();
						int index = scan.nextInt();
						linkedlistIntegers.add(valueIndex , index);
					break;

					case 3:
						int elementFirst = scan.nextInt();
						linkedlistIntegers.addElementFirst(elementFirst);
					break;

					case 4:
						int removeIndex = scan.nextInt();
						linkedlistIntegers.remove(removeIndex);
					break;

					case 5:
						System.out.println(linkedlist.size());
					break;

					case 6:
						int indexVal = scan.nextInt();
						System.out.println(linkedlistIntegers.get(indexVal));
					break;

					case 7:
						linkedlistIntegers.remove(linkedlistIntegers.size());
					break;	

					case 8:
						linkedlistIntegers.remove(1);
					break;

					case 9:
						int presentObject = scan.nextInt();
						int newObject = scan.nextInt(); 
						linkedlistIntegers.getAfterElement(presentObject , newObject);	
					break;

					case 10:
						int currentObject = scan.nextInt();
						int givenObject = scan.nextInt(); 
						linkedlistIntegers.getBeforeElement(currentObject , givenObject);	
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
				System.out.println("2. Adding a value in given position");
				System.out.println("3. PushFront");
				System.out.println("4. Remove value at given index");
				System.out.println("5. LinkedList size ");
				System.out.println("6. Value at a particular position");
				System.out.println("7. PopBack ");
				System.out.println("8. PopFront");
				System.out.println("9. Add After element");
				System.out.println("10. Add Before element");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						Float value = scan.nextFloat();
						linkedlistFloat.addElementLast(value);
					break;

					case 2:
						Float valueIndex = scan.nextFloat();
						int index = scan.nextInt();
						linkedlistFloat.add(valueIndex , index);
					break;

					case 3:
						Float elementFirst = scan.nextFloat();
						linkedlistFloat.addElementFirst(elementFirst);
					break;

					case 4:
						int removeIndex = scan.nextInt();
						linkedlistFloat.remove(removeIndex);
					break;

					case 5:
						System.out.println(linkedlistFloat.size());
					break;

					case 6:
						int indexVal = scan.nextInt();
						System.out.println(linkedlistFloat.get(indexVal));
					break;

					case 7:
						linkedlistFloat.remove(linkedlistFloat.size());
					break;	

					case 8:
						linkedlistFloat.remove(1);
					break;

					case 9:
						Float presentObject = scan.nextFloat();
						Float newObject = scan.nextFloat(); 
						linkedlistFloat.getAfterElement(presentObject , newObject);	
					break;

					case 10:
						Float currentObject = scan.nextFloat();
						Float givenObject = scan.nextFloat(); 
						linkedlistFloat.getBeforeElement(currentObject , givenObject);	
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


/*
	public static void main(String[] args) {
		MyLinkedList linkedlist = new MyLinkedList();
		MyLinkedList linkedlist1 = new MyLinkedList();

		linkedlist.addElementLast("1");
		linkedlist.addElementLast("2");
		linkedlist.addElementLast("3");
		linkedlist.addElementLast("4");
		linkedlist.addElementLast("5");

		linkedlist1.addElementLast("1");
		linkedlist1.addElementLast("2");
		linkedlist1.addElementLast("3");
		linkedlist1.addElementLast("4");
		linkedlist1.addElementLast("5");

		System.out.println("Print linkedlist: " + linkedlist);

		System.out.println("Print linkedlist size: " + linkedlist.size());

		System.out.println("Get 3rd element: " + linkedlist.get(3));

		linkedlist.remove(2);

		System.out.println("Get 3rd element: " + linkedlist.get(3));
		System.out.println("Print linkedlist size: " + linkedlist.size());
		System.out.println("Print linkedlist: " + linkedlist);
	}

*/