
import java.util.*;

public class AmicableNumbers {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int countTestCases = scan.nextInt();
      for (int k = 1; k <= countTestCases; k++) {
         System.out.println(getAmicableSum(scan.nextInt()));   
      }
      
   }

   public static int getDivisorSum(int n) {
      Set<Integer> divisors = new TreeSet<Integer>();
      int root = (int) Math.ceil(Math.sqrt(n));
      for (int i = 1; i < root + 1; i++) {
         if ((double) n % i == 0 && i < n) {
            divisors.add(i);
            if (n / i < n) {
               divisors.add(n / i);
            }
         }
      }
      int divisorSum = 0;
      for (int i : divisors) {
         divisorSum += i;
      }
      return divisorSum;
   }
   
   private static int getAmicableSum(int max) {
      int sum = 0;
      for (int i = 1; i < max; i++) {
         int a = getDivisorSum(i);
         int b = getDivisorSum(a);
         if (i == b && a != b) {
            sum += i;
         }
      }
      return sum;
   }
}
