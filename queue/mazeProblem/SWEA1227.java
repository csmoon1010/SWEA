package mazeProblem;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

class SWEA1227
{	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("queue/res/input3.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			test_case = sc.nextInt();
			sc.nextLine();
			char[][] mazeMap = new char[100][100];
			Node start = new Node(0, 0);
			for(int i = 0; i < 100; i++) {
				String s = sc.nextLine();
				mazeMap[i] = s.toCharArray();
				if(s.contains("2")) {
					start = new Node(i, s.indexOf("2"));
				}
			}
			System.out.println("#" + test_case + " " + bfs(mazeMap, start));
		}
	}
	
	public static int bfs(char[][] mazeMap, Node start) {
		int answer = 0;
		int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		boolean[][] visited = new boolean[100][100];
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;
		while(!queue.isEmpty() && answer == 0) {
			Node target = queue.poll();
			for(int i = 0; i < 4; i++) {
				int x = target.x + direction[i][0];
				int y = target.y + direction[i][1];
				if(x < 0 || x >= 100 || y < 0 || y >= 100) {
					break;
				}
				if(mazeMap[x][y] == '0' && !visited[x][y]) {
					queue.add(new Node(x, y));
					visited[x][y] = true;
				} else if(mazeMap[x][y] == '3') {
					answer = 1;
					break;
				}
			}
		}
		return answer;
	}
}