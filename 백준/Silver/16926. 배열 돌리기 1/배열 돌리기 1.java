import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static int[] drow = { 1, 0, -1, 0 };
	private static int[] dcol = { 0, 1, 0, -1 };

	// 반시계방향 회전
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			Deque<Integer> dq = new ArrayDeque<>();
			int leftBound = i;
			int rightBound = M - i;
			int lowerBound = i;
			int upperBound = N - i;
			int dirIdx = 0;

			// dq에 담기
			int row = i;
			int col = i;
			do {
				dq.addLast(arr[row][col]);
				if (row + drow[dirIdx] < lowerBound || row + drow[dirIdx] >= upperBound
						|| col + dcol[dirIdx] < leftBound || col + dcol[dirIdx] >= rightBound) {
					dirIdx = (dirIdx + 1) % 4;
				}
				row += drow[dirIdx];
				col += dcol[dirIdx];
			} while ((row != i || col != i));

			int rotate = R % (2 * (M + N - 4 * i) - 4);
			for (int j = 0; j < rotate; j++) {
				if (row + drow[dirIdx] < lowerBound || row + drow[dirIdx] >= upperBound
						|| col + dcol[dirIdx] < leftBound || col + dcol[dirIdx] >= rightBound) {
					dirIdx = (dirIdx + 1) % 4;
				}
				row += drow[dirIdx];
				col += dcol[dirIdx];
			}
			
			int rowEnd = row;
			int colEnd = col;
			do {
				arr[row][col] = dq.pollFirst();
				if (row + drow[dirIdx] < lowerBound || row + drow[dirIdx] >= upperBound
						|| col + dcol[dirIdx] < leftBound || col + dcol[dirIdx] >= rightBound) {
					dirIdx = (dirIdx + 1) % 4;
				}
				row += drow[dirIdx];
				col += dcol[dirIdx];
			} while ((row != rowEnd || col != colEnd));
		}
		
		// output
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}