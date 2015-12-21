import java.util.*;

public class PrimeFactor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int countTestCases = Integer.parseInt(scanner.nextLine());
		for(int r = 1; r <= countTestCases; r++) {
			String line = scanner.nextLine();
			String[] splitString = line.split(" ");
			int countNumber = Integer.parseInt(splitString[0]);
			int checkNumber = Integer.parseInt(splitString[1]);
			int number;
			int keyValue = 2;
			int strKey = 2;
			Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>(); 
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int j = 1; j <= countNumber; j++) {
				number = j;
				int check = Integer.parseInt(splitString[1]);
				int primeMultiply = 1;
				int count;
				for (int i = 2; i <= (number); i++) {
					count = 0;
					while (number % i == 0) {
						number /= i;
						count++;
					}
					if (count == 0) {
						continue;
					}
					primeMultiply = i * primeMultiply;
				}
				hm.put(j,primeMultiply);
			}
			Enumeration<Integer> keys = hm.keys();
			while(keys.hasMoreElements()){
				int key = keys.nextElement();
				al.add(hm.get(key));
			}
			Collections.sort(al);
			for(int m = 0; m < countNumber; m++) {
				if(checkNumber == (m + 1)) {
					keyValue = al.get(m);
				}
			}
			for(Map.Entry entry: hm.entrySet()) {
				if(keyValue == (int)entry.getValue()) {
					strKey = (int)entry.getKey();
					break;
				}
			}
			System.out.println(strKey);
		}
	}
}
