import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class JavaQueue {

	public static void main(String[] args) {
		LinkedList<String> q = new LinkedList<>();
//		PriorityQueue<String> pq = new PriorityQueue<>(); //오름차순 pq
		PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder()); //내림차순 pq
		
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		while(true) {
			String[] order = sc.nextLine().split(" ");
			if (order.length == 2 && order[0].equals("add")) {
				if(type == 1) {
					q.add(order[1]);
				} else if(type == 2) {
					pq.add(order[1]);
				}
			} else if (order[0].equals("poll")) {
				if(type == 1) {
					System.out.println(q.poll());
				} else if(type == 2) {
					System.out.println(pq.poll());
				}
			} else if (order[0].equals("peek")) {
				if(type == 1) {
					System.out.println(q.peek());
				} else if(type == 2) {
					System.out.println(pq.peek());
				}
			} else if (order[0].equals("all")) {
				if(type == 1) {
					for(String s : q) {
						System.out.print(s + " ");
					}
				} else if(type == 2) {
					for(String s : pq) {
						System.out.print(s + " ");
					}
				}
				System.out.println();
			} else {
				System.out.println("finish");
				break;
			}
		}
	}

}
