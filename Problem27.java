import java.util.*;

public final class Problem_027 {
	
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		new Problem_027().run(scan.nextInt());
	}
	
	
	public void run(int number) {
		int bestNum = 0;
		int bestA = 0;
		int bestB = 0;
		for (int a = -number; a <= number; a++) {
			for (int b = -number; b <= number; b++) {
				int num = numberOfConsecutivePrimesGenerated(a, b);
				if (num > bestNum) {
					bestNum = num;
					bestA = a;
					bestB = b;
				}
			}
		}
		System.out.println(Integer.toString(bestA) + " " + Integer.toString(bestB) );
	}
	
	public static boolean isPrime(int x) {
		if (x < 0)
			throw new IllegalArgumentException("Negative number");
		if (x == 0 || x == 1)
			return false;
		else if (x == 2)
			return true;
		else {
			if (x % 2 == 0)
				return false;
			for (int i = 3, end = sqrt(x); i <= end; i += 2) {
				if (x % i == 0)
					return false;
			}
			return true;
		}
	}

	public static int sqrt(int x) {
		if (x < 0)
			throw new IllegalArgumentException("Square root of negative number");
		int y = 0;
		for (int i = 32768; i != 0; i >>>= 1) {
			y |= i;
			if (y > 46340 || y * y > x)
				y ^= i;
		}
		return y;
	}
	
	private static int numberOfConsecutivePrimesGenerated(int a, int b) {
		for (int i = 0; ; i++) {
			int n = i * i + i * a + b;
			if (n < 0 || !isPrime(n))
				return i;
		}
	}
	
}
