class MNode {
	int value;
	MNode next;
	MNode prev;
	MNode(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	public void setNext(MNode next) {
		this.next = next;
	}
	public void setPrev(MNode prev) {
		this.prev = prev;
	}
}

public class DoublyLinkedList {
	
	static MNode head = null;
	public static void main(String[] args) throws Exception
	{
		addToLast(1);
		addToFirst(2);
		addToLast(3);
		printList(); //213
		
		add(4, head);
		add(5, head.next);
		printList(); // 24513
		
		delete(head); //4513
		printList();
		delete(head.next); //413
		printList();
	}
	public static void addToFirst(int value) {
		MNode node = new MNode(value);
		if(head != null) {
			node.setNext(head);
			head.setPrev(node);
		}
		head = node;
	}
	public static void addToLast(int value) {
		MNode node = new MNode(value);
		if(head == null) {
			head = node;
		} else {
			MNode current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.setNext(node);
			node.setPrev(current);
		}
	}
	public static void add(int value, MNode cur) { //cur 다음에 삽입
		MNode node = new MNode(value);
		if(cur == null) {
			head = node;
		} else {
			node.setNext(cur.next);
			cur.setNext(node);
			node.setPrev(cur);
			(node.next).setPrev(node);
		}
	}
	public static void delete(MNode cur) { //cur노드 삭제
		if(cur.prev != null) {
			(cur.prev).setNext(cur.next);
		} else {
			head = cur.next;
		}
		if(cur.next != null) {
			(cur.next).setPrev(cur.prev);
		}
	}
	public static void printList() {
		MNode current = head;
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
}
