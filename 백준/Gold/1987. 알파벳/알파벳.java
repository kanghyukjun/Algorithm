import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class State {
		int row;
		int col;
		int count;
		boolean[] isChecked;

		public State(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
			isChecked = new boolean['Z' - 'A' + 1];
		}

		public State(int row, int col, int count, boolean[] isChecked) {
			this.row = row;
			this.col = col;
			this.count = count;
			this.isChecked = Arrays.copyOf(isChecked, isChecked.length);
		}

		public void check(char C) {
			this.isChecked[C - 'A'] = true;
		}

		public boolean isNotChecked(char C) {
			return !this.isChecked[C - 'A'];
		}

	}

	static char[][] map;
	static int R;
	static int C;

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// process
		boolean[] isChecked = new boolean['Z' - 'A' + 1];
		isChecked[map[0][0] - 'A'] = true;
		dfs(0, 0, 1, isChecked);

		// output
		System.out.println(max);
	}

	public static void dfs(int row, int col, int count, boolean[] isChecked) {
		max = Math.max(max, count);

		for (int dir = 0; dir < 4; dir++) {
			int nRow = row + drow[dir];
			int nCol = col + dcol[dir];
			if (isValid(nRow, nCol) && !isChecked[map[nRow][nCol] - 'A']) {
				isChecked[map[nRow][nCol] - 'A'] = true;
				dfs(nRow, nCol, count + 1, isChecked);
				isChecked[map[nRow][nCol] - 'A'] = false;
			}
		}
	}

	public static boolean isValid(int row, int col) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}