import java.math.BigInteger;
import java.util.*;


public class Problem_25{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTest = scan.nextInt();
		for(int i = 1; i <= countTest; i++) {
			int number = scan.nextInt();
			System.out.println(new Problem_25().run(number));
		}
	}
	
	
	
	
	public String run(int DIGITS) {
		BigInteger lowerthres = BigInteger.TEN.pow(DIGITS - 1);
		BigInteger upperthres = BigInteger.TEN.pow(DIGITS);
		BigInteger prev = BigInteger.ONE;
		BigInteger cur = BigInteger.ZERO;
		int i = 0;
		while (true) {
			if (cur.compareTo(lowerthres) >= 0)
				return Integer.toString(i);
			else if (cur.compareTo(upperthres) >= 0)
				throw new RuntimeException("Not found");
			
			BigInteger temp = cur.add(prev);
			prev = cur;
			cur = temp;
			i++;
		}
	}
	
}
