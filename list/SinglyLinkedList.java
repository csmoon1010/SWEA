public class SinglyLinkedList {
	
	static Node head = null;
	public static void main(String[] args) throws Exception
	{
		addToLast(1);
		addToFirst(2);
		addToLast(3);
		add(4, head);
		addToFirst(5);
		delete(head);
		printList();
	}
	public static void addToFirst(int value) {
		Node node = new Node(value);
		if(head != null) {
			node.setNext(head);
		}
		head = node;
	}
	public static void addToLast(int value) {
		Node node = new Node(value);
		if(head == null) {
			head = node;
		} else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.setNext(node);
		}
	}
	public static void add(int value, Node pre) {
		Node node = new Node(value);
		if(pre == null) {
			node.setNext(head);
			head = node;
		} else {
			node.setNext(pre.next);
			pre.setNext(node);
		}
	}
	public static void delete(Node pre) {
		Node node = pre.next;
		if(node != null) {
			pre.setNext(node.next);
		}
	}
	public static void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
}
