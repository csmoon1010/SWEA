import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1209
{
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("Array2/res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int order = sc.nextInt();
			int[][] array = new int[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			//행의 합
			int sum = 0;
			int rowMax = Integer.MIN_VALUE;
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += array[i][j];
				}
				rowMax = Math.max(rowMax, sum);
			}
			//열의 합
			int colMax = Integer.MIN_VALUE;
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += array[j][i];
				}
				colMax = Math.max(colMax, sum);
			}
			//대각선의 합
			int diag1 = 0; int diag2 = 0;
			for(int i = 0; i < 100; i++) {
				diag1 += array[i][i];
				diag2 += array[i][99-i];
			}
			int answer = Math.max(Math.max(rowMax,  colMax), Math.max(diag1, diag2));
			System.out.println("#" + order + " " + answer);
		}
	}
}