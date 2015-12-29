import java.util.*;

public class Problem081{
	
	public static void main(String[] args) {
		System.out.println(new Problem081().run());
	}
	
	
	public String run() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		long[][] grid = new long[num][num];
		for(int row = 0;row < num;row++){
			for(int col = 0;col < num;col++){
				grid[row][col] = scan.nextInt();
			}
		}
        long temp = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[i].length - 1; j >= 0; j--) {

				if (i + 1 < grid.length && j + 1 < grid[i].length)
					temp = Math.min(grid[i + 1][j], grid[i][j + 1]);
				else if (i + 1 < grid.length)
					temp = grid[i + 1][j];
				else if (j + 1 < grid[i].length)
					temp = grid[i][j + 1];
				else
					temp = 0;
				grid[i][j] += temp;
			}
		}
		return Long.toString(grid[0][0]);
	}	
}
