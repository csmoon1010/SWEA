import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class SWEA1224
{
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("Stack2/res/input3.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String ps = toPostfix(s, size);
			int answer = calculate(ps, ps.length());
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static String toPostfix(String s, int size) {
		String answer = "";
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < size; i++) {
			char target = s.charAt(i);
			if(Character.isDigit(target))	answer += target;
			else {
				if(target == '(')	stack.push(target);
				else if(target == ')'){
					while(stack.peek() != '(') answer += stack.pop();
					stack.pop();
				}
				else {
					int tpr = getPriority(target);
					while(!stack.empty() && getPriority(stack.peek()) >= tpr)	answer += stack.pop();
					stack.push(target);
				}
			}
		}
		while(!stack.empty())	answer += stack.pop();
		return answer;
	}
	
	public static int calculate(String s, int size) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i= 0; i < size; i++) {
			char target = s.charAt(i);
			if(!Character.isDigit(target)) {
				int b = stack.pop(); int a = stack.pop();
				if(target == '+')	stack.push(a+b);
				else if(target == '*')	stack.push(a*b);
			}
			else stack.push(Integer.parseInt(Character.toString(target)));
		}
		answer = stack.pop();
		return answer;
	}
	
	public static int getPriority(char op) {
		int p = 0;
		switch(op) {
		case '+' :
			p = 1;
			break;
		case '*' : 
			p = 2;
			break;
		}
		return p;
	}
}