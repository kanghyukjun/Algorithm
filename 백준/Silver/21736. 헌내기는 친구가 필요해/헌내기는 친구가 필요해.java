import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int[] start = new int[2];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'I') {
					start[0] = i;
					start[1] = j;
				}
			}
		}

		// process
		Queue<int[]> que = new ArrayDeque<>();
		que.add(start);
		int count = 0;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nRow = current[0] + drow[dir];
				int nCol = current[1] + dcol[dir];
				if (isValid(map, nRow, nCol) && map[nRow][nCol] != 'X') {
					if (map[nRow][nCol] == 'P')
						count++;
					map[nRow][nCol] = 'X';
					que.add(new int[] { nRow, nCol });
				}
			}
		}

		// output
		System.out.println(count == 0 ? "TT" : count);
	}

	public static boolean isValid(char[][] map, int row, int col) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}