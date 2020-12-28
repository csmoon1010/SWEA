import java.io.FileInputStream;
import java.util.Scanner;

public class Stackstructure {
	static int top = -1;
	static int stacksize = 10;
	public static void main(String args[]) throws Exception
	{
		int[] stack = new int[stacksize];
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if(s.equals("finish")) {
				break;
			}
			else if(s.equals("pop")) {
				pop(stack);
			}
			else {
				push(stack, Integer.parseInt(s));
			}
		}
	}
	public static void push(int[] stack, int x) {
		if(top+1 >= stacksize)
			System.out.println("overflow");
		else{
			stack[++top] = x;
			System.out.println("push" + " " + x);
		}
	}
	
	public static void pop(int[] stack) {
		if(top == -1)
			System.out.println("underflow");
		else {
			System.out.println(stack[top--]);
		}
	}
}
