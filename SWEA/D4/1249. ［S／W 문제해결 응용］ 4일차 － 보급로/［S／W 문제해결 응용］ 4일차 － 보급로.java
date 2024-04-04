import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	final static int INF = 100 * 100 * 9 + 1;

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	static class Edge implements Comparable<Edge> {
		int row;
		int col;
		int cost;

		public Edge(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			// process
			int[][] time = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], INF);
			}

			// dijkstra
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, 0, 0));
			time[0][0] = 0;
			while (!pq.isEmpty()) {
				Edge current = pq.poll();
				if (time[current.row][current.col] < current.cost)
					continue;

				for (int dir = 0; dir < 4; dir++) {
					int row = current.row + drow[dir];
					int col = current.col + dcol[dir];
					if (!isValid(row, col, time))
						continue;

					if (time[row][col] > current.cost + map[row][col]) {
						time[row][col] = current.cost + map[row][col];
						pq.add(new Edge(row, col, time[row][col]));
					}
				}
			}

			sb.append(time[N - 1][N - 1]).append('\n');
		}
		System.out.println(sb);
	}

	private static boolean isValid(int row, int col, int[][] map) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}