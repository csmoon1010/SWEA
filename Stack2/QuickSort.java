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
			while(array[left] < array[pivot] && left < right)	left++; //pivot���� ���� ������ ++
			while(array[right] >= array[pivot] && left < right)	right--; //pivot���� ũ�ų� ���� ������ --
			
			if(left < right) {
				if(left == pivot)	pivot = right; //���Ŀ� swap(array, pivot, right)�� ������ ������
				swap(array, left, right); //left�� right swap --> left, right ���� �� �� �� ����
			}
		}
		swap(array, pivot, right); //right�� ��ü�Ͽ� pivot ���� �и� �Ϸ�
		return right;
	}
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}