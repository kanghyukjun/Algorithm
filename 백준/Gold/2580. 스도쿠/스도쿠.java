import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {

	static int[][] map;
	static List<int[]> zeros;
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;;
        
		// get input
		map = new int[10][10];
		zeros = new ArrayList<>();

		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeros.add(new int[] { i, j });
				}
			}
		}

		// process
		// backTracking
		solve(0);
		
		// output
		System.out.println(sb);
	}

	private static void solve(int depth) {
		if (flag) {
			return;
		} else if (depth == zeros.size()) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			
			flag = true;
		} else {
			for (int num = 1; num <= 9; num++) {
				int[] current = zeros.get(depth);
				if (isValid(current, num)) {
					map[current[0]][current[1]] = num;
					solve(depth + 1);
					map[current[0]][current[1]] = 0;
				}
			}
		}
	}

	private static boolean isValid(int[] coord, int num) {
		int row = coord[0];
		int col = coord[1];

		for (int i = 1; i <= 9; i++) {
			// 가로
			if (map[row][i] == num) {
				return false;
			}
			// 세로
			if (map[i][col] == num) {
				return false;
			}
		}

		// 범위
		int startRow = (row - 1) / 3 * 3 + 1;
		int startCol = (col - 1) / 3 * 3 + 1;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

}