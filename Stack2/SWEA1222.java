import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class SWEA1222
{
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("Stack2/res/input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String ps = toPostfix(s, size);
			int answer = calculate(ps, size);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static String toPostfix(String s, int size) {
		String answer = "";
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < size; i++) {
			String target = s.substring(i, i+1);
			if(target.equals("+")) {
				if(!stack.empty())	answer += stack.pop();
				stack.push(target);
			}
			else	answer += target;
		}
		while(!stack.empty())	answer += stack.pop();
		return answer;
	}
	
	public static int calculate(String s, int size) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i= 0; i < size; i++) {
			String target = s.substring(i, i+1);
			if(target.equals("+")) {
				int b = stack.pop(); int a = stack.pop();
				stack.push(a+b);
			}
			else stack.push(Integer.parseInt(target));
		}
		answer = stack.pop();
		return answer;
	}
}