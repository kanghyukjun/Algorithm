import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] originMap;

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };
	static int INF;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			originMap = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					originMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			// 1. 중복을 허용하는 순열을 이용해서 구슬을 떨어뜨릴 수 있는 위치를 구한다 (위치 : 0 ~ R-1)
			// 2. 위치를 모두 결정하면 mapCopy를 한 후 시뮬레이션을 한다
			// 2-a. BFS를 이용해 연쇄작용을 구현한다
			// 3. 연쇄 작용이 모두 끝나면 블럭을 아래로 내리고 수를 구한다
			int[] dropOrder = new int[N];
			INF = fall(originMap);
			min = INF;
			drop(0, dropOrder);

			// output
			sb.append(min).append('\n');
		}
		System.out.println(sb);
	}

	private static void drop(int depth, int[] dropOrder) {
		if (depth == N) {
			// simulation go
			int[][] mapCopy = copyArr(originMap);
			int count = simulation(mapCopy, dropOrder);
			min = Math.min(min, count);
		} else {
			for (int i = 0; i < originMap[0].length; i++) {
				dropOrder[depth] = i;
				drop(depth + 1, dropOrder);
			}
		}
	}

	private static int simulation(int[][] map, int[] dropOrder) {
		int count = INF;
		int R = map.length;
		int C = map[0].length;

		
		for (int dropCol : dropOrder) {
			// 맨 위에서부터 떨어졌을 때 처음 만나는 0이 아닌 블럭 찾기
			// row가 R과 같거나 커지거나, 혹은 map[row][col]이 0이 아니면 멈춰야 함
			// -> row가 R보다 작고 map[row][col]이 0이어야 함
			int row = 0;
			while (row < R && map[row][dropCol] == 0) {
				row++;
			}
			if (row == R)
				continue;
			
			// 해당 블럭에서부터 bfs 실행
			int[] start = new int[] { row, dropCol, map[row][dropCol] };
			Queue<int[]> que = new ArrayDeque<>();
			que.add(start);
			map[start[0]][start[1]] = 0;
			while (!que.isEmpty()) {
				int[] current = que.poll();
				for (int dir = 0; dir < 4; dir++) {
					for (int multi = 1; multi < current[2]; multi++) {
						int nRow = current[0] + drow[dir] * multi;
						int nCol = current[1] + dcol[dir] * multi;

						// 범위 체크
						if (nRow < 0 || nRow >= R || nCol < 0 || nCol >= C)
							continue;
						if (map[nRow][nCol] == 0)
							continue;
						
						que.add(new int[] { nRow, nCol, map[nRow][nCol] });
						map[nRow][nCol] = 0;
					}
				}
			}
			count = fall(map);
		}

		return count;
	}

	private static int fall(int[][] map) {
		int count = 0;
		int R = map.length;
		int C = map[0].length;

		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0)
					count++;

				int curCol = i;
				while (curCol != R - 1 && map[curCol + 1][j] == 0) {
					map[curCol + 1][j] = map[curCol][j];
					map[curCol][j] = 0;
					curCol++;
				}
			}
		}

		return count;
	}

	private static int[][] copyArr(int[][] arr) {
		int[][] copy = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		return copy;
	}
}