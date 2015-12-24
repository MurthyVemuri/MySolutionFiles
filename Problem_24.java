import java.util.*;



public class Problem_24{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countTest = scan.nextInt();
		for(int i = 1; i <= countTest; i++) {
			System.out.println(new Problem_24().run(scan.nextInt()));
		}
	}

	private String getCharForNumber(int i) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		if (i > 25) {
			return null;
		}
		return Character.toString(alphabet[i]);
	}
	
	
	public String run(int number) {
		String[] array = new String[13];
		for (int i = 0; i < array.length; i++)
			array[i] = getCharForNumber(i);
		

		for (int i = 1; i < number; i++) {
			if (!getNextPermutation(array))
				throw new AssertionError();
		}
		

		String ans = "";
		for (int i = 0; i < array.length; i++)
			ans += array[i];
		return ans;
	}

	public boolean getNextPermutation(String[] a) {
		int n = a.length, i, j;
		for (i = n - 2; ; i--) {
			if (i < 0)
				return false;
			if ( (a[i]).compareTo(a[i + 1]) == -1 )
				break;
		}
		for (j = 1; i + j < n - j; j++) {
			String tp = a[i + j];
			a[i + j] = a[n - j];
			a[n - j] = tp;
		}
		for (j = i + 1; a[j].compareTo(a[i]) == -1 || a[j].compareTo(a[i]) == 0; j++);
		String tp = a[i];
		a[i] = a[j];
		a[j] = tp;
		return true;
	}
	
}
