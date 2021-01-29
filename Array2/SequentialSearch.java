import java.util.Scanner;
import java.util.Arrays;

public class SequentialSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {3, 10, 2, 16, 20, 8, 7, 29};
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		System.out.println(unorderedSearch(array, target));
		System.out.println(orderedSearch(array, target));
	}
	
	public static boolean unorderedSearch(int[] arr, int t) {
		boolean answer = false;
		for(int i = 0; i < arr.length; i++) { // O(n)의 시간복잡도
			if(arr[i] == t) {
				answer = true;
				break;
			}
		}
		return answer;
	}
	
	public static boolean orderedSearch(int[] arr, int t) {
		boolean answer = false;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) { // O(n)의 시간복잡도
			if(arr[i] == t) {
				answer = true;
				break;
			}
			else if(arr[i] > t)	break;
		}
		return answer;
	}
}
