import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Current {
		int row;
		int col;
		int moveCount;
		boolean isDestroyed;

		public Current(int row, int col, int moveCount, boolean isDestroyed) {
			super();
			this.row = row;
			this.col = col;
			this.moveCount = moveCount;
			this.isDestroyed = isDestroyed;
		}

	}

	static final int INF = 1_000_001;
	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// process
		// 갈수 없는 곳이 있을 때 한번은 벽을 부시고 이동한다.
		// 각 노드는 현재 이동한 거리와, 벽을 부순 횟수를 기록한다.
		// 이동 거리가 가장 짧은 노드를 출력한다.
		int[][] isChecked = new int[N][M];
		int[][] isDestoyChecked = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isChecked[i][j] = INF;
				isDestoyChecked[i][j] = INF;
			}
		}

		isChecked[0][0] = 1;
		Queue<Current> que = new ArrayDeque<Current>();
		que.add(new Current(0, 0, 1, false));
		while (!que.isEmpty()) {
			Current current = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = current.row + drow[i];
				int nextCol = current.col + dcol[i];
				int nextMoveCount = current.moveCount + 1;

				if (!isValid(nextRow, nextCol))
					continue;

				if (isWall(nextRow, nextCol)) {
					if (current.isDestroyed)
						continue;

					if (isDestoyChecked[nextRow][nextCol] <= nextMoveCount)
						continue;
					isDestoyChecked[nextRow][nextCol] = nextMoveCount;
					que.add(new Current(nextRow, nextCol, nextMoveCount, true));
				} else {
					if (current.isDestroyed) {
						if (isDestoyChecked[nextRow][nextCol] <= nextMoveCount)
							continue;
						isDestoyChecked[nextRow][nextCol] = nextMoveCount;
						que.add(new Current(nextRow, nextCol, nextMoveCount, true));
					} else {
						if (isChecked[nextRow][nextCol] <= nextMoveCount)
							continue;
						isChecked[nextRow][nextCol] = nextMoveCount;
						que.add(new Current(nextRow, nextCol, nextMoveCount, false));
					}
				}
			}
		}
		
		int output = Math.min(isChecked[N - 1][M - 1], isDestoyChecked[N - 1][M - 1]);
		System.out.println(output == INF ? -1 : output);
	}

	static boolean isValid(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}

	static boolean isWall(int row, int col) {
		return map[row][col] == 1;
	}

}