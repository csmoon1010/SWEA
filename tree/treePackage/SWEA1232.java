package treePackage;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class SWEA1232
{
	public static int flag;
	public static void main(String args[]) throws Exception
		{
			System.setIn(new FileInputStream("tree/res/input3.txt"));
			Scanner sc = new Scanner(System.in);
			for(int test_case = 1; test_case <= 10; test_case++)
			{
				int n = sc.nextInt();
				sc.nextLine();
				OperationNode[] tree = new OperationNode[n+1];
				for(int i = 1; i <= n; i++) {
					//읽는 조건 - 완전이진트리 보장 할 수 없음!!
//					if(index*2 <= n) {
//						left = sc.nextInt();
//					}
//					if(index*2 + 1 <= n) {
//						right = sc.nextInt();
//					}
					int left = 0; int right = 0;
					String[] str = sc.nextLine().split(" ");
					int index = Integer.parseInt(str[0]);
					String element = str[1];
					if(str.length >= 3) {
						left = Integer.parseInt(str[2]);
					}
					if(str.length == 4) {
						right = Integer.parseInt(str[3]);
					}
					tree[index] = new OperationNode(element, left, right);
				}
				getAnswer(tree, 1);
				System.out.println("#" + test_case + " " + (int)Double.parseDouble(tree[1].element));
			}
	}
	public static void getAnswer(OperationNode[] tree, int index) {
		if(tree[index] != null) {
			getAnswer(tree, tree[index].left);
			getAnswer(tree, tree[index].right);
			if(tree[index].left != 0 && tree[index].right != 0) {
				String leftNode = tree[tree[index].left].element;
				char centerNode = tree[index].element.charAt(0);
				String rightNode = tree[tree[index].right].element;
				if(!isOperator(leftNode.charAt(0)) && !isOperator(rightNode.charAt(0)) && isOperator(centerNode)) {
					double leftNumber = Double.parseDouble(leftNode);
					double rightNumber = Double.parseDouble(rightNode);
					tree[index].element = calculate(leftNumber, rightNumber, centerNode);
				}
			}
		}
	}
	
	public static boolean isOperator(char c) {
		boolean answer = false;
		char[] operator = new char[] {'+', '-', '*' , '/'};
		for(char o : operator) {
			if(c == o) {
				answer = true;
				break;
			}
		}
		return answer;
	}
	
	public static String calculate(double left, double right, char op) {
		double answer = 0;
		switch(op) {
		case '+':
			answer = left + right;
			break;
		case '-' :
			answer = left - right;
			break;
		case '*' :
			answer = left * right;
			break;
		case '/' :
			answer = left / right;
			break;
		}
		return Double.toString(answer);
	}
}
