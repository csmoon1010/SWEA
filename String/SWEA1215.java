import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1215
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("String/res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = Integer.parseInt(sc.nextLine());
			char[][] plane = new char[8][8];
			for(int i = 0; i < 8; i++) {
				plane[i] = sc.nextLine().toCharArray();
			}
			System.out.println("#" + test_case + " " + palindrome(plane, size));
		}
	}
	public static int palindrome(char[][] plane, int size) {
		int answer = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j <= 8-size; j++) {
				int start = j, end = j+size-1;
				boolean find = true;
				while(end-start > 0) {
					if(plane[i][start] == plane[i][end]) {
						start++; end--;
					}else {
						find = false;
						break;
					}
				}
				if(find)	answer++;	
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j <= 8-size; j++) {
				int start = j, end = j+size-1;
				boolean find = true;
				while(end-start > 0) {
					if(plane[start][i] == plane[end][i]) {
						start++; end--;
					}else {
						find = false;
						break;
					}
				}
				if(find)	answer++;	
			}
		}
		return answer;
	}
}