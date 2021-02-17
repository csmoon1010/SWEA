public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{69, 10, 30, 2, 16, 8, 31, 22};
		bSort(array);
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void bSort(int[] array) {
		int size = array.length-1;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size-i; j++) {
				if(array[j] > array[j+1]) { //인접한 2개의 원소 비교
					swap(array, j, j+1); //위치 바꾸기
				}
			}
		}
	}
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
