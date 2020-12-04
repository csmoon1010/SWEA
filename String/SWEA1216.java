//�� �ذ� �ȵ� ����!!! - �ʹ� ��ư� ��������!!
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
		for(int i = 100; i >= 2; i--) { //���� ��ͺ��� check
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
//		for(int i = 2; i <= 100; i++) { //���̺� - �� �̻� �ȳ��´ٰ� ������ϸ� �ȵ�!!���� check�ؾ�!
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