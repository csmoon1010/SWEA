import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class DepthFirstSearch {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int[][] list = new int[n+1][n+1];
		String[] temp = new String[2];
		for(int i = 0; i < m; i++) { //ÀÎÁ¢Çà·Ä
			temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			list[a][b] = 1;
			list[b][a] = 1;
		}
		boolean[] check = new boolean[list.length];
		DFS(list, check, v);
		System.out.println();
		check = new boolean[list.length];
		DFS2(list, check, v);
		System.out.println();
		
	}
	//DFS - ±íÀÌ ¿ì¼± Å½»ö
	//Àç±Í ÀÌ¿ë
	public static void DFS(int[][] a, boolean[] c, int v) {
		boolean[] check = new boolean[a.length];
		int length = a.length - 1;
		c[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <= length; i++) {
			if(a[v][i] == 1 && !c[i])	DFS(a, c, i);
		}
	}
	//stack ÀÌ¿ë
	public static void DFS2(int[][] a, boolean[] c, int v) {
		Stack<Integer> stk = new Stack<>();
		int length = a.length - 1;
		stk.push(v); 
		c[v] = true;
		System.out.print(v+" ");
		boolean flag = false;
		while(!stk.isEmpty()) {
			v = stk.peek();
			flag = false;
			for(int i = 1; i <= length; i++) {
				if(a[v][i] == 1 && !c[i]) {
					stk.push(i);
					c[i] = true;
					System.out.print(i+" ");
					flag = true;
					break;
				}
			}
			if(!flag) {
				stk.pop();
			}
		}
	}
}
