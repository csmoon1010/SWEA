import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class SWEA1219
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("Stack/res/input3.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int order = sc.nextInt();
			int size = sc.nextInt();
			int[] list1 = new int[100];
			int[] list2 = new int[100];
			for(int i = 0; i < size; i++) {
				int a = sc.nextInt(); int b = sc.nextInt();
				if(list1[a] == 0)	list1[a] = b;
				else	list2[a] = b;
			}
			int answer = DFS(list1, list2, 0);
			System.out.println("#" + order + " " + answer);
		}
	}
	public static int DFS(int[] list1, int[] list2, int v) {
		int answer = 0;
		boolean visited[] = new boolean[100];
		Stack<Integer> stack = new Stack<>();
		stack.push(v); visited[v] = true;
		while(!stack.empty()) {
			v = stack.peek();
			if(list1[v] != 0 && !visited[list1[v]]) {
				if(list1[v] == 99) {
					answer = 1;
					break;
				}
				stack.push(list1[v]); visited[list1[v]] = true;
			}
			else if(list2[v] != 0 && !visited[list2[v]]) {
				if(list2[v] == 99) {
					answer = 1;
					break;
				}
				stack.push(list2[v]); visited[list2[v]] = true;
			}
			else {
				stack.pop();
			}
		}
		return answer;
	}
}
