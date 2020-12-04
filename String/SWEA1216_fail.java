//잘 해결 안된 문제!!! - 너무 어렵게 생각했음!!
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class SWEA1216_fail
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
			System.out.println(palindrome(hplane));
		}
	}
	public static int palindrome(char[][] p) {
		ArrayList<ArrayList<Integer>> list;
		int answer = Integer.MIN_VALUE;
		for(int i = 0; i < 100; i++) {
			char[] target= p[i];
			int[] index = new int[6];
			int[] gap = new int[3];
			int max = 0;
			list = new ArrayList<>();
			for(int j = 0; j < 3; j++) {
				list.add(new ArrayList<Integer>());
			}
			for(int j = 0; j < 100; j++) {
				list.get(target[j] - 'A').add(j);
			}
			for(int j = 0; j < 3; j++) {
				index[j*2] = 0;
				index[j*2+1] = list.get(j).size()-1;
			}
			int gapMax = Integer.MIN_VALUE;
			while(true) {
				int select = 0; 
				for(int j = 0 ; j < 3; j++) {
					ArrayList<Integer> temp = list.get(j);
					gap[j] = temp.get(index[j*2+1]) - temp.get(index[j*2]);
					if(gap[j] > gapMax) {
						select = j;
						gapMax = gap[j];
					}
				}
				if(gapMax < answer)	break;
				else {
					ArrayList<Integer> temp = list.get(select);
					int sindex = index[select*2];
					int eindex = index[select*2+1];
					int start = temp.get(sindex);
					int end = temp.get(eindex);
					boolean find = true;
					while(end-start > 0) {
						if(target[start] == target[end]) {
							start++; end--;
						}else {
							find = false;
							break;
						}
					}
					if(find) {
						answer = gapMax;
						break;
					}else {
						if(temp.get(eindex) - temp.get(eindex-1) > temp.get(sindex+1) - temp.get(sindex)) {
							eindex--;
						}else {
							sindex++;
						}
					}
				}
			}
		}
		return answer;
	}
}