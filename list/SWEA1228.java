import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1228
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("list/res/input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = sc.nextInt();
            sc.nextLine();
            String[] str = sc.nextLine().split(" ");
            LinkedList<String> origins = new LinkedList<>();
            for(String s : str) {
            	origins.add(s);
            }
            int m = sc.nextInt();
            sc.nextLine();
            String[] instruction = new String[m];
            instruction = sc.nextLine().substring(1).split("I");
            System.out.println("#" + test_case + " " + makeCipher(instruction, origins));
		}
	}
	
	public static String makeCipher(String[] instruction, LinkedList<String> origins) {
		String answer = "";
		for(String s : instruction) {
        	s = s.substring(1, s.length()-1);
        	String[] command = s.split(" ");
        	int index = Integer.parseInt(command[0]);
        	int size = Integer.parseInt(command[1]);
        	for(int i = 0; i < size; i++) {
        		origins.add(index+i, command[2+i]); //중간 삽입이 필요하므로 LinkedList 이용
        	}
        }
		for(int i = 0; i < 10; i++) {
			answer += origins.get(i) + " ";
		}
		return answer;
	}
}