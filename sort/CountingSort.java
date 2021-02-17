public class CountingSort {
	
	static int[] counts;
	public static void main(String[] args) {
		int[] array = new int[] {0, 4, 1, 3, 1, 2, 4, 1};
		counts = new int[5];
		array = cSort(array);
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	static void makeCounts(int[] array) { //counts 배열 생성
		for(int a : array) {
			counts[a]++;
		}
	}
	
	static void accumulateCounts() { //counts 배열 누적
		for(int i = 1; i < counts.length; i++) {
			counts[i] = counts[i-1] + counts[i];
		}
	}
	
	static int[] cSort(int[] array) { //counts 배열에 따라 정렬 시행
		int[] answer = new int[array.length];
		makeCounts(array);
		accumulateCounts();
		for(int i = array.length-1; i >= 0; i--) {
			answer[--counts[array[i]]] = array[i];
		}
		return answer;
	}
}
