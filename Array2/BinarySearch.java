import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {2, 3, 7, 8, 10, 16, 20, 29};
		Arrays.sort(array);
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		System.out.println(binarySearch(array, target));
	}
	
	public static int binarySearch(int[] arr, int t) {
		int start = 0; int end = arr.length;
		int mid = 0;
		int answer = -1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(arr[mid] == t) {
				answer = mid;
				break;
			}
			else if(arr[mid] < t)	start = mid + 1;
			else	end = mid-1;
		}
		return answer;
	}
}
