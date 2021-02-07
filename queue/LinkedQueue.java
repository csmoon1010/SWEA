import java.util.Scanner;

class Node { //LinkedQueue의 요소인 Node class
	int value;
	Node next;
	Node(int value) {
		this.value = value;
		this.next = null;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

public class LinkedQueue {
	static Node front = null;
	static Node rear = null;
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		while(true) {
			String[] order = sc.nextLine().split(" ");
			if (order.length == 2 && order[0].equals("add")) {
				enQueue(Integer.parseInt(order[1]));
			} else if (order[0].equals("poll")) {
				deQueue();
			} else if (order[0].equals("peek")) {
				qPeek();
			} else {
				System.out.println("finish");
				break;
			}
		}
	}
	
	public static boolean isEmpty() {
		boolean answer = false;
		if(front == null) {
			answer = true;
		}
		return answer;
	}
	public static void enQueue(int item) {
		Node node = new Node(item);
		if(isEmpty()) {
			front = node;
		} else {
			rear.setNext(node);
		}
		rear = node;
		System.out.println(item + " is added to Queue");
	}
	public static void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			int peek = front.value;
			Node previous = front;
			front = previous.next; //front를 다음 Node로 조정
			previous.next = null;
			if(isEmpty()) { //노드가 없는 경우 rear도 조정해줘야 한다!
				rear = null;
			}
			System.out.println(peek + " is deleted from Queue");
		}
	}
	public static void qPeek() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			System.out.println(front.value);
		}
	}
}
