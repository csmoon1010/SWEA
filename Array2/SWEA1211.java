import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

//1118
class SWEA1211
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("Array2/res/input3.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			//+a> 미리 줄의 세로줄의 위치를 파악하여 왼쪽, 오른쪽 움직임을 정할 수 있음 --> 메모리, 시간 절약
			int order = sc.nextInt();
			int[][] data = new int[100][100];
			ArrayList<Integer> line = new ArrayList<>();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 100; i++) {
				if(data[0][i] == 1) {
					line.add(i);
				}
			}
			
			int min = Integer.MAX_VALUE;
			int answer = 0;
			for(int i = 0; i < line.size(); i++) {
				int num = line.get(i); int index = i;
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					if(num > 0 && data[j][num-1] == 1) {
						sum += (num - line.get(--index));
						num = line.get(index);
					}
					else if(num < 99 && data[j][num+1] == 1) {
						sum += (line.get(++index) - num);
						num = line.get(index);
					}
				}
				if(sum <= min) {
					min = sum;
					answer = line.get(i);
				}
			}
			System.out.println("#" + order + " " + answer);
		}
	}
}