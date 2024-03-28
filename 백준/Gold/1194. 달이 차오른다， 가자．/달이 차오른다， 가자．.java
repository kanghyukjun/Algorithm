import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };
	static int min = Integer.MAX_VALUE;

	static char[][] map;
	static boolean[][][] visited;

	static class State {
		int row;
		int col;
		int key;
		int count;

		public State(int row, int col, int key, int count) {
			super();
			this.row = row;
			this.col = col;
			this.key = key;
			this.count = count;
		}

		void addKey(char c) {
			key = key | (1 << (c - 'a'));
		}

		boolean hasKey(char C) {
			return (key & (1 << (C - 'A'))) == 1 << (C - 'A');
		}

		@Override
		public String toString() {
			return "State [row=" + row + ", col=" + col + ", key=" + key + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C][64];

		int[] start = new int[] { -1, -1 };
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0')
					start = new int[] { i, j };
			}
		}

		// process
		// bfs 이용
		solve(start);

		// output
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void solve(int[] start) {
		Queue<State> que = new ArrayDeque<>();
		que.add(new State(start[0], start[1], 0, 0));
		while (!que.isEmpty()) {
			State current = que.poll();
//			System.out.println(current);

			for (int dir = 0; dir < 4; dir++) {
				int nrow = current.row + drow[dir];
				int ncol = current.col + dcol[dir];
				int nCount = current.count + 1;

				// 범위를 벗어나거나, 벽이라면 이동할 수 없다
				if (nrow < 0 || nrow >= map.length || ncol < 0 || ncol >= map[0].length || map[nrow][ncol] == '#')
					continue;

				// 다음에 올 위치를 방문하지 않았고
				// 다음 위치가 문이 아니거나
				// 문이 아니더라도 키가 있다면 들어올 수 있다
				if ((!visited[nrow][ncol][current.key])
						&& (!isDoor(map[nrow][ncol]) || (isDoor(map[nrow][ncol]) && current.hasKey(map[nrow][ncol])))) {
					visited[nrow][ncol][current.key] = true;

					// 현재 위치가 도착지점이라면 최솟값을 갱신한다
					if (map[nrow][ncol] == '1') {
						min = Math.min(min, nCount);
					} else {
						// 현재 위치가 키라면 키를 집는다
						State state = new State(nrow, ncol, current.key, nCount);
						if (isKey(map[nrow][ncol])) {
							state.addKey(map[nrow][ncol]);
						}
						que.add(state);
					}
				}
			}
		}

	}

//	private static void solve(int row, int col, int move, int[] end) {
//		if(move > min) {
//			return;
//		}
//		else if (end[0] == row && end[1] == col) {
//			min = Math.min(min, move);
//		}
//		else {
//			for (int dir = 0; dir < 4; dir++) {
//				int nrow = row + drow[dir];
//				int ncol = col + dcol[dir];
//
//				// 범위를 벗어나거나, 벽이라면 이동할 수 없다
//				if (nrow < 0 || nrow >= map.length || ncol < 0 || ncol >= map[0].length || map[nrow][ncol] == '#')
//					continue;
//
//				// 다음에 올 위치를 방문하지 않았고
//				// 다음 위치가 문이 아니거나
//				// 문이 아니더라도 키가 있다면 들어올 수 있다
//				if ((visited[nrow][ncol] == -1 || visited[nrow][ncol] != keys)
//						&& (!isDoor(map[nrow][ncol]) || isDoor(map[nrow][ncol]) && hasKey(map[nrow][ncol]))) {
//					int tmpKey = visited[nrow][ncol];
//					visited[nrow][ncol] = keys;
//
//					// 현재 위치가 키라면 키를 집는다
//					if (isKey(map[nrow][ncol])) {
//						addKey(map[nrow][ncol]);
//						solve(nrow, ncol, move + 1, end);
//						removeKey(map[nrow][ncol]);
//					} else {
//						solve(nrow, ncol, move + 1, end);
//					}
//					visited[nrow][ncol] = tmpKey;
//				}
//			}
//
//		}
//	}

	private static boolean isKey(char c) {
		return 'a' <= c && c <= 'f';
	}

	private static boolean isDoor(char C) {
		return 'A' <= C && C <= 'F';
	}

}