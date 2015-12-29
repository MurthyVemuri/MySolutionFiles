import java.util.*;

public final class Problem_035 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println(new Problem_035().run(number));
	}
	
	boolean[] isPrime;

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
	
	public static boolean[] listPrimality(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative array size");
		boolean[] result = new boolean[n + 1];
		if (n >= 2)
			result[2] = true;
		for (int i = 3; i <= n; i += 2)
			result[i] = true;
		// Sieve of Eratosthenes
		for (int i = 3, end = sqrt(n); i <= end; i += 2) {
			if (result[i]) {
				// Note: i * i does not overflow
				for (int j = i * i; j <= n; j += i << 1)
					result[j] = false;
			}
		}
		return result;
	}
	
	public String run(int LIMIT) {
		isPrime = listPrimality(LIMIT - 1);
		int count = 0;
		int sumPrimes = 0;
		for (int i = 0; i < isPrime.length; i++) {
			if (isCircularPrime(i))
				sumPrimes = sumPrimes + i;
				count++;
		}
		return Integer.toString(sumPrimes);
	}
	
	public boolean isPrime(int x) {
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
	
	private boolean isCircularPrime(int n) {
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			if (!isPrime[Integer.parseInt(s.substring(i) + s.substring(0, i))])
				return false;
		}
		return true;
	}
	
}
