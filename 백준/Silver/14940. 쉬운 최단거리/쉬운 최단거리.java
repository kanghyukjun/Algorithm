import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	final static int INF = 1000 * 1000 + 1;

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static class Node {
		int row;
		int col;
		int count;

		public Node(int row, int col, int count) {
			super();
			this.row = row;
			this.col = col;
			this.count = count;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		int[] start = new int[2];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0) {
					map[i][j] = -1;
				} else if (num == 2) {
					start[0] = i;
					start[1] = j;
				} else {
					map[i][j] = INF;
				}
			}
		}

		// process
		PriorityQueue<Node> que = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
		que.add(new Node(start[0], start[1], 0));
		while (!que.isEmpty()) {
			Node current = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nRow = current.row + drow[dir];
				int nCol = current.col + dcol[dir];
				if (isValid(map, nRow, nCol) && map[nRow][nCol] != -1 && map[nRow][nCol] > current.count + 1) {
					map[nRow][nCol] = current.count + 1;
					que.add(new Node(nRow, nCol, map[nRow][nCol]));
				}
			}
		}

		// output
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					sb.append(0).append(' ');
				else if (map[i][j] == INF)
					sb.append(-1).append(' ');
				else
					sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static boolean isValid(int[][] map, int row, int col) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}