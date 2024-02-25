import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int maxScore;

	// 1번 선수는 4번째 타자가 되어야 한다
	public static void main(String[] args) throws IOException {
		maxScore = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int innings = Integer.parseInt(br.readLine());
		int[][] result = new int[innings + 1][10];
		for (int i = 1; i <= innings; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		boolean[] check = new boolean[10];
		int[] order = new int[10];
		solve(1, check, order, result);

		//
		System.out.println(maxScore);
	}

	private static void solve(int depth, boolean[] check, int[] order, int[][] result) {
		// 점수 계산 시작
		if (depth == 10) {
			int score = calculateScore(order, result);
			maxScore = Math.max(maxScore, score);
		}

		else if (depth == 4) {
			check[1] = true;
			order[depth] = 1;
			solve(depth + 1, check, order, result);
			check[1] = false;
		}

		else {
			for (int i = 2; i <= 9; i++) {
				if (!check[i]) {
					check[i] = true;
					order[depth] = i;
					solve(depth + 1, check, order, result);
					check[i] = false;
				}
			}
		}

	}

	private static int calculateScore(int[] order, int[][] result) {
		int idx = 1;
		int score = 0;
		
		for (int inning = 1; inning < result.length; inning++) {
			int[] ru = new int[4];
			int outCount = 0;
			
			while (outCount < 3) {
				// 현재 이닝에서 order[idx]에 있는 선수의 결과
				int currentPlayer = order[idx];
				int outcome = result[inning][currentPlayer];

				// 안타
				if (outcome == 1) {
					if (ru[3] != 0) {
						score++;
						ru[3] = 0;
					}
					ru[3] = ru[2];
					ru[2] = ru[1];
					ru[1] = currentPlayer;
				}

				// 2루타
				else if (outcome == 2) {
					if (ru[3] != 0) {
						score++;
						ru[3] = 0;
					}
					if (ru[2] != 0) {
						score++;
						ru[2] = 0;
					}
					ru[3] = ru[1];
					ru[2] = currentPlayer;
					ru[1] = 0;
				}

				// 3루타
				else if (outcome == 3) {
					if (ru[3] != 0) {
						score++;
						ru[3] = 0;
					}
					if (ru[2] != 0) {
						score++;
						ru[2] = 0;
					}
					if (ru[1] != 0) {
						score++;
						ru[1] = 0;
					}
					ru[3] = currentPlayer;
				}

				// 홈런
				else if (outcome == 4) {
					for (int i = 3; i >= 1; i--) {
						if (ru[i] != 0) {
							score++;
							ru[i] = 0;
						}
					}
					score++;
				}

				// 아웃
				else if (outcome == 0) {
					outCount++;
				}

				idx = (idx % 9) + 1;
			}
		}

		return score;
	}

}