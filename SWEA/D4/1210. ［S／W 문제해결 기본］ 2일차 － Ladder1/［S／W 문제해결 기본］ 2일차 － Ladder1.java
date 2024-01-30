import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] data;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/algorithm/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			// get input
			data = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// process
			int dest = -1;
			for (int i = 0; i < 100; i++) {
				if (data[99][i] == 2) {
					dest = i;
					break;
				}
			}
			int output = solve(dest);
			sb.append('#').append(tc).append(' ').append(output).append('\n');
		}
		System.out.println(sb);
	}

	static int[] drow = { -1, 0, 0 };
	static int[] dcol = { 0, -1, 1 };

	private static int solve(int dest) {
		int row = 99;
		int col = dest;
		int dirIdx = 0;
		boolean check = true; // 좌 우를 탐색하는지 확인
		while (row > 0) {
			if (check) {
				// 좌 우 탐색
				if (col - 1 >= 0 && data[row][col - 1] == 1) {
					dirIdx = 1;
					check = false;
				} else if (col + 1 <= 99 && data[row][col + 1] == 1) {
					dirIdx = 2;
					check = false;
				}
			} else {

				if (col + dcol[dirIdx] < 0 || col + dcol[dirIdx] > 99 || data[row][col + dcol[dirIdx]] == 0) {
					dirIdx = 0;
					check = true;
				}

			}

			row += drow[dirIdx];
			col += dcol[dirIdx];
		}

		return col;
	}
}