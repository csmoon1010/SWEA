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
				child = 2*parent + 1; //���� �ڽ� ���
				//ũ�� �� �� index out ���� �ʵ��� ����
				if(child < i-1 && array[child] < array[child+1]) { //������ �ڽ� ��尡 �� ū ���
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
		for(int i = 1; i < size; i++) { //�����
			int child = i; //�ڽ� ���
			do {
				int parent = (child-1) / 2; //�θ� ���
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