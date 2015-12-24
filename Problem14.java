import java.util.*;

public class Problem14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long countTest = scan.nextLong();
		for(long k = 1; k <= countTest; k++) {
			long number  = scan.nextInt();
			long max = -1;
			long maxScore = 0;
			for(long i = 0; i < number; i++){
				long score = getCollatz(i);
				if(score >= maxScore){
					maxScore = score;
					max = i;
				}
			}
			System.out.println(max);
		}
	}
	
	public static int getCollatz(long n){
		if(n <= 1){
			return 1;
		}
		if(n % 2 == 0){
			return getCollatz(n/2)+1;
		}
		else{
			return getCollatz(3*n+1)+1;
		}
	}
}
