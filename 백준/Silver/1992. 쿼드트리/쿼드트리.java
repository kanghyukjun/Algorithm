import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = in.charAt(j) - '0';
			}
		}

		// process
		quadTree(0, 0, N, N);

		// output
		System.out.println(sb);
	}

	private static void quadTree(int startRow, int startCol, int endRow, int endCol) {
		int sum = 0;
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				if (arr[i][j] == 1)
					sum++;
			}
		}

		if (sum == 0) {
			sb.append('0');
		} else if (sum == (endRow - startRow) * (endCol - startCol)) {
			sb.append('1');
		} else {
			sb.append('(');
			quadTree(startRow, startCol, startRow + (endRow - startRow) / 2, startCol + (endCol - startCol) / 2);
			quadTree(startRow, startCol + (endCol - startCol) / 2, startRow + (endRow - startRow) / 2, endCol);
			quadTree(startRow + (endRow - startRow) / 2, startCol, endRow, startCol + (endCol - startCol) / 2);
			quadTree(startRow + (endRow - startRow) / 2, startCol + (endCol - startCol) / 2, endRow, endCol);
			sb.append(')');
		}
	}
}