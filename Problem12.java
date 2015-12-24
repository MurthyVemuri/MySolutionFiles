import java.util.*;	

public class Problem12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTest = scan.nextInt();
		for(int k = 1; k <= countTest; k++) {
			int number  = scan.nextInt();
			int n = 0, i = 0;
			int f = 0;
			while(f <= number){
				i++;
				n += i;
				f = getNumberOfFactors(n);
			}
			System.out.println(n);
		}
	}

	public static int getNumberOfFactors(int n){
		if(n == 1)
			return 1;
		int num = 2;
		for(int i = 2; i < Math.sqrt(n); i++){
			if(n % i == 0)
				num += 2;
		}
		int r = (int)(Math.sqrt(n));
		if(r * r == n)
			if(n % r == 0)
				num++;
		return num;
	}
}
