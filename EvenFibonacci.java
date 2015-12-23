import java.util.*;

public class EvenFibonacci {
 
    void evenFibo(){
        Scanner scan = new Scanner(System.in);
        long countTestcases = scan.nextLong();
        for(long l = 1; l <= countTestcases; l++) {
            long number = scan.nextInt();
            long sum = 0;
            long a = 2, b = 8, c = 0;
            sum = sum + a + b;
            while(true){
                c = b * 4 + a;
                if( c > number)
                    break;
                sum = sum + c;
                a = b;
                b = c;
            }
            System.out.println(sum);
        }
    }
    public static void main(String a[]){
        EvenFibonacci e = new EvenFibonacci();
        e.evenFibo();
    }
}
