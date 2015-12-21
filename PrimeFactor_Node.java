import java.util.*;

public class PrimeFactor_Node {

	Comparator<Node> comp = new Comparator<Node>() {

		public int compare(Node n1, Node n2) {

			if (n1 != null && n2 != null) {

				return n1.getPrimeProduct() - n2.getPrimeProduct();

			}

			return 0;

		}

	};

	public static void main(String[] args) {

		Scanner scanner = new Scanner (System.in);

		int countTestCases = Integer.parseInt(scanner.nextLine());

		for(int r = 1; r <= countTestCases; r++) {

			String line = scanner.nextLine();

			String[] splitString = line.split(" ");

			int countNumber = Integer.parseInt(splitString[0]);

			Node[] nodes = new Node[countNumber+1];

			int checkNumber = Integer.parseInt(splitString[1]);

			int number;

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

					nodes[j] = new Node();

					nodes[j].setKey(j);

					nodes[j].setPrimeProduct(primeMultiply);

				}

			}

			PrimeFactor pf = new PrimeFactor();

			Arrays.sort(nodes, pf.comp);

			System.out.println(nodes[checkNumber].getKey());

		}

	}

}

class Node {

	int key;

	int primeProduct;

	public int getKey() {

		return key;

	}

	public int getPrimeProduct() {

		return primeProduct;

	}

	public void setPrimeProduct( int primeProduct) {

		this.primeProduct = primeProduct;

	}

	public void setKey( int key) {

		this.key = key;

	}

}
