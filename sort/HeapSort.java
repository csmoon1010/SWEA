public class HeapSort {
	public static void main(String[] args) {
		int[] array = new int[]{69, 10, 30, 2, 16, 8, 31, 22};
		int size = array.length;
		hSort(array, size);
	}
	
	public static void hSort(int[] array, int size) {
		heapify(array, size);
		for(int i = size - 1; i >= 0; i--) {
			swap(array, 0, i);
			int parent = 0;
			int child = 1;
			do {
				child = 2*parent + 1; //왼쪽 자식 노드
				//크기 비교 시 index out 되지 않도록 주의
				if(child < i-1 && array[child] < array[child+1]) { //오른쪽 자식 노드가 더 큰 경우
					child++;
				}
				if(child < i && array[parent] < array[child]) {
					swap(array, parent, child);
				}
				parent = child;
			} while(child < i);
		}
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void heapify(int[] array, int size) {
		for(int i = 1; i < size; i++) { //하향식
			int child = i; //자식 노드
			do {
				int parent = (child-1) / 2; //부모 노드
				if(array[parent] < array[child]) {
					swap(array, parent, child);
				}
				child = parent;
			} while(child != 0);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
