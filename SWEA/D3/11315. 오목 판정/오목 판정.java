import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static int[] drow = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int[] dcol = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int N;
	static char[][] arr;
	static boolean success;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');
			success = false;

			// get input
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = input.charAt(j);
				}
			}

			// process
			boolean check = find();
			
			// output
			if(check)
				sb.append("YES").append('\n');
			else
				sb.append("NO").append('\n');
		}
		System.out.println(sb);
	}

	private static boolean find() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '.')
					continue;

				for (int dir = 0; dir < 8; dir++) {
					int row = i + drow[dir];
					int col = j + dcol[dir];
					if (!isValid(row, col))
						continue;

					if (arr[row][col] == 'o') {
						dfs(2, row, col, dir);
						if (success) {
							return true;
						}
					}
				}

			}
		}
		return false;
	}

	private static void dfs(int depth, int row, int col, int dir) {
		if (depth == 5) {
			success = true;
			return;
		}

		int nextRow = row + drow[dir];
		int nextCol = col + dcol[dir];
		if (!isValid(nextRow, nextCol) || arr[nextRow][nextCol] != 'o')
			return;
		dfs(depth + 1, nextRow, nextCol, dir);
	}

	private static boolean isValid(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}

}