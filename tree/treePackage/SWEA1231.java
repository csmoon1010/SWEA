package treePackage;

import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1231
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("tree/res/input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			AlphabetNode[] tree = new AlphabetNode[n+1];
			for(int i = 1; i <= n; i++) {
				int index = sc.nextInt();
				String alphabet = sc.next();
				int left = 0; int right = 0;
				if(index*2 <= n) {
					left = sc.nextInt();
				}
				if(index*2 + 1 <= n) {
					right = sc.nextInt();
				}
				tree[index] = new AlphabetNode(alphabet, left, right);
			}
			System.out.print("#" + test_case + " ");
			readAlphabet(tree, 1);
			System.out.println();
		}
	}
	public static void readAlphabet(AlphabetNode[] tree, int current) {
		if(tree[current].left != 0) readAlphabet(tree, tree[current].left);
		System.out.print(tree[current].alphabet);
		if(tree[current].right != 0) readAlphabet(tree, tree[current].right);
	}
}

class AlphabetNode{
	String alphabet;
	int left;
	int right;
	AlphabetNode(String alphabet, int left, int right){
		this.alphabet = alphabet;
		this.left = left;
		this.right = right;
	}
}
