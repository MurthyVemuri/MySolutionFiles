import java.util.*;

public class Problem10{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTestcases = scan.nextInt();
		for(int l = 1; l <= countTestcases; l++) {
			int number = scan.nextInt();
			double sum = 2;
			for(int i = 3; i <= number; i+=2){
				boolean flag = true;
				for(int j = 3; j <= Math.sqrt(i); j+=2){
					if(i % j == 0){
						flag = false;
						break;
					}
				}
				if(flag){
					sum += i;
				}
			}
			System.out.println((int)sum);
		}
	}
}
