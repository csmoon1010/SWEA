import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1229
{
	static Scanner sc;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("list/res/input2.txt"));
		sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = sc.nextInt();
            String[] str = sc.nextLine().split(" ");
            LinkedList<Integer> origins = readOrigin(n);
            int m = sc.nextInt();
            System.out.println("#" + test_case + " " + makeCipher(origins, m));
		}
	}
	
	public static LinkedList<Integer> readOrigin(int n){
		LinkedList<Integer> origins = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			origins.add(sc.nextInt());
		}
		return origins;
	}
	
	public static String makeCipher(LinkedList<Integer> origins, int m) {
		String answer = "";
		for(int i = 0; i < m; i++) {
			char operation = sc.next().charAt(0);
			switch(operation) {
				case 'I' :
					insert(origins);
					break;
				case 'D' :
					delete(origins);
					break;
				default :
					break;
			}
		}
		for(int i = 0; i < 10; i++) {
			answer += origins.get(i) + " ";
		}
		return answer;
	}
	
	public static void insert(LinkedList<Integer> origins) {
		int index = sc.nextInt();
    	int size = sc.nextInt();
    	for(int i = 0; i < size; i++) {
    		origins.add(index+i, sc.nextInt()); //중간 삽입이 필요하므로 LinkedList 이용
    	}
	}
	
	public static void delete(LinkedList<Integer> origins) {
		int index = sc.nextInt();
    	int size = sc.nextInt();
    	for(int i = 0; i < size; i++) {
    		origins.remove(index); //index는 0부터 시작, 조건은 1부터 순서를 나타내므로
    	}
	}
	
}