import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;
	static boolean[][] isChecked;

	static int max;
	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		isChecked = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				if (in.charAt(j) == 'H') {
					map[i][j] = -1;
				} else {
					map[i][j] = in.charAt(j) - '0';
				}
			}
		}

		// process
		max = -99;
		dfs(0, 0);

		// output
		if (max == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(max);
	}

	private static int dfs(int row, int col) {
		// dfs가 끝나면, 끝나기 전 까지의 최대 count 횟수를 dp 배열에 저장해두기
		// dp 배열에 값이 있으면 그 값을 사용
		// dp 배열에 값이 없으면 dfs 진행

		int curValue = map[row][col];
		int curMax = 0;
		isChecked[row][col] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nextRow = row + drow[dir] * curValue;
			int nextCol = col + dcol[dir] * curValue;
			int count = 0;
			if (!isValid(nextRow, nextCol) || map[nextRow][nextCol] == -1) {
				count = 1;
			} else {
				if (isChecked[nextRow][nextCol]) {
					max = Integer.MAX_VALUE;
					return max;
				} else if (dp[nextRow][nextCol] != 0) {
					count = dp[nextRow][nextCol] + 1;
				} else {
					count = dfs(nextRow, nextCol) + 1;
				}
			}
			curMax = Math.max(curMax, count);
			dp[row][col] = curMax;
			max = Math.max(curMax, max);
		}
		isChecked[row][col] = false;
		return curMax;
	}

	private static boolean isValid(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < M;
	}
}