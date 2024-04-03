import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 0, -1, 0, 1 };
	static int[] dcol = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[] foot = new int[2];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					foot[0] = i;
					foot[1] = j;
				}
			}
		}

		// process
		for (int i = 0; i < T; i++) {
			// 시뮬레이션
			// 1. 미세먼지 퍼지기
			map = spreadDust(map);

			// 2. 바람 작동 후 미세먼지 제거
			map = eatDust(map, foot);
		}

		// 남아있는 미세먼지의 양 계산하기
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0)
					sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}

	private static int[][] eatDust(int[][] map, int[] foot) {
		int R = map.length;
		int C = map[0].length;
		int[][] copyMap = new int[R][C];

		int[] head = new int[2];
		head[0] = foot[0] - 1;
		head[1] = foot[1];

		// 순환
		// 1. head 순환, dir이 커지는 순서
		int dir = 0;
		int row = head[0] + drow[dir] * 2;
		int col = head[1] + dcol[dir] * 2;
		while (!(row == head[0] && col == head[1])) {
			// 이전 값 가져오기
			copyMap[row][col] = map[row - drow[dir]][col - dcol[dir]];
			if (!isValid(map, row + drow[dir], col + dcol[dir])) {
				dir = (dir + 1) % 4;
			}
			row += drow[dir];
			col += dcol[dir];
		}

		// 2. foot 순환, dir이 작아지는 순서
		dir = 0;
		row = foot[0] + drow[dir] * 2;
		col = foot[1] + dcol[dir] * 2;
		while (!(row == foot[0] && col == foot[1])) {
			copyMap[row][col] = map[row - drow[dir]][col - dcol[dir]];
			if (!isValid(map, row + drow[dir], col + dcol[dir])) {
				dir = (dir + 3) % 4;
			}
			row += drow[dir];
			col += dcol[dir];
		}

		// 3. 순환 부분을 제외한 다른 부분 추가
		for (int i = 0; i < R; i++) {
			if (i == 0 || i == R - 1 || i == head[0] || i == foot[0])
				continue;
			for (int j = 0; j < C; j++) {
				if (j == 0 || j == C - 1)
					continue;
				copyMap[i][j] = map[i][j];
			}
		}
		
		copyMap[head[0]][head[1]] = -1;
		copyMap[foot[0]][foot[1]] = -1;
		return copyMap;
	}

	private static int[][] spreadDust(int[][] map) {
		int R = map.length;
		int C = map[0].length;
		int[][] copyMap = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0)
					continue;
				else if (map[i][j] == -1) {
					copyMap[i][j] = -1;
					continue;
				}

				// 주변 지점엔 spread 만큼 더하기
				// 현재 지점엔 map[i][j] - spread * count 만큼 더하기
				int spread = map[i][j] / 5;
				int count = 0;
				for (int dir = 0; dir < 4; dir++) {
					int nRow = i + drow[dir];
					int nCol = j + dcol[dir];
					if (!isValid(map, nRow, nCol) || map[nRow][nCol] == -1)
						continue;

					count++;
					copyMap[nRow][nCol] += spread;
				}
				copyMap[i][j] += map[i][j] - spread * count;
			}
		}

		return copyMap;
	}

	private static boolean isValid(int[][] map, int row, int col) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}
}