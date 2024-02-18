import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int D;

	static int map[][];
	static int archers[];
	static int maxCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		archers = new int[3];
		maxCount = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		solve(0, 0);

		// output
		System.out.println(maxCount);
	}

	static int[] drow = { 0, -1, 0 };
	static int[] dcol = { -1, 0, 1 };

	private static void solve(int depth, int idx) {
		if (depth == 3) {
			// init
			int count = 0;
			int[][] copyMap = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					copyMap[i][j] = map[i][j];
				}
			}

			for (int turn = 0; turn < R; turn++) {
				// 각 궁수의 위치에서 제거할 수 있는 적이 있는지 확인
				// BFS
				for (int archer = 0; archer < archers.length; archer++) {
					int[] startIdx = new int[] { R, archers[archer], 0 };
					Queue<int[]> que = new ArrayDeque<>();
					que.add(startIdx);
					boolean flag = false;
					while (!que.isEmpty() && !flag) {
						int[] current = que.poll();
						for (int dir = 0; dir < 3; dir++) {
							int nextRow = current[0] + drow[dir];
							int nextCol = current[1] + dcol[dir];
							int nextDistance = current[2] + 1;
							if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || nextDistance > D) {
								continue;
							}
							if (copyMap[nextRow][nextCol] == 0) {
								que.add(new int[] { nextRow, nextCol, nextDistance });
							} else {
								if (copyMap[nextRow][nextCol] == 1) {
									copyMap[nextRow][nextCol] = -1;

									count++;
								}
								flag = true;
								break;
							}
						}
					}
				}

				// 적 이동
				for (int i = R - 1; i >= 0; i--) {
					for (int j = 0; j < C; j++) {
						if (copyMap[i][j] == 0)
							continue;
						if (copyMap[i][j] == 1 && i != R - 1) {
							copyMap[i + 1][j] = 1;
						}
						copyMap[i][j] = 0;
					}
				}

			}

			// 최대값 계산
			maxCount = Math.max(maxCount, count);
			return;
		}

		for (int i = idx; i < C; i++) {
			archers[depth] = i;
			solve(depth + 1, i + 1);
		}
	}
}