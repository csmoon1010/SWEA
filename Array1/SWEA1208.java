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
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution �������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class SWEA1208
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
		System.setIn(new FileInputStream("Array1/res/input3.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		//1. ���� Ǯ�� ) �ʿ��� �� ������ �����ϴ� ���
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int limit = sc.nextInt();
			int[] box = new int[100];
			for(int i = 0; i < 100; i++)
				box[i] = sc.nextInt();
			Arrays.sort(box);
			while(limit > 0) {
				if(box[0] > box[1] || box[99] < box[98])	Arrays.parallelSort(box);
				if(box[99]-box[0] <= 1)	break;
				else {
					box[0]++; box[99]--;
					limit--;
				}
			}
			Arrays.sort(box);
			System.out.println("#" + test_case + " " + (box[99]-box[0]));
		}
		
		//2. �ð����⵵ ���� ) ���� �迭 �̿�
		for(int test_case = 1; test_case <= 10; test_case++)
		{ 
			int limit = sc.nextInt();
			int[] boxcount = new int[101];
			int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
			for(int i = 0; i < 100; i++) {
				int target = sc.nextInt();
				boxcount[target]++;
				min = Math.min(min, target);
				max = Math.max(max, target);
			}
			while(limit > 0) {
				if(max-min <= 1)	break;
				else {
					boxcount[max]--; boxcount[max-1]++;
					boxcount[min]--; boxcount[min+1]++;
					if(boxcount[max] == 0)	max--;
					if(boxcount[min] == 0) min++;
					limit--;
				}
			}
			System.out.println("#" + test_case + " " + (max-min));
		}
	}
}