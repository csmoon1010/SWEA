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
		boolean[] a = new boolean[arr.length]; //원소 사용여부
		backtrack(a, 0, a.length);
		
	}
	
	public static int make_candidates(boolean[] a, int k, int limit, boolean[] c) {
		//후보군 저장 배열 c
		c[0] = true;
		c[1] = false;
		return 2;
	}
	
	public static void backtrack(boolean[] a, int k, int limit) {
		boolean[] c = new boolean[a.length];
		if(k == limit) {
			process_solution(a, k); // 출력
		}else {
			int ncands = make_candidates(a, k, limit, c); //후보군, c를 매개변수로 넣으면 반영된다...!
			for(int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k+1, limit); //그 다음 원소
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
