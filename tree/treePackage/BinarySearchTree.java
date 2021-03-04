package treePackage;

public class BinarySearchTree {
	static Node rootNode;
	public static void main(String[] args) {
		rootNode = null;
		insertNode(9);
		insertNode(4);
		insertNode(2);
		insertNode(7);
		insertNode(8);
		insertNode(11);
		insertNode(10);
		insertNode(15);
		inOrderTree(rootNode); System.out.println(); //크기 순 출력 가능
		preOrderTree(rootNode); System.out.println();
		postOrderTree(rootNode); System.out.println();
		deleteNode(11);
		inOrderTree(rootNode); System.out.println();
		deleteNode(4);
		inOrderTree(rootNode); System.out.println();
		deleteNode(9);
		inOrderTree(rootNode); System.out.println(rootNode.value);
		deleteNode(20);
	}
	
	public static void insertNode(int value) {
		Node node = new Node(value);
		if(rootNode == null) {
			rootNode = node;
		} else {
			Node current = rootNode;
			while(true) {
				if(value < current.value) {
					if(current.leftNode == null) {
						current.leftNode = node;
						break;
					} else {
						current = current.leftNode;
					}
				} else {
					if(current.rightNode == null) {
						current.rightNode = node;
						break;
					} else {
						current = current.rightNode;
					}
				}
			}
		}
	}
	
	public static void deleteNode(int value) {
		//위치 탐색
		Node parentNode = null;
		Node currentNode = rootNode;
		while(currentNode != null) {
			if(currentNode.value == value) {
				break;
			} else if(value < currentNode.value){
				parentNode = currentNode;
				currentNode = currentNode.leftNode;
			} else if(value > currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.rightNode;
			}
		}
		if(currentNode == null)	System.out.println("There is no node with " + value);
		else { //삭제하기
			if(currentNode.leftNode == null && currentNode.rightNode == null) {
				if(parentNode == null) {
					rootNode = null;
				} else if(parentNode.rightNode == currentNode) {
					parentNode.rightNode = null;
				} else if(parentNode.leftNode == currentNode) {
					parentNode.leftNode = null;
				}
			} else if(currentNode.leftNode == null) {
				if(parentNode == null) {
					rootNode = currentNode.rightNode;
				} else if(parentNode.rightNode == currentNode) {
					parentNode.rightNode = currentNode.rightNode;
				} else if(parentNode.leftNode == currentNode) {
					parentNode.leftNode = currentNode.rightNode;
				}
				
			} else if(currentNode.rightNode == null) {
				if(parentNode == null) {
					rootNode = currentNode.leftNode;
				} else if(parentNode.rightNode == currentNode) {
					parentNode.rightNode = currentNode.leftNode;
				} else if(parentNode.leftNode == currentNode) {
					parentNode.leftNode = currentNode.leftNode;
				}
			} else { //경우의 수가 다양하므로 신경써야!!!
				Node parentReplaceNode = currentNode;
				Node replaceNode = currentNode.rightNode;
				while(replaceNode.leftNode != null) {
					parentReplaceNode = replaceNode;
					replaceNode = replaceNode.leftNode;
				}
				if(replaceNode != currentNode.rightNode) { //replaceNode의 자식노드가 아닐때만
					parentReplaceNode.leftNode = replaceNode.rightNode;
					replaceNode.rightNode = currentNode.rightNode;
				}
				if(currentNode == rootNode) {
					rootNode = replaceNode;
				} else if(parentNode.rightNode == currentNode) {
					parentNode.rightNode = replaceNode;
				} else if(parentNode.leftNode == currentNode) {
					parentNode.leftNode = replaceNode;
				}
				replaceNode.leftNode = currentNode.leftNode;
				System.out.println("replace : " + replaceNode.value);
			}
		}
	}
	
	public static void inOrderTree(Node current) { //중위 순회
		if(current != null) {
			inOrderTree(current.leftNode);
			System.out.print(current.value + " ");
			inOrderTree(current.rightNode);
		}
	}
	public static void preOrderTree(Node current) { //전위 순회
		if(current != null) {
			System.out.print(current.value + " ");
			preOrderTree(current.leftNode);
			preOrderTree(current.rightNode);
		}
	}
	public static void postOrderTree(Node current) {
		if(current != null) {
			postOrderTree(current.leftNode);
			preOrderTree(current.rightNode);
			System.out.print(current.value + " ");
		}
	}
}

class Node {
	int value;
	Node leftNode;
	Node rightNode;
	
	Node(int value){
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}
}