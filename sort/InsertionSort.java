import java.util.LinkedList;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = new int[]{69, 10, 30, 2, 16, 8, 31, 22};
		array = iSort(array);
		for(int i : array) {
			System.out.print(i+ " ");
		}
	}
	
	public static int[] iSort(int[] array) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(array[0]);
		for(int i = 1; i < array.length; i++) {
			boolean flag = false;
			for(int j = i-1; j >= 0; j--) {
				if(list.get(j) > array[i]) {
					continue;
				} else {
					list.add(j+1, array[i]); //j+1번째에 추가!
					flag = true;
					break;
				}
			}
			if(!flag) {
				list.addFirst(array[i]);
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray(); //list--> int array로 바꾸는 stream
	}
}
