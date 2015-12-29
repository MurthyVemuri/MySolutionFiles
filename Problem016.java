import java.math.BigInteger;
import java.util.*;	

public class Problem16{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTest = scan.nextInt();
		for(int k = 1; k <= countTest; k++) {
			int number  = scan.nextInt();
			BigInteger l = BigInteger.valueOf(2);
			l = l.pow(number);
			int sum = 0;
			String s = l.toString();
			for(int i = 0; i < s.length(); i++){
				sum += s.charAt(i)-'0';
			}
			System.out.println(sum);
		}
	}
}
