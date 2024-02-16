import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 위 아래 왼쪽 오른쪽
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	static int R;
	static int C;
	static char[][] map;
	static int[] current;
	static int dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			current = new int[2];
			dir = -1;
			for (int i = 0; i < R; i++) {
				String in = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = in.charAt(j);
					if (map[i][j] == '^') {
						current[0] = i;
						current[1] = j;
						dir = 0;
					} else if (map[i][j] == 'v') {
						current[0] = i;
						current[1] = j;
						dir = 1;
					} else if (map[i][j] == '<') {
						current[0] = i;
						current[1] = j;
						dir = 2;
					} else if (map[i][j] == '>') {
						current[0] = i;
						current[1] = j;
						dir = 3;
					}
				}
			}

			// process
			int len = Integer.parseInt(br.readLine());
			String in = br.readLine();
			for (int i = 0; i < len; i++) {
				char oper = in.charAt(i);
				switch (oper) {
				case 'U':
					move('^');
					break;
				case 'D':
					move('v');
					break;
				case 'L':
					move('<');
					break;
				case 'R':
					move('>');
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			// output
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

	private static void shoot() {
		int row = current[0] + drow[dir];
		int col = current[1] + dcol[dir];

		while (row >= 0 && row < R && col >= 0 && col < C) {
			if (map[row][col] == '#') {
				return;
			} else if (map[row][col] == '*') {
				map[row][col] = '.';
				return;
			}
			row += drow[dir];
			col += dcol[dir];
		}
	}

	private static void move(char oper) {
		map[current[0]][current[1]] = oper;
		if (oper == '^') {
			dir = 0;
		} else if (oper == 'v') {
			dir = 1;
		} else if (oper == '<') {
			dir = 2;
		} else if (oper == '>') {
			dir = 3;
		}

		int nextRow = current[0] + drow[dir];
		int nextCol = current[1] + dcol[dir];
		if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] != '.')
			return;
		map[current[0]][current[1]] = '.';
		map[nextRow][nextCol] = oper;
		current[0] = nextRow;
		current[1] = nextCol;
	}

}