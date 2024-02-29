import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 999999;
	
	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };
	static int[] dHorseRow = { -1, -2, -1, -2, 1, 2, 1, 2 };
	static int[] dHorseCol = { -2, -1, 2, 1, -2, -1, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int horseMove = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		int min = solve(map, horseMove);

		// output
		System.out.println(min == INF ? -1 : min);
	}

	private static int solve(int[][] map, int horseMove) {
		final int R = map.length;
		final int C = map[0].length;

		// map[i][j]에서 horseMove를 k만큼 썼을 때의 최소 이동 횟수
		int[][][] count = new int[R][C][horseMove + 1];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < horseMove + 1; k++) {
					count[i][j][k] = INF;
				}
			}
		}

		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { 0, 0, 0 });
		for (int i = 0; i < horseMove + 1; i++) {
			count[0][0][i] = 0;
		}

		while (!que.isEmpty()) {
			int[] current = que.poll();

			// horse
			if (current[2] < horseMove) {
				for (int dir = 0; dir < 8; dir++) {
					int nextRow = current[0] + dHorseRow[dir];
					int nextCol = current[1] + dHorseCol[dir];
					int nextHorse = current[2] + 1;

					if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] == 1) {
						continue;
					}

					if (count[nextRow][nextCol][nextHorse] <= count[current[0]][current[1]][current[2]] + 1) {
						continue;
					}

					count[nextRow][nextCol][nextHorse] = count[current[0]][current[1]][current[2]] + 1;
					que.add(new int[] { nextRow, nextCol, nextHorse });
				}
			}

			// monkey
			for (int dir = 0; dir < 4; dir++) {
				int nextRow = current[0] + drow[dir];
				int nextCol = current[1] + dcol[dir];
				int nextHorse = current[2];

				if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] == 1) {
					continue;
				}

				if (count[nextRow][nextCol][nextHorse] <= count[current[0]][current[1]][current[2]] + 1) {
					continue;
				}

				count[nextRow][nextCol][nextHorse] = count[current[0]][current[1]][current[2]] + 1;
				que.add(new int[] { nextRow, nextCol, nextHorse });
			}
		}

		// output
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= horseMove; i++) {
			min = Math.min(min, count[R - 1][C - 1][i]);
		}
		return min;
	}

}