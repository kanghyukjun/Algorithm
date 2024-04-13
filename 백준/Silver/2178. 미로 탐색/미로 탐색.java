import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };
	static final int INF = 100 * 100 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// get input
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[row][col];
		for (int i = 0; i < row; i++) {
			String line = br.readLine();
			for (int j = 0; j < col; j++) {
				int value = line.charAt(j) - '0';
				if (value == 0) {
					map[i][j] = -1;
				} else {
					map[i][j] = INF;
				}
			}
		}

		// process
		// BFS
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { 0, 0, 1 });
		map[0][0] = 1;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			if (map[current[0]][current[1]] < current[2]) {
				continue;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nRow = current[0] + drow[dir];
				int nCol = current[1] + dcol[dir];
				if (!isValid(map, nRow, nCol) || map[nRow][nCol] == -1)
					continue;

				if (map[nRow][nCol] > current[2] + 1) {
					map[nRow][nCol] = current[2] + 1;
					que.add(new int[] { nRow, nCol, current[2] + 1 });
				}
			}
		}

		// output
		System.out.println(map[row - 1][col - 1]);
	}

	public static boolean isValid(int[][] map, int row, int col) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}