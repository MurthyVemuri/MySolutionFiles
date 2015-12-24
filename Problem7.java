import java.util.*;	
	
public class Problem7 {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long countTestcases = scan.nextInt();
		for(long l = 1; l <= countTestcases; l++) {
			long number = scan.nextInt();
			long i = 1;
			long count = 0;
			while(count < number){
				i++;
				boolean prime = true;
				for(long j = 2; j <= Math.sqrt(i); j++){
					if(i % j == 0){
						prime = false;
						break;
					}
				}
				if(prime){
					count++;
				}
			}
			System.out.println(i);
		}
	}
}

