import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { -1, 0, 1 };
	static int[] dcol = { 1, 1, 1 };

	static int R;
	static int C;
	static char[][] map;
	static boolean flag;
	static boolean[][] check;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R][C];
		max = 0;
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = in.charAt(j);
			}
		}

		// process
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}

		// output
		System.out.println(max);
	}

	private static void dfs(int row, int col) {
		if (col == C - 1) {
			max++;
			flag = true;
			return;
		}

		for (int dir = 0; dir < 3; dir++) {
			int nextRow = row + drow[dir];
			int nextCol = col + dcol[dir];
			if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] == 'x' || check[nextRow][nextCol])
				continue;

			map[nextRow][nextCol] = 'x';
			dfs(nextRow, nextCol);
			if(flag) {
				return;
			}
			map[nextRow][nextCol] = '.';
			check[nextRow][nextCol] = true; // 방문했으나, 끝에 다다를 수 없는 경로이기 때문
		}

	}

}