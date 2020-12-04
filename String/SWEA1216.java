//잘 해결 안된 문제!!! - 너무 어렵게 생각했음!!
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1216
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("String/res/input2.txt"));

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int order = Integer.parseInt(sc.nextLine());
			char[][] hplane = new char[100][100];
			char[][] vplane = new char[100][100];
			for(int i = 0; i < 100; i++) {
				hplane[i] = sc.nextLine().toCharArray();
				for(int j = 0; j < 100; j++) {
					vplane[j][i] = hplane[i][j];
				}
			}
			int answer = Math.max(palindrome(hplane), palindrome(vplane));
			System.out.println("#" + order + " " + answer);
		}
	}
	public static int palindrome(char[][] p) {
		int answer = 1;
		for(int i = 100; i >= 2; i--) { //길이 긴것부터 check
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k <= 100-i; k++) {
					int start = k, end = k+i-1;
					boolean find = true;
					while(end-start > 0) {
						if(p[j][start] == p[j][end]) {
							start++; end--;
						}else {
							find = false;
							break;
						}
					}
					if(find) {
						answer = i;
						break;
					}
				}
				if(answer == i)	break;
			}
			if(answer == i)	break;
		}
//		for(int i = 2; i <= 100; i++) { //길이별 - 더 이상 안나온다고 진행안하면 안됨!!전부 check해야!
//			for(int j = 0; j < 100; j++) {
//				for(int k = 0; k <= 100-i; k++) {
//					int start = k, end = k+i-1;
//					boolean find = true;
//					while(end-start > 0) {
//						if(p[j][start] == p[j][end]) {
//							start++; end--;
//						}else {
//							find = false;
//							break;
//						}
//					}
//					if(find) {
//						answer = i;
//						break;
//					}
//				}
//				if(answer == i)	break;
//			}
//		}
		return answer;
	}
}