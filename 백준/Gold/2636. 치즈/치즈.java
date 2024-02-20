import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int sum = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					sum++;
				}
			}
		}

		// process
		int time = 0;
		int copySum = 0;
		while (sum > 0) {
			copySum = sum;

			// 한 사이클 돌리기
			// map을 변경
			boolean[][] check = new boolean[R][C];
			Queue<int[]> que = new ArrayDeque<>();
			que.add(new int[] { 0, 0 });
			while (!que.isEmpty()) {
				int[] current = que.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nextRow = current[0] + drow[dir];
					int nextCol = current[1] + dcol[dir];
					if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || check[nextRow][nextCol]) {
						continue;
					}
					check[nextRow][nextCol] = true;
					if (map[nextRow][nextCol] == 1) {
						map[nextRow][nextCol] = 0;
						sum--;
					} else {
						que.add(new int[] { nextRow, nextCol });
					}
				}
			}

			time++;
		}
		
		// output
		sb.append(time).append('\n').append(copySum);
		System.out.println(sb);
	}

}