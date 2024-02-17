import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		List<int[]> ripe = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					ripe.add(new int[] { i, j });
				}
			}
		}

		// process
		int[][] count = new int[R][C];
		int max = 0;
		Queue<int[]> que = new ArrayDeque<>(ripe);
		while (!que.isEmpty()) {
			int[] current = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nextRow = current[0] + drow[dir];
				int nextCol = current[1] + dcol[dir];
				if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] == -1)
					continue;

				if (map[nextRow][nextCol] == 0 || count[nextRow][nextCol] > count[current[0]][current[1]] + 1) {
					map[nextRow][nextCol] = 1;
					count[nextRow][nextCol] = count[current[0]][current[1]] + 1;
					max = Math.max(max, count[nextRow][nextCol]);
					que.add(new int[] { nextRow, nextCol });
				}
			}
		}
		
		// output
		boolean flag = true;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					flag = false;
					break;
				}
			}
		}
		if(!flag) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
	}

}