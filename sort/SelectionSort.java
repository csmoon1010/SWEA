public class SelectionSort {

	public static void main(String[] args) {
		int[] array = new int[]{69, 10, 30, 2, 16, 8, 31, 22};
		sSort(array);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	static void sSort(int[] array) {
		int size = array.length-1;
		for(int i = 0; i < size; i++) {
			int min = i;
			for(int j = i; j <= size; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
				swap(array, i, min);
			}
		}
	}
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
