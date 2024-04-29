import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

	static List<Integer> list = new ArrayList<>();

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				int n = line.charAt(j) - '0';
				if (n == 1)
					map[i][j] = -1;
			}
		}

		// process
		int start = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == -1) {
					start++;
					BFS(map, row, col, start);
				}
			}
		}
		
		// output
		sb.append(start).append('\n');
		Collections.sort(list);
		list.forEach(x -> sb.append(x).append('\n'));
		System.out.println(sb);
	}

	private static void BFS(int[][] map, int row, int col, int fill) {
		int count = 1;

		// BFS
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { row, col });
		map[row][col] = fill;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nRow = current[0] + drow[dir];
				int nCol = current[1] + dcol[dir];
				if (nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map[0].length || map[nRow][nCol] != -1)
					continue;

				map[nRow][nCol] = fill;
				count++;
				que.add(new int[] { nRow, nCol });
			}
		}

		// output
		list.add(count);
	}

}