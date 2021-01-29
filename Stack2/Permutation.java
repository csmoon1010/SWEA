import java.util.Scanner;

public class Permutation {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		int [] a = new int[arr.length]; //���ҵ� ��� �迭
		backtrack(a, 0, a.length);
		
	}
	
	public static int make_candidates(int[] a, int k, int limit, int[] c) {
		boolean[] in_perm = new boolean[a.length];
		for(int i = 0; i < k; i++) {
			in_perm[a[i]] = true; //�̹� ���� ���Ҵ� true ó��
		}
		int ncands = 0;
		
		for(int i = 0; i < limit; i++) {
			if(!in_perm[i]) { //���� ������ ���� ���� index�� �ĺ������� ����� (���� ���)
				c[ncands] = i;
				ncands++;
			}
		}
		return ncands;
	}
	
	public static void backtrack(int[] a, int k, int limit) {
		int[] c = new int[a.length];
		if(k == limit) {
			process_solution(a, k); // ���
		}else {
			int ncands = make_candidates(a, k, limit, c); //�ĺ���, c�� �Ű������� ������ �ݿ��ȴ�...!
			for(int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k+1, limit); //�� ���� ����
			}
		}
	}
	
	public static void process_solution(int[] a, int k) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(arr[a[i]] + " ");
		}
		System.out.println();
	}
}