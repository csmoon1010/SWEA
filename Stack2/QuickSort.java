import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		quicksort(array, 0, size-1);
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
	}
	public static void quicksort(int[] array, int begin, int end) {
		if(begin < end) {
			int p = partition(array, begin, end);
			quicksort(array, begin, p-1);
			quicksort(array, p+1, end);
		}
	}
	
	public static int partition(int[] array, int begin, int end) {
		int pivot = (begin + end) / 2;
		int left = begin;
		int right = end;
		while(left < right) {
			while(array[left] < array[pivot] && left < right)	left++; //pivot보다 작을 때까지 ++
			while(array[right] >= array[pivot] && left < right)	right--; //pivot보다 크거나 같을 때까지 --
			
			if(left < right) {
				if(left == pivot)	pivot = right; //이후에 swap(array, pivot, right)로 변동이 없도록
				swap(array, left, right); //left와 right swap --> left, right 조정 더 할 수 있음
			}
		}
		swap(array, pivot, right); //right와 교체하여 pivot 기준 분리 완료
		return right;
	}
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
