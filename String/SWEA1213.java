import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SWEA1213
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("String/res/test_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
			if(s[i] == p[j]) { //이 부분 어렵!!잊지말자!!
				if(j == m-1) {
					answer++;
					j = pi[j]; //**다음 pattern을 찾을 때 시작할 j(실패함수 적용)
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