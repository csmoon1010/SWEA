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
		int [] a = new int[arr.length]; //원소들 담는 배열
		backtrack(a, 0, a.length);
		
	}
	
	public static int make_candidates(int[] a, int k, int limit, int[] c) {
		boolean[] in_perm = new boolean[a.length];
		for(int i = 0; i < k; i++) {
			in_perm[a[i]] = true; //이미 쓰인 원소는 true 처리
		}
		int ncands = 0;
		
		for(int i = 0; i < limit; i++) {
			if(!in_perm[i]) { //아직 쓰이지 않은 원소 index를 후보군으로 담아줌 (다음 경로)
				c[ncands] = i;
				ncands++;
			}
		}
		return ncands;
	}
	
	public static void backtrack(int[] a, int k, int limit) {
		int[] c = new int[a.length];
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
	
	public static void process_solution(int[] a, int k) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(arr[a[i]] + " ");
		}
		System.out.println();
	}
}
