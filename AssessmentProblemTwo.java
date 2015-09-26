import java.util.*;

class HashingLinear {
	
	int size;
	String[] hashArray;
	int count;

	HashingLinear(int size) {
		this.size = size;
		hashArray = new String[size];
		count = 0;
	}

	private int myHashFunction(String key){
		String value = key;
		int sumEven = 0;
		int sumOdd = 0;
		for(int i = 0; i < value.length(); i++) {
			if(i%2 == 0) {
				sumEven = sumEven + (int)value.charAt(i);
			}else {
				sumOdd = sumOdd + (int)value.charAt(i);
			}
		}
			int total = (sumEven % 12 ) + (sumOdd % 12);
			int hash = total % 12;

			return hash;
	}

	public void insertValue(String dataValue){
		int temp = myHashFunction(dataValue);
		int i = temp;
		do{
			if (hashArray[i] == null){
				hashArray[i] = dataValue;
				return;
			}
			i = (i + 1) % size;
		} while (i != temp);  
		count++;
	}

	public void remove(String data) {

		int i = myHashFunction(data);

		while ( !(data.equals(hashArray[i])) ) 
			i = (i + 1) % size;
		hashArray[i] = null;

		for (i = (i + 1) % size; hashArray[i] != null; i = (i + 1) % size) {
			String tmp1 = hashArray[i];
			hashArray[i] = null;
			insertValue(tmp1);
		}
	}

	public int getKey(String dataValue) {
		int  i = myHashFunction(dataValue);
		while (hashArray[i] != null) {
			if (hashArray[i].equals(dataValue) )
				return i;
			i = (i + 1) % size;
		}
		return 0;
	}

	public void getAllValues() {
		for(int i = 0; i < size ;i++) {
			System.out.print(hashArray[i] + " ");
		}
	}
 
}


public class AssessmentProblemTwo {
	public static void main(String[] args) {
		HashingLinear hl = new HashingLinear(12);
		Scanner scan = new Scanner(System.in);

		String outValue = scan.nextLine();
		String deleteValues = scan.nextLine();

		StringTokenizer st = new StringTokenizer(outValue , ",");
			while (st.hasMoreTokens()) {
				hl.insertValue(st.nextToken());
			}
		hl.getAllValues();
		System.out.println();
		StringTokenizer divide = new StringTokenizer(deleteValues , ",");
			while (divide.hasMoreTokens()) {
				hl.remove(divide.nextToken());
				hl.getAllValues();
				System.out.println();
			}
		
	}
}
