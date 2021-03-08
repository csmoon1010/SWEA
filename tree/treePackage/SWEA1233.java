package treePackage;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class SWEA1233
{
	public static int flag;
	public static void main(String args[]) throws Exception
		{
			System.setIn(new FileInputStream("tree/res/input2.txt"));
			Scanner sc = new Scanner(System.in);
			for(int test_case = 1; test_case <= 10; test_case++)
			{
				int n = sc.nextInt();
				sc.nextLine();
				OperationNode[] tree = new OperationNode[n+1];
				for(int i = 1; i <= n; i++) {
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
				flag = 1;
				checkValidity(tree, 1);
				System.out.println("#" + test_case + " " + flag);
			}
	}
	//재귀 --> break 되기까지 오래 걸림. 오류를 찾았는데도 재귀를 전부 돌아야 함
	public static void checkValidity(OperationNode[] tree, int index) {
		if(flag == 1 && tree[index] != null) {
			checkValidity(tree, tree[index].left);
			checkValidity(tree, tree[index].right);
			if(flag == 1 && tree[index].left != 0 && tree[index].right != 0) {
				String leftNode = tree[tree[index].left].element;
				char centerNode = tree[index].element.charAt(0);
				String rightNode = tree[tree[index].right].element;
				if(Character.isDigit(leftNode.charAt(0)) && Character.isDigit(rightNode.charAt(0)) && isOperator(centerNode)) {
					int leftNumber = Integer.parseInt(leftNode);
					int rightNumber = Integer.parseInt(rightNode);
					tree[index].element = "1";
				} else {
					flag = 0;
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
}

class OperationNode{
	String element;
	int left;
	int right;
	OperationNode(String element, int left, int right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
}
