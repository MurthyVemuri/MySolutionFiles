import java.util.Scanner;

class Node {

	private Object data;
	private Node next;
	private Node prev;

	public Node() {
		next = null;
		prev = null;
		data = 0;
	}

	public Node(Object data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public void setLinkNext(Node next) {
		this.next = next;
	}

	public void setLinkPrev(Node prev) {
		this.prev = prev;
	}

	public Node getLinkNext() {
		return this.next;
	}


	public Node getLinkPrev() {
		return this.prev;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

}


class linkedList {
	private Node start;
	private Node end ;
	public int size;

	public linkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public boolean isEmpty() {
		return start == null;
	}

	public int getSize() {
		return size;
	}

	public void insertAtStart(Object value) {

		Node temp = new Node(value, null, null);
		if(start == null) {
			start = temp;
			end = start;
		}else {
			start.setLinkPrev(temp);
			temp.setLinkNext(start);
			start = temp;
		}
		size++;

	}

	public void insertAtEnd(Object value) {

		Node temp = new Node(value, null, null);
		if(start == null) {
			start = temp;
			end = start;
		}else{
			temp.setLinkPrev(end);
			end.setLinkNext(temp);
			end = temp;
		}
		size++;
	}

	public void insertAtPos(Object value , int pos) {

		Node temp = new Node(value, null, null);
		if (pos == 1) {
			insertAtStart(value);
			return;
		}

		Node ref = start;
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node tmp = ref.getLinkNext();
				ref.setLinkNext(temp);
				temp.setLinkPrev(ref);
				temp.setLinkNext(tmp);
				tmp.setLinkPrev(temp);
			}
			ref = ref.getLinkNext();
		}
		size++ ;
	}

	public void deleteAtPos(int pos) {

		if (pos == 1) {
			if (size == 1) {
				start = null;
				end = null;
				size = 0;
				return; 
			}

			start = start.getLinkNext();
			start.setLinkPrev(null);
			size--; 
			return ;
		}

		if (pos == size) {
			end = end.getLinkPrev();
			end.setLinkNext(null);
			size--;
		}

		Node temp = start.getLinkNext();
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node p = temp.getLinkPrev();
				Node n = temp.getLinkNext();
				p.setLinkNext(n);
				n.setLinkPrev(p);
				size-- ;
				return;
			}
		temp = temp.getLinkNext();
		}
	}    

	public void display(){

		if (size == 0) {
			System.out.print("empty");
			return;
		}
		if (start.getLinkNext() == null){
			System.out.println(start.getData() );
			return;
		}
		Node temp = start;
		System.out.print(start.getData()+ " <-> ");
		temp = start.getLinkNext();
		while (temp.getLinkNext() != null) {
			System.out.print(temp.getData()+ " <-> ");
			temp = temp.getLinkNext();
		}
		System.out.print(temp.getData()+ "\n");
	}
}


public class DoublyLinkedList {
	public static void main(String[] args) { 
		linkedList list = new linkedList();
		linkedList listString = new linkedList();
		linkedList listFloat = new linkedList(); 
		Scanner scan = new Scanner(System.in);
		String record = scan.nextLine();
		if(record.equals("I")) {
			do {
				System.out.println("\nDoubly Linked List Operations\n");
				System.out.println("1. insert at begining");
				System.out.println("2. insert at end");
				System.out.println("3. insert at position");
				System.out.println("4. delete at position");
				System.out.println("5. check empty");
				System.out.println("6. get size");
				System.out.println("7. delete at first");
				System.out.println("8. delete at end");
				int choice = scan.nextInt();
				switch (choice) {

					case 1 :
						System.out.println("Enter element to insert");
						list.insertAtStart( scan.nextInt() );
						break;

					case 2 :
						System.out.println("Enter element to insert");
						list.insertAtEnd( scan.nextInt() );
						break;

					case 3 :
						System.out.println("Enter element to insert");
						int num = scan.nextInt() ;
						System.out.println("Enter position");
						int pos = scan.nextInt() ;
						if (pos < 1 || pos > list.getSize() )
						System.out.println("Invalid position\n");
						else
						list.insertAtPos(num, pos);
						break;

					case 4 :
						System.out.println("Enter position");
						int p = scan.nextInt() ;
						if (p < 1 || p > list.getSize() )
						System.out.println("Invalid position\n");
						else
						list.deleteAtPos(p);
						break;

					case 5 :
						System.out.println(list.isEmpty());
						break;

					case 6 :
						System.out.println(list.getSize());
						break;

					case 7:
						list.deleteAtPos(1);
						break;

					case 8:
						list.deleteAtPos(list.getSize());
						break;	
					
					default :
						System.out.println("Invalid input");
						break;
				}
				list.display();
				if(choice >= 9)
				break;
			} while (true);
		}else if(record.equals("S") || record.equals("C")) {
			do {
				System.out.println("\nDoubly Linked List Operations\n");
				System.out.println("1. insert at begining");
				System.out.println("2. insert at end");
				System.out.println("3. insert at position");
				System.out.println("4. delete at position");
				System.out.println("5. check empty");
				System.out.println("6. get size");
				System.out.println("7. delete at first");
				System.out.println("8. delete at end");
				int choice = scan.nextInt();
				switch (choice) {

					case 1 :
						System.out.println("Enter element to insert");
						listString.insertAtStart( scan.nextInt() );
						break;

					case 2 :
						System.out.println("Enter element to insert");
						listString.insertAtEnd( scan.nextInt() );
						break;

					case 3 :
						System.out.println("Enter element to insert");
						String num = scan.next() ;
						System.out.println("Enter position");
						int pos = scan.nextInt() ;
						if (pos < 1 || pos > listString.getSize() )
						System.out.println("Invalid position\n");
						else
						listString.insertAtPos(num, pos);
						break;

					case 4 :
						System.out.println("Enter position");
						int p = scan.nextInt() ;
						if (p < 1 || p > listString.getSize() )
						System.out.println("Invalid position\n");
						else
						listString.deleteAtPos(p);
						break;

					case 5 :
						System.out.println(listString.isEmpty());
						break;

					case 6 :
						System.out.println(listString.getSize());
						break;

					case 7:
						listString.deleteAtPos(1);
						break;

					case 8:
						listString.deleteAtPos(listString.getSize());
						break;		

					default :
						System.out.println("Invalid input");
						break;
				}
				listString.display();
				if(choice >= 9)
				break;
			} while (true);
		}else if(record.equals("F")) {
			do {
				System.out.println("\nDoubly Linked List Operations\n");
				System.out.println("1. insert at begining");
				System.out.println("2. insert at end");
				System.out.println("3. insert at position");
				System.out.println("4. delete at position");
				System.out.println("5. check empty");
				System.out.println("6. get size");
				System.out.println("7. delete at first");
				System.out.println("8. delete at end");
				int choice = scan.nextInt();
				switch (choice) {

					case 1 :
						System.out.println("Enter element to insert");
						listFloat.insertAtStart( scan.nextInt() );
						break;

					case 2 :
						System.out.println("Enter element to insert");
						listFloat.insertAtEnd( scan.nextInt() );
						break;

					case 3 :
						System.out.println("Enter element to insert");
						int num = scan.nextInt() ;
						System.out.println("Enter position");
						int pos = scan.nextInt() ;
						if (pos < 1 || pos > listFloat.getSize() )
						System.out.println("Invalid position\n");
						else
						listFloat.insertAtPos(num, pos);
						break;

					case 4 :
						System.out.println("Enter position");
						int p = scan.nextInt() ;
						if (p < 1 || p > listFloat.getSize() )
						System.out.println("Invalid position\n");
						else
						listFloat.deleteAtPos(p);
						break;

					case 5 :
						System.out.println(listFloat.isEmpty());
						break;

					case 6 :
						System.out.println(listFloat.getSize());
						break;

					case 7:
						listFloat.deleteAtPos(1);
						break;

					case 8:
						listFloat.deleteAtPos(listFloat.getSize());
						break;		

					default :
						System.out.println("Invalid input");
						break;
				}
				listFloat.display();
				if(choice >= 9)
				break;
			} while (true);
		}

	}

}
