import java.util.*;

class Non_BouncyNumbers {
	Non_BouncyNumbers(){
		
		long sum = 0;
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		for(int l = 1; l <= test; l++) {
			int countTestCases = scan.nextInt();
			sum = 0;
			for(int x = 1; x <= countTestCases; x++){
				long[] a = Increasing(x);
				long[] b = Decreasing(x);
				long ssum = 0;
				for(int i = 0; i < 10; i++){
					ssum += a[i];
				}
				for(int i = 0; i < 10; i++){
					ssum += b[i];
				}
				ssum = ssum-9;
				sum += ssum;
			}
			System.out.println(sum);
		}
	}
	
	long[] Increasing(int n){
		if(n <= 1){
			return new long[]{0,1,1,1,1,1,1,1,1,1};
		}
		long[] a = Increasing(n-1);
		long[] b = new long[10];
		for(int i = 9; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				b[i] += a[j];
			}
		}
		return b;
	}
	
	long[] Decreasing(int n){
		if(n <= 1){
			return new long[]{0,1,1,1,1,1,1,1,1,1};
		}
		long[] a = Decreasing(n-1);
		long[] b = new long[10];
		for(int i = 0; i < 10; i++){
			for(int j = i; j < 10; j++){
				b[i] += a[j];
			}
		}
		return b;
	}
}

public class Main_113 {
	
	public static void main(String[] args) {
		new Non_BouncyNumbers();
	}
}

