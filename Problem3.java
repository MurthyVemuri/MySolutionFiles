import java.util.*;
	
public class Problem3 {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTestCases = scan.nextInt();
		for (int j = 1; j <= countTestCases;j++) {
			double n = scan.nextDouble();
			for(int i = 2; i < Math.sqrt(n); i++){
				if(n % i == 0){
					n /= i;
					i--;
				}
			}
			System.out.println((int)n);
		}
	}
}
