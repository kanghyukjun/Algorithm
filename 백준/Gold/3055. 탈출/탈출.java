import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	static int R;
	static int C;
	static final int INF = 50 * 50 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] start = new int[] { -1, -1 };
		char[][] map = new char[R][C];
		Queue<int[]> water = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S')
					start = new int[] { i, j };
				else if (map[i][j] == '*')
					water.add(new int[] { i, j });
			}
		}

		// process
		int min = goseumdochi(start, water, map);

		// output
		System.out.println(min == INF ? "KAKTUS" : min);
	}

	private static int goseumdochi(int[] start, Queue<int[]> waters, char[][] map) {
		// 물이 차는건 동일
		// 고슴도치가 움직이는 것만 달라짐
		// 물이 먼저 차고 고슴도치가 이동

		// 물과 고슴도치는 돌을 통과할 수 없다
		// 고슴도치는 물로 차있는 구역으로 이동할 수 없다
		// 물도 비버의 소굴로 이동할 수 없다
		Queue<int[]> goseum = new ArrayDeque<>();
		boolean[][] check = new boolean[R][C];
		goseum.add(start);
		check[start[0]][start[1]] = true;
		for (int time = 1; time <= R * C; time++) {
			// 물이 먼저 찬다
			int waterSize = waters.size();
			for (int i = 0; i < waterSize; i++) {
				int[] water = waters.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nRow = water[0] + drow[dir];
					int nCol = water[1] + dcol[dir];

					// 범위 체크
					if (nRow < 0 || nRow >= R || nCol < 0 || nCol >= C)
						continue;
					// 현재 범위가 돌이거나 물일 경우
					if (map[nRow][nCol] == '*' || map[nRow][nCol] == 'X' || map[nRow][nCol] == 'D')
						continue;

					map[nRow][nCol] = '*';
					waters.add(new int[] { nRow, nCol });
				}

			}

//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					if(map[i][j] != '*')
//						continue;
//					
//					// 범위 체크
//					if (i < 0 || i >= R || j < 0 || j >= C)
//						continue;
//					// 현재 범위가 돌이거나 물일 경우
//					if (map[i][j] == '*' || map[i][j] == 'X' || map[i][j] == 'D')
//						continue;
//
//					map[i][j] = '*';
//				}
//			}
//
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}

			// 고슴도치의 크기만큼 빼고 이동한다
			int size = goseum.size();
			while (size-- > 0) {
				int[] coord = goseum.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nRow = coord[0] + drow[dir];
					int nCol = coord[1] + dcol[dir];

					// 범위 체크
					if (nRow < 0 || nRow >= R || nCol < 0 || nCol >= C)
						continue;
					// 현재 범위가 돌이거나 물일 경우
					if (map[nRow][nCol] == '*' || map[nRow][nCol] == 'X' || check[nRow][nCol])
						continue;

					// 현재 구역이 굴이라면 탈출
					if (map[nRow][nCol] == 'D') {
						return time;
					}
					// 그렇지 않다면 위치를 돌로 바꿔준다 (check 대신)
					else {
						check[nRow][nCol] = true;
						goseum.add(new int[] { nRow, nCol });
					}
				}
			}
		}

		return INF;
	}

}