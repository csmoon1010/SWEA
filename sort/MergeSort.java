//딱히 LinkedList 필요없음
public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[]{69, 10, 30, 2, 16, 8, 31, 22};
		mSort(array, 0, array.length-1);
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	public static void mSort(int[] array, int start, int end) {
		int middle;
		if(start < end) {
			middle = (start+end) /2;
			mSort(array, start, middle);
			mSort(array, middle+1, end);
			merge(array, start, middle, end);
		}
	}
	
	public static void merge(int[] array, int start, int middle, int end) {
		int[] answer = new int[array.length];
		int index = start;
		int i = start;
		int j = middle+1;
		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				answer[index++] = array[i++];
			} else {
				answer[index++] = array[j++];
			}
		}
		while(i <= middle) {
			answer[index++] = array[i++];
		}
		while(j <= end) {
			answer[index++] = array[j++];
		}
		for(int a = start; a <= end; a++) {
			array[a] = answer[a];
		}
	}
}
