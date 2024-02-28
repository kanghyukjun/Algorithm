import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] drow = { 1, -1, 0, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1, 0 };

	static int preCoreConnected;
	static int maxCoreConnected;
	static int leastConnectedLength;
	static boolean printLength;

	static int N;
	static List<Core> cores;
	static int[][] map;

	static class Core {
		int row;
		int col;
		List<Integer> dir;

		public Core(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			dir = new ArrayList<>();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			preCoreConnected = 0;
			maxCoreConnected = Integer.MIN_VALUE;
			leastConnectedLength = Integer.MAX_VALUE;
			printLength = false;

			N = Integer.parseInt(br.readLine().trim());
			cores = new ArrayList<>();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							preCoreConnected++;
						} else {
							cores.add(new Core(i, j));
						}
					}
				}
			}

			// process
			// 각 core마다 진행할 수 있는 위치 저장
			preProcessing();

			// 각 core가 진행하는 방향 선택
			int[] directions = new int[cores.size()];
			makeDirectionSets(0, directions);

			// output
			if (printLength) {
				sb.append(leastConnectedLength);
			} else {
				sb.append(maxCoreConnected + preCoreConnected);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void makeDirectionSets(int depth, int[] directions) {
		// 모든 core들의 방향들이 정해지면 어떤 순서로 전선을 연결할 지 결정
		if (depth == cores.size()) {
			// 모든 코어들의 방향과 연결 순서가 정해짐
			int coreNum = 0;
			int length = 0;
			boolean flag = false;
			int stop = 0;

			for (int i = 0; i < cores.size(); i++) {
				stop = i;
				if (cores.size() - i + coreNum < maxCoreConnected) {
					flag = true;
					break;
				}

				Core core = cores.get(i);
				int row = core.row;
				int col = core.col;
				int dir = directions[i];
				if (dir == 4) {
					continue;
				}

				while (true) {
					row += drow[dir];
					col += dcol[dir];
					if (row < 0 || row >= N || col < 0 || col >= N) {
						break;
					}

					if (map[row][col] == 1 || map[row][col] == -1) {
						// 완성할 수 없는 조합
						flag = true;
						break;
					}
					map[row][col] = -1;
					length++;
				}
				coreNum++;
			}

			for (int idx = 0; idx < stop + 1; idx++) {
				int dir = directions[idx];
				if (dir == 4) {
					continue;
				}

				int nextRow = cores.get(idx).row;
				int nextCol = cores.get(idx).col;
				while (true) {
					nextRow += drow[dir];
					nextCol += dcol[dir];
					if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
						break;
					}
					if (map[nextRow][nextCol] == -1) {
						map[nextRow][nextCol] = 0;
					}
				}
			}

			if (flag) {
				return;
			}

			if (coreNum == maxCoreConnected) {
				leastConnectedLength = Math.min(leastConnectedLength, length);
				printLength = true;
			} else if (coreNum > maxCoreConnected) {
				maxCoreConnected = coreNum;
				leastConnectedLength = length;
				printLength = false;
			}

		}

		else {
			for (int dir : cores.get(depth).dir) {
				directions[depth] = dir;
				makeDirectionSets(depth + 1, directions);
			}
		}
	}

	private static void preProcessing() {
		for (int i = cores.size() - 1; i >= 0; i--) {
			Core current = cores.get(i);
			for (int dir = 0; dir < 5; dir++) {
				if (dir == 4) {
					current.dir.add(dir);
					continue;
				}
				int nextRow = current.row + drow[dir];
				int nextCol = current.col + dcol[dir];

				boolean isDirValid = true;

				while (true) {
					nextRow += drow[dir];
					nextCol += dcol[dir];
					if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
						break;
					}
					if (map[nextRow][nextCol] == 1) {
						isDirValid = false;
						break;
					}
				}
				if (isDirValid) {
					current.dir.add(dir);
				}
			}
		}
	}

}