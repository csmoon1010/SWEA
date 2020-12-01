import java.util.*;

public class BoyerMoore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "amptmternomatchingrithmalgorithm";
		String pattern = "rithm";
		ArrayList<Integer> result = boyermoore(str, pattern);
		for(int a : result)	System.out.println(a + str.substring(a, a+1));
	}
	
	public static ArrayList<Integer> boyermoore(String str, String pattern){
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Character, Integer> hash = makePI(pattern);
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		int n = str.length(); int m = pattern.length();
		int index = m-1; //str의 인덱스
		while(index < n) {
			for(int i = m-1; i >= 0; i--) {
				//System.out.println(index +" " + s[index] + " " + i + " "+ p[i]);
				if(s[index] == p[i]) { //일치하는 경우
					if(i==0) {
						list.add(index);
						index += m;
						break;
					}
					index--;
				}
				else if(hash.containsKey(s[index])) { //pattern에 있는 문자인 경우
					index += hash.get(s[index]);
					break;
				}
				else { //불일치 & pattern에 없는 문자
					index += m;
					break;
				}
			}
		}
		return list;
	}
	
	public static HashMap<Character, Integer> makePI(String pattern){
		HashMap<Character, Integer> hash = new HashMap<>();
		int m = pattern.length();
		char[] p = pattern.toCharArray();
		for(int i = 0; i < m; i++) {
			hash.put(p[i], m-1-i);
		}
		return hash;
	}
}
