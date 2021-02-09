import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int[][] list = new int[n+1][n+1];
		String[] temp = new String[2];
		for(int i = 0; i < m; i++) { //인접행렬
			temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			list[a][b] = 1;
			list[b][a] = 1;
		}
		boolean[] check = new boolean[list.length];
		BFS(list, check, v);
		
	}
	
	//BFS - 너비 우선 탐색 _ 큐 이용
	public static void BFS(int[][] a, boolean[] c, int v) {
		Queue<Integer> qu = new LinkedList<>();
		int size = a.length-1;
		qu.add(v);
		c[v] = true;
		System.out.print(v + " ");
		while(!qu.isEmpty()) {
			v = qu.poll();
			for(int i = 1; i <= size; i++) {
				if(a[v][i] == 1 && !c[i]) {
					qu.add(i);
					c[i] = true;
					System.out.print(i+ " ");
				}
			}
		}
	}

}
