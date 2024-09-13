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

		// get input
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// process
		// 1. 모든 한 지점에서 BFS를 수행한다
		// 2. BFS를 수행한 값은 자동으로 두번이상 지나가거나 멀리 돌아가지 않음
		// 3. BFS를 수행한 값중 가장 큰 값을 확인한다
		// 4. 전역으로 BFS를 수행해서 가장 큰 값을 얻은 값중 최댓값을 출력한다

		int max = 0;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 'W')
					continue;

				Queue<int[]> que = new ArrayDeque<>();
				que.add(new int[] { row, col, 0 });
				int[][] isChecked = new int[R][C];
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						isChecked[i][j] = -1;
					}
				}

				isChecked[row][col] = 0;

				int currentMax = 0;
				while (!que.isEmpty()) {
					int[] current = que.poll();
					for (int dir = 0; dir < 4; dir++) {
						int nRow = current[0] + drow[dir];
						int nCol = current[1] + dcol[dir];
						int nCount = current[2] + 1;

						if (isValid(nRow, nCol, map)
								&& (isChecked[nRow][nCol] == -1 || isChecked[nRow][nCol] > nCount)) {
							isChecked[nRow][nCol] = nCount;
							que.add(new int[] { nRow, nCol, nCount });
							currentMax = Math.max(currentMax, nCount);
						}
					}
				}
				max = Math.max(max, currentMax);
			}
		}

		System.out.println(max);
	}

	public static boolean isValid(int row, int col, char[][] map) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length && map[row][col] != 'W';
	}

}