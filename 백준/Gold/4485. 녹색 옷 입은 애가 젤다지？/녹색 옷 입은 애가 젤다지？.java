import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int row;
		int col;
		int sum;

		public Node(int row, int col, int sum) {
			super();
			this.row = row;
			this.col = col;
			this.sum = sum;
		}

	}

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		final int INF = 999999;

		// get input
		int tcCount = 1;
		int N = Integer.parseInt(br.readLine());
		while (N != 0) {
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			Queue<Node> que = new ArrayDeque<>();
			int[][] sum = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(sum[i], INF);
			}
			que.add(new Node(0, 0, map[0][0]));
			sum[0][0] = map[0][0];
			while (!que.isEmpty()) {
				// 꺼낸 값이 현재 값보다 작다면 패스
				Node current = que.poll();
				if (current.sum > sum[current.row][current.col])
					continue;

				// 4방탐색
				for (int dir = 0; dir < 4; dir++) {
					int nextRow = current.row + drow[dir];
					int nextCol = current.col + dcol[dir];
					if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)
						continue;
					
					// 현재 값에 더한 값이 만약 그 값보다 작다면
					// 그 값을 업데이트하고 새롭게 큐에 추가
					int nextSum = current.sum + map[nextRow][nextCol];
					if(nextSum < sum[nextRow][nextCol]) {
						sum[nextRow][nextCol] = nextSum;
						que.add(new Node(nextRow, nextCol, nextSum));
					}
				}
				
			}

			// output
			sb.append("Problem ").append(tcCount++).append(": ").append(sum[N-1][N-1]).append('\n');
			
			// get input
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}

}