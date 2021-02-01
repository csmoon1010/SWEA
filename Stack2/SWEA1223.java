import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class SWEA1223
{
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("Stack2/res/input2.txt"));
		Scanner sc = new Scanner(System.in);
		String operator = "+*";
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String ps = toPostfix(s, size, operator);
			int answer = calculate(ps, size, operator);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static String toPostfix(String s, int size, String op) {
		String answer = "";
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < size; i++) {
			String target = s.substring(i, i+1);
			if(!op.contains(target))	answer += target;
			else {
				int tpr = getPriority(target);
				while(!stack.empty() && getPriority(stack.peek()) >= tpr) {
					answer += stack.pop();
				}
				stack.push(target);
			}
		}
		while(!stack.empty())	answer += stack.pop();
		return answer;
	}
	
	public static int calculate(String s, int size, String op) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i= 0; i < size; i++) {
			String target = s.substring(i, i+1);
			if(op.contains(target)) {
				int b = stack.pop(); int a = stack.pop();
				if(target.equals("+"))	stack.push(a+b);
				else if(target.equals("*"))	stack.push(a*b);
			}
			else stack.push(Integer.parseInt(target));
		}
		answer = stack.pop();
		return answer;
	}
	
	public static int getPriority(String s) {
		int p = 0;
		if(s.equals("+"))	p = 1;
		else if(s.equals("*"))	p = 2;
		return p;
	}
}