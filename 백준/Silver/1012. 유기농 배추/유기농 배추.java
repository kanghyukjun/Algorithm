import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] isWeed = new boolean[R][C];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				isWeed[r][c] = true;
			}

			// process
			int count = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (isWeed[i][j]) {
						isWeed[i][j] = false;
						count++;

						// BFS
						Queue<int[]> que = new ArrayDeque<>();
						que.add(new int[] { i, j });
						while (!que.isEmpty()) {
							int[] current = que.poll();
							for (int dir = 0; dir < 4; dir++) {
								int nRow = current[0] + drow[dir];
								int nCol = current[1] + dcol[dir];
								if (nRow < 0 || nRow >= R || nCol < 0 || nCol >= C || !isWeed[nRow][nCol])
									continue;

								isWeed[nRow][nCol] = false;
								que.add(new int[] { nRow, nCol });
							}
						}
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

}