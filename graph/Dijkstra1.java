
public class Dijkstra1 {
	static int number = 6;
	final static int INF = Integer.MAX_VALUE;
	static int[][] graph = new int[][] {
		{0, 2, 5, 1, INF, INF},
		{2, 0, 3, 2, INF, INF},
		{5, 3, 0, 3, 1, 5},
		{1, 2, 3, 0, 1, INF},
		{INF, INF, 1, 1, 0, 2},
		{INF, INF, 5, INF, 2, 0}
	};
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		visited = new boolean[number];
		result = new int[number];
		int start = 0;
		dijkstra(start);
		for(int i = 0; i < number; i++) {
			System.out.println(start + " - " + i + " : " + result[i]);
		}
	}
	
	static void dijkstra(int start) {
		for(int i = 0; i < number; i++) { // 2. result 초기 배열 생성
			result[i] = graph[start][i];
		}
		visited[start] = true;
		for(int i = 0; i < number - 2; i++) { //남은 노드에 대해 반복
			int current = getSmallIndex(); // 3. 다음 노드 선택
			visited[current] = true;
			for(int j = 0; j < number; j++) { //4. 최소 비용 갱신
				if(!visited[j] && graph[current][j] != INF) { //INF 사용으로 인해 발생하는 overflow 방지!!
					int a = (result[current] == INF) ? 0 : result[current];
					if(a + graph[current][j] < result[j]) {
						result[j] = a + graph[current][j];
					}
				}
			}
		}
	}
	
	public static int getSmallIndex() {
		int min = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < number; i++) {
			if(result[i] < min && !visited[i]) {
				min = result[i];
				index = i;
			}
		}
		return index;
	}
}
