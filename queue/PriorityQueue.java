import java.util.Scanner;

class PNode  { //LinkedQueue�� ����� Node class
	int value;
	PNode previous;
	PNode next;
	PNode(int value) {
		this.value = value;
		this.previous = null;
		this.next = null;
	}
	public void setLink(PNode previous, PNode next) {
		this.previous = previous;
		this.next = next;
	}
}

public class PriorityQueue {
	static PNode front = null;
	static PNode rear = null;
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
			} else if (order[0].equals("all")) {
				printQueue();
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
	public static void enQueue(int item) { //priority : ���� Ŭ���� ���� �켱����
		PNode node = new PNode(item);
		if(isEmpty()) {
			front = node;
			rear = node;
		} else {
			PNode current = rear;
			while(current != front && current.value < node.value) {
				current = current.previous;
			}
			if(current == front && current.value <= node.value) { //front�� ��ġ�ؾ� �ϴ� ���
				front.setLink(node, front.next);
				node.setLink(null, front);
				front = node;
			} else if(current == rear && current.value >= node.value) { //rear�� ��ġ�ؾ� �ϴ� ���
				rear.setLink(rear.previous, node);
				node.setLink(rear, null);
				rear = node;
			} else { //�߰��� ��ġ�ؾ� �ϴ� ���
				PNode oldNext = current.next;
				oldNext.setLink(node, oldNext.next);
				current.setLink(current.previous, node);
				node.setLink(current, oldNext);
			}
		}
		System.out.println(item + " is added to Queue");
	}
	public static void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			int peek = front.value;
			PNode previous = front;
			front = previous.next; //front�� ���� Node�� ����
			previous.next = null;
			if(isEmpty()) { //��尡 ���� ��� rear�� ��������� �Ѵ�!
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
	public static void printQueue() {
		PNode current = front;
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
	}
}