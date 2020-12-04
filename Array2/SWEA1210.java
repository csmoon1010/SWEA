/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
// b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
// g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
// var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
// AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution �������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class SWEA1210
{
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("Array2/res/input2.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			//+a> �̸� ���� �������� ��ġ�� �ľ��Ͽ� ����, ������ �������� ���� �� ���� --> �޸�, �ð� ����
			int order = sc.nextInt();
			int[][] data = new int[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			
			int dst = 0;
			for(int i = 0; i < 100; i++) {
				if(data[99][i] == 2) {
					dst = i;
					break;
				}
			}
			
			int currentX = 99; int currentY = dst; 
			int mode = 2;
			int[] drct = new int[]{-1, 1};
			while(currentX > 0) {
				if(mode == 2) {
					if(currentY > 0 && data[currentX][currentY-1] == 1) {
						mode = 0;
						currentY--;
					}
					else if(currentY < 99 && data[currentX][currentY+1] == 1) {
						mode = 1;
						currentY++;
					}
					else currentX--;
				}
				else {
					if((mode == 0 && currentY > 0) || (mode == 1 && currentY < 99)) {
						if(data[currentX][currentY+drct[mode]] == 1) {
							currentY += drct[mode];
							continue;
						}
					}
					mode = 2;
					currentX--;
				}
			}
			System.out.println("#" + order + " " + currentY);
		}
	}
}