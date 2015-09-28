import java.util.Scanner;

class GraphDemo {
	
	@SuppressWarnings("unused")
	private int graphVertices;
	private int[][] graphMatrix;

	GraphDemo(int graphVertices) {
		this.graphVertices = graphVertices;
		graphMatrix = new int[graphVertices][graphVertices];
	}

	public void createEdge(int setTo , int setFrom , int edgeValue) {
		try{
			graphMatrix[setTo][setFrom] = edgeValue;
		}catch (Exception e) {}
	}

	public int getEdge(int setTo , int setFrom) {
		return graphMatrix[setTo][setFrom];
	}

}

public class GraphProblemTwo {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		GraphDemo gd = new GraphDemo(size);
		int toValue[] = new int[size];
		int fromValue = 0;

		for(int i = 0 ; i < size; i++) {
			toValue[i] = scan.nextInt();
			fromValue = scan.nextInt();
			gd.createEdge(toValue[i] , fromValue , 1);
		}
		
		System.out.print("  ");
		for (int i = 0; i < size; i++)
			System.out.print(toValue[i] + " ");
		System.out.println();
		try {
			for (int i = 1; i <= size + 1; i++) {
				System.out.print(i + " ");
					for (int j = 1; j <= size + 1; j++) 
						System.out.print(gd.getEdge(i, j) + " ");
				System.out.println();
			}
		}catch (Exception e) {}
	}
}