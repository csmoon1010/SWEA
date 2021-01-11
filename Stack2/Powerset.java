import java.util.Scanner;

public class Powerset {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		boolean[] a = new boolean[arr.length]; //���� ��뿩��
		backtrack(a, 0, a.length);
		
	}
	
	public static int make_candidates(boolean[] a, int k, int limit, boolean[] c) {
		//�ĺ��� ���� �迭 c
		c[0] = true;
		c[1] = false;
		return 2;
	}
	
	public static void backtrack(boolean[] a, int k, int limit) {
		boolean[] c = new boolean[a.length];
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
	
	public static void process_solution(boolean[] a, int k) {
		for(int i = 0; i < a.length; i++) {
			if(a[i])	System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}