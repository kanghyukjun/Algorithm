import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] drow = { 0, 1, 0, -1 };
	static int[] dcol = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append('\n');

			// get input
			int N = Integer.parseInt(br.readLine());

			// process
			int[][] arr = BFS(N);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

	private static int[][] BFS(int n) {
		int[][] arr = new int[n][n];
		boolean[][] checked = new boolean[n][n];

		int row = 0;
		int col = 0;
		int idx = 0;
		int count = 1;

		while (count <= n * n) {
			checked[row][col] = true;
			arr[row][col] = count++;

			if (row + drow[idx] < 0 || row + drow[idx] >= n || col + dcol[idx] < 0 || col + dcol[idx] >= n
					|| checked[row + drow[idx]][col + dcol[idx]]) {
				idx = (idx + 1) % 4;
			}
			row += drow[idx];
			col += dcol[idx];
		}

		return arr;
	}

}