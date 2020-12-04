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
			while(j > 0 && s[i] != p[j]) { //���� pattern ã�� ����. j�� ������
				j = pi[j-1]; //j�϶� ����ġ�����Ƿ� j-1�ؼ�!!
			}
			if(s[i] == p[j]) {
				if(j == m-1) {
					list.add(i-m+1); //pattern�� �����ϴ� str�� index�� �߰�. ������찡 ���� �� ����
					j = pi[j]; //���� pattern�� ã�� �� ������ j(�����Լ� ����)
				}
				else {
					j++;
				}
			}
			//j == 0�̰� s[i] != p[j]�� ���� ���� character�� �Ѿ�� pattern�� ù��°���� ����
		}
		return list;
	}
	
	public static int[] getPi(String pattern) { //�����Լ�
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