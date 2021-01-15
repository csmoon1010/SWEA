import java.util.Scanner;

public class Exponentiation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int exponent = sc.nextInt();
		System.out.println(calc1(base, exponent));
		System.out.println(calc2(base, exponent));
	}
	
	public static int calc1(int base, int exponent) { //O(N)
		int result = 1;
		
		for(int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	
	public static int calc2(int base, int exponent) { //O(log2N)
		int result = 1;
		if(exponent == 1) result = base;
		else if(base == 0) result = 1;
		else {
			if(exponent % 2 == 0) {
				int newBase = calc2(base, exponent/2);
				result = newBase * newBase;
			}
			else {
				int newBase = calc2(base, (exponent-1)/2);
				result = newBase * newBase * base;
			}
		}
		return result;
	}
}


