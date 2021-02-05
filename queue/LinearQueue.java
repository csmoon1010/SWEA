import java.util.Scanner;

public class LinearQueue {
	static int size = 5;
	static int front = -1;
	static int rear = -1;
	static int[] queue;
	public static void main(String[] args) throws Exception
	{
		queue = new int[size];
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
		if (front == rear) {
			answer = true;
		}
		return answer;
	}
	public static boolean isFull() {
		boolean answer = false;
		if (rear == size-1) {
			answer = true;
		}
		return answer;
	}
	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("Queue is Full");
		} else {
			queue[++rear] = item;
			System.out.println(item + " is added to Queue");
		}
	}
	public static void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			int peek = queue[++front];
			System.out.println(peek + " is deleted from Queue");
		}
	}
	public static void qPeek() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			System.out.println(queue[front+1]);
		}
	}
}
