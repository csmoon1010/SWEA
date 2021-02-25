import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1230
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("list/res/input3.txt"));
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
            String temp = sc.nextLine();
            String[] instruction = temp.substring(1).split("[I,D,A]");
            String[] operation = temp.replaceAll("[^I,D,A]", "").split(""); //정규표현식
            System.out.println("#" + test_case + " " + makeCipher(operation, instruction, origins, m));
		}
	}
	
	public static String makeCipher(String[] operation, String[] instruction, LinkedList<String> origins, int m) {
		String answer = "";
		for(int i = 0; i < m; i++) {
			String[] command = instruction[i].substring(1, instruction[i].length()-1).split(" ");
			if(operation[i].equals("I")) {
				int index = Integer.parseInt(command[0]);
	        	int size = Integer.parseInt(command[1]);
	        	for(int j = 0; j < size; j++) {
	        		origins.add(index+j, command[j+2]); //중간 삽입이 필요하므로 LinkedList 이용
	        	}
			} else if(operation[i].equals("D")) {
				int index = Integer.parseInt(command[0]);
	        	int size = Integer.parseInt(command[1]);
	        	for(int j = 0; j < size; j++) {
	        		origins.remove(index);
	        	}
			} else if(operation[i].equals("A")) {
				int size = Integer.parseInt(command[0]);
				for(int j = 0; j < size; j++) {
					origins.add(command[j+1]);
				}
			}
		}
		for(int i = 0; i < 10; i++) {
			answer += origins.get(i) + " ";
		}
		return answer;
	}
}