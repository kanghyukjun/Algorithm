import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dcol = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int C;
	static int R;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			// get input
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (C == 0 || R == 0) {
				break;
			}
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			int count = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0)
						continue;
					count++;
					Queue<int[]> que = new ArrayDeque<>();
					que.add(new int[] { i, j });
					while (!que.isEmpty()) {
						int[] cur = que.poll();
						for (int dir = 0; dir < 8; dir++) {
							int nextRow = cur[0] + drow[dir];
							int nextCol = cur[1] + dcol[dir];
							if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C
									|| map[nextRow][nextCol] == 0)
								continue;

							map[nextRow][nextCol] = 0;
							que.add(new int[] { nextRow, nextCol });
						}
					}
				}
			}
			
			// output
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

}