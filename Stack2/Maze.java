import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.HashMap;
import java.util.Iterator;

class Maze
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("Stack2/res/maze.txt"));
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		int[][] mazeArray = new int[8][8];
		boolean[][] invalid = new boolean[8][8];
		for(int i = 0; i < size; i++) {
			String[] s = sc.nextLine().split("");
			for(int j = 0; j < size; j++) {
				mazeArray[i][j] = Integer.parseInt(s[j]);
			}
		}
		Stack<int[]> stack = new Stack<int[]>();
		//HashMap<int[], Action> hash = new HashMap<>();
		boolean[][] visited = new boolean[size][size];
		backtrack(mazeArray, stack, size, visited);
	}
	
	public static void backtrack(int[][] mazeArray, Stack<int[]> stack, int size, boolean[][] visited) {
		int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		stack.push(new int[]{0, 0});
		visited[0][0] = true;
		int[][] answer;
		while(!stack.isEmpty()) {
			int[] target = stack.peek();
			boolean flag = false;
			if(target[0] == size-1 && target[1] == size-1) {
				answer = new int[stack.size()][2];
				int index = answer.length-1;
				while(!stack.isEmpty()) {
					answer[index--] = stack.pop();
				}
				for(int i = 0; i < answer.length; i++) {
					System.out.println(answer[i][0] + " " + answer[i][1]);
				}
				break;
			}
			else {
				for(int i = 0; i < 4; i++) {
					int newx = target[0] + d[i][0];
					int newy = target[1] + d[i][1];
					if(newx >= 0 && newx < size && newy >= 0 && newy < size) {
						if(mazeArray[newx][newy] == 0 && !visited[newx][newy]) { //visited 끝난 곳은 다시 가지 않음으로 백트래킹 처리
							stack.push(new int[] {newx, newy});
							visited[newx][newy] = true;
							flag = true;
							break;
						}
					}
				}
				if(!flag) {
					int[] s = stack.pop(); //현재 위치에서 갈 수 있는 곳이 없음 -> 되돌아가기
				}
			}
		}
	}
	
//	public static void writeAction(int[][] mazeArray, HashMap<int[], Action> hash, int size) { //경로 해시 연습
//		int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//		for(int i = 0; i < size; i++) {
//			for(int j = 0; j < size; j++) {
//				int[] c = new int[] {i, j};
//				Action a = new Action();
//				if(mazeArray[i][j] == 0) {
//					for(int k = 0; k < 4; k++) {
//						int newX = i+d[k][0]; int newY = j+d[k][1];
//						if((newX >= 0 && newX < size) && (newY >= 0 && newY < size)) {
//							if(mazeArray[i][j] == 0) {
//								a.setValid(k, true);
//							}
//						}
//					}
//				}
//				hash.put(c, a);
//			}
//		}
//	}
}



//class Action{
//	boolean[] dir;
//	public Action() {
//		this.dir = new boolean[4]; //오, 왼, 위, 아래
//	}
//	public boolean isValid(int x) {
//		return dir[x];
//	}
//	public void setValid(int x, boolean b) {
//		dir[x] = b;
//	}
//}


