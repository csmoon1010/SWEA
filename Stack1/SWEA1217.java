import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1217
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("Stack1/res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int order = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int answer = calcPower(n, m);
			System.out.println("#" + order + " " + answer);
		}
	}
	
	public static int calcPower(int n, int m) {
		if(m == 1)
			return n;
		else
			return n * calcPower(n, m-1);
	}
}
