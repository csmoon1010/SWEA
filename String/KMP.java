import java.util.ArrayList;

class KMP
{
	public static void main(String args[]) throws Exception
	{
		String str = "AAAAABAB";
		String pattern = "AAABAB";
		ArrayList<Integer> result = kmp(str, pattern);
		for(int r : result) {
			System.out.println(r);
		}
	}
	public static ArrayList<Integer> kmp(String str, String pattern){
		ArrayList<Integer> list = new ArrayList<>();
		int[] pi = getPi(pattern);
		int n = str.length(), m = pattern.length(), j = 0;
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		
		for(int i = 0; i < n; i++) {
			while(j > 0 && s[i] != p[j]) { //다음 pattern 찾기 시작. j를 재조정
				j = pi[j-1]; //j일때 불일치했으므로 j-1해서!!
			}
			if(s[i] == p[j]) {
				if(j == m-1) {
					list.add(i-m+1); //pattern이 시작하는 str의 index를 추가. 여러경우가 있을 수 있음
					j = pi[j]; //다음 pattern을 찾을 때 시작할 j(실패함수 적용)
				}
				else {
					j++;
				}
			}
			//j == 0이고 s[i] != p[j]일 때는 다음 character로 넘어가고 pattern의 첫번째부터 시행
		}
		return list;
	}
	
	public static int[] getPi(String pattern) { //실패함수
		int m = pattern.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];
		
		p = pattern.toCharArray();
		for(int i = 1; i < m; i++) {
			while(j > 0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			if(p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}