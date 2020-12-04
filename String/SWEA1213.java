import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution �������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class SWEA1213
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("String/res/test_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int order = Integer.parseInt(sc.nextLine());
			String pattern = sc.nextLine();
			String str = sc.nextLine();
			System.out.println("#" + order + " " + kmp(str, pattern));
		}
	}
	
	//KMP
	public static int kmp(String str, String pattern) {
		int answer = 0;
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		int n = str.length(), m = pattern.length();
		int[] pi = getPI(pattern);
		int j = 0;
		for(int i = 0; i < n; i++) {
			while(j > 0 && s[i] != p[j]) {
				j = pi[j-1];
			}
			if(s[i] == p[j]) { //�� �κ� ���!!��������!!
				if(j == m-1) {
					answer++;
					j = pi[j]; //**���� pattern�� ã�� �� ������ j(�����Լ� ����)
				}
				else j++;
			}
		}
		return answer;
	}
	
	public static int[] getPI(String pattern) {
		int m = pattern.length();
		char[] p = pattern.toCharArray();
		int[] pi = new int[m];
		int j = 0;
		for(int i = 1; i < m; i++) {
			while(j > 0 && p[j] != p[i]) {
				j = pi[j-1];
			}
			if(p[j] == p[i]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}