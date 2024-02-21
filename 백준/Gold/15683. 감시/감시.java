import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	// 상 우 하 좌
	static int[] drow = { -1, 0, 1, 0 };
	static int[] dcol = { 0, 1, 0, -1 };

	static int row;
	static int col;
	static int[][] map;
	static List<int[]> cctvs;
	static int min = Integer.MAX_VALUE;

	// 0의 갯수를 세어라
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		cctvs = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new int[] { i, j });
				}
			}
		}

		// process
		int[] directions = new int[cctvs.size()];
		solve(0, 0, directions);

		// output
		System.out.println(min);
	}

	private static void solve(int depth, int nextIdx, int[] directions) {
		if (depth == cctvs.size()) {
			int[][] mapCopy = new int[row][col];
			for (int i = 0; i < row; i++) {
				mapCopy[i] = Arrays.copyOf(map[i], map[i].length);
			}

			for (int i = 0; i < cctvs.size(); i++) {
				int[] cctvCoord = cctvs.get(i);
				int cctvType = map[cctvCoord[0]][cctvCoord[1]];
				int direction = directions[i];
				supervise(cctvCoord, cctvType, direction, mapCopy);
			}

			int count = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (mapCopy[i][j] == 0) {
						count++;
					}
				}
			}

			min = Math.min(min, count);
			return;
		}

		for (int i = nextIdx; i < cctvs.size(); i++) {
			int[] cctvCoord = cctvs.get(i);
			int cctvType = map[cctvCoord[0]][cctvCoord[1]];
			switch (cctvType) {
			case 1:
			case 3:
			case 4:
				for (int j = 0; j < 4; j++) {
					directions[depth] = j;
					solve(depth + 1, i + 1, directions);
				}
				break;
			case 2:
				for (int j = 0; j < 2; j++) {
					directions[depth] = j;
					solve(depth + 1, i + 1, directions);
				}
				break;
			case 5:
				solve(depth + 1, i + 1, directions);
				break;
			}
		}
	}

	private static void supervise(int[] cctvCoord, int cctvType, int direction, int[][] map) {
		int currentRow = cctvCoord[0];
		int currentCol = cctvCoord[1];

		switch (cctvType) {
		case 1:
			while (true) {
				currentRow += drow[direction];
				currentCol += dcol[direction];
				if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
						|| map[currentRow][currentCol] == 6) {
					break;
				}
				if (map[currentRow][currentCol] == 0) {
					map[currentRow][currentCol] = -1;
				}
			}
			break;
		case 2:
			while (true) {
				currentRow += drow[direction];
				currentCol += dcol[direction];
				if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
						|| map[currentRow][currentCol] == 6) {
					break;
				}
				if (map[currentRow][currentCol] == 0) {
					map[currentRow][currentCol] = -1;
				}
			}
			currentRow = cctvCoord[0];
			currentCol = cctvCoord[1];
			while (true) {
				currentRow += drow[direction + 2];
				currentCol += dcol[direction + 2];
				if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
						|| map[currentRow][currentCol] == 6) {
					break;
				}
				if (map[currentRow][currentCol] == 0) {
					map[currentRow][currentCol] = -1;
				}
			}
			break;
		case 3:
			while (true) {
				currentRow += drow[direction];
				currentCol += dcol[direction];
				if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
						|| map[currentRow][currentCol] == 6) {
					break;
				}
				if (map[currentRow][currentCol] == 0) {
					map[currentRow][currentCol] = -1;
				}
			}
			currentRow = cctvCoord[0];
			currentCol = cctvCoord[1];
			while (true) {
				currentRow += drow[(direction + 1) % 4];
				currentCol += dcol[(direction + 1) % 4];
				if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
						|| map[currentRow][currentCol] == 6) {
					break;
				}
				if (map[currentRow][currentCol] == 0) {
					map[currentRow][currentCol] = -1;
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				if (i == direction) {
					continue;
				}
				currentRow = cctvCoord[0];
				currentCol = cctvCoord[1];
				while (true) {
					currentRow += drow[i];
					currentCol += dcol[i];
					if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
							|| map[currentRow][currentCol] == 6) {
						break;
					}
					if (map[currentRow][currentCol] == 0) {
						map[currentRow][currentCol] = -1;
					}
				}
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				currentRow = cctvCoord[0];
				currentCol = cctvCoord[1];
				while (true) {
					currentRow += drow[i];
					currentCol += dcol[i];
					if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col
							|| map[currentRow][currentCol] == 6) {
						break;
					}
					if (map[currentRow][currentCol] == 0) {
						map[currentRow][currentCol] = -1;
					}
				}
			}
			break;
		}
	}

}