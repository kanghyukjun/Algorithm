import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static class Node {
		int row;
		int col;

		private Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int[][] map;
	public static int[] drow = { 1, -1, 0, 0 };
	public static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			int maxValue = 0;
			int maxCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = BFS(i, j);
					if (count > maxCount || (count == maxCount && map[i][j] < maxValue)) {
						maxCount = count;
						maxValue = map[i][j];
					}
				}
			}
			sb.append(maxValue).append(' ').append(maxCount).append('\n');
		}
		System.out.println(sb);
	}

	private static int BFS(int row, int col) {
		int N = map.length;
		int count = 1;

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(row, col));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int curRow = node.row + drow[i];
				int curCol = node.col + dcol[i];
				if (curRow < 0 || curCol < 0 || curRow >= N || curCol >= N
						|| map[curRow][curCol] - map[node.row][node.col] != 1)
					continue;
				count++;
				queue.add(new Node(curRow, curCol));
			}
		}

		return count;
	}

}