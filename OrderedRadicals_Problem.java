import java.util.*;

class OrderedRadicals_Problem {
	public OrderedRadicals_Problem(){

		Scanner scanner = new Scanner (System.in);
		int countTestCases = Integer.parseInt(scanner.nextLine());
		for(int r = 1; r <= countTestCases; r++) {
			String line = scanner.nextLine();
			String[] splitString = line.split(" ");
			int number = Integer.parseInt(splitString[0]);
			int checkNumber = Integer.parseInt(splitString[1]);

			Pair[] pair = new Pair[number+1];
			pair[0] = new Pair(0,0);
			for(int i = 1; i <= number; i++){
				Set<Integer> s = PrimeFactorizaion(i);
				pair[i] = new Pair(i,1);
				for(Integer j : s){
					pair[i].value *= j;
				}
			}
			Arrays.sort(pair);
			for(int i = 1; i <= number; i++){
				if(checkNumber == i)
				System.out.println(pair[i]);
			}
		}
	}
	
	public Set<Integer> PrimeFactorizaion(int number){
		Set<Integer> a = new TreeSet<Integer>();
		for(int j = 2; j <= Math.sqrt(number); j++){
			if(number % j == 0){
				a.add(j);
				a.addAll(PrimeFactorizaion(number/j));
				return a;
			}
		}
		a.add(number);
		return a;
	}
	
	class Pair implements Comparable<Pair>{
		
		int key, value;
		
		Pair(int key, int value){
			this.key = key;
			this.value = value;
		}
		
		public String toString(){
			return ""+key;
		}

		public int compareTo(Pair b) {
			if(value > b.value)
				return 1;
			if(value < b.value)
				return -1;
			return 0;
		}
	}
}

public class Main_124 {
	
	public static void main(String[] args) {
		new OrderedRadicals_Problem();
	}
}
