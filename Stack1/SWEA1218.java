import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.HashMap;

class SWEA1218
{
	public static void main(String args[]) throws Exception
    {
		System.setIn(new FileInputStream("Stack1/res/input2.txt"));
		Scanner sc = new Scanner(System.in);
		char[] list1 = new char[] {'(', '[', '{', '<'};
		char[] list2 = new char[] {')', ']', '}', '>'};
		HashMap<Character, Integer> left = new HashMap<>();
		HashMap<Character, Integer> right = new HashMap<>();
		for(int i = 0; i < 4; i++)	left.put(list1[i], i);
		for(int i = 0; i < 4; i++)	right.put(list2[i], i);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int answer = 1;
			Stack<Character> stack = new Stack<>();
			int size = sc.nextInt();
			String s = sc.next();
			for(int i = 0; i < size; i++) {
				char target = s.charAt(i);
				if(left.containsKey(target)) {
					stack.push(target);
				}
				else if(right.containsKey(target)) {
					if(right.get(target) == left.get(stack.peek())) {
						stack.pop();
					}else {
						answer = 0;
						break;
					}
				}
			}
			if(answer == 1 && !stack.empty())	answer = 0;
			System.out.println("#" + test_case + " " + answer);
		}
	}
}