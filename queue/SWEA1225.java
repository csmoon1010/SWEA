import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SWEA1225
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("queue/res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int test_case = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			boolean flag = true;
			while(flag) {
				for(int i = 1; i <= 5; i++) {
					int target = queue.poll();
					target = (target-i > 0) ? target-i : 0;
					queue.add(target);
					if(target == 0) {
						flag = false;
						break;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i : queue) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}