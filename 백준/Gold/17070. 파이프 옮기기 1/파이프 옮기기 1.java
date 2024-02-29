import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 0, 1, 1 };
	static int[] dcol = { 1, 1, 0 };

	static int count = 0;

	static class Pipe {
		static final int HOR = 0;
		static final int DIAG = 1;
		static final int VERT = 2;

		// head의 좌표를 저장하고 있다
		int row, col;

		int dir;

		public Pipe(int row, int col, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		solve(N, map);

		// output
		System.out.println(count);

	}

	private static void solve(int n, int[][] map) {
		// pipe의 머리가 (n-1, n-1)에 도착한다면 방법의 수를 증가
		Pipe start = new Pipe(0, 1, Pipe.HOR);
		Queue<Pipe> que = new ArrayDeque<>();

		que.add(start);
		while (!que.isEmpty()) {
			Pipe current = que.poll();

			if (current.dir == Pipe.HOR) {
				for (int dir = 0; dir < 2; dir++) {
					nextPipe(current, dir, que, n, map);
				}
			}

			else if (current.dir == Pipe.VERT) {
				for (int dir = 1; dir < 3; dir++) {
					nextPipe(current, dir, que, n, map);
				}
			}

			else if (current.dir == Pipe.DIAG) {
				for (int dir = 0; dir < 3; dir++) {
					nextPipe(current, dir, que, n, map);
				}
			}

		}

	}

	private static void nextPipe(Pipe current, int dir, Queue<Pipe> que, int n, int[][] map) {
		int nextRow = current.row + drow[dir];
		int nextCol = current.col + dcol[dir];
		if (nextRow >= n || nextCol >= n) {
			return;
		}

		if (dir == Pipe.HOR && (map[nextRow][nextCol] == 1)) {
			return;
		}

		else if (dir == Pipe.DIAG
				&& (map[nextRow][nextCol] == 1 || map[nextRow - 1][nextCol] == 1 || map[nextRow][nextCol - 1] == 1)) {
			return;
		}

		else if (dir == Pipe.VERT && (map[nextRow][nextCol] == 1)) {
			return;
		}

		if (nextRow == n - 1 && nextCol == n - 1) {
			count++;
		} else {
			que.add(new Pipe(nextRow, nextCol, dir));
		}
	}

}