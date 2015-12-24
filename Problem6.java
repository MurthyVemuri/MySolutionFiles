import java.util.*;	

public class Problem6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long countTestcases = scan.nextInt();
		for(long l = 1; l <= countTestcases; l++) {
			long number = scan.nextInt();
			long sumOfSquares = 0;
			for(long i = 1; i <= number; i++){
				sumOfSquares += i*i;
			}
			
			long sum = 0;
			for(long i = 1; i <= number; i++){
				sum += i;
			}
			System.out.println((sum*sum - sumOfSquares));
		}
	}
}
