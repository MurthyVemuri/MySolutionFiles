import java.util.*;

public class Problem5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTestcases = scan.nextInt();
		for(int l = 1; l <= countTestcases; l++) {
			int number = scan.nextInt();
			System.out.println(findSmallestMultiple(number));
		}
	}

	public static long findSmallestMultiple(int n) {
		for (long i = n; i <= factorial(n); i += n) {
			if (isMultiple(i, n)) 
				return i;
			}
		return -1;
	}

	public static boolean isMultiple(long x, int n) {
		for (int i = 1; i < n; i++) {
			if (x % i != 0) 
				return false;
			}
		return true;
	}

	public static long factorial (long n) {
		if (n > 1) return n * factorial(n - 1);
		else if (n >= 0) return 1;
		else return -1;
	}
}
