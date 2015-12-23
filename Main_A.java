import java.util.*;

public class Main_A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long countTest = scan.nextInt();
		for(long j = 1; j <= countTest; j++) {
			long number  = scan.nextInt();
			long count = 0;
			for(long i = 1; i < number; i++){
				if(i % 3 == 0 || i % 5 == 0){
					count += i;
				}
			}
			System.out.println(count);
		}
	}
}	
