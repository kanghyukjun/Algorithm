import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] home = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] away = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	static int[][] answer;
	static int[][] current;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int TestCase = 1; TestCase <= 4; TestCase++) {
			st = new StringTokenizer(br.readLine());

			// input
			answer = new int[6][3];
			current = new int[6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					answer[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			flag = false;
			solve(0);

			// output
			if (flag) {
				sb.append(1).append(' ');
			} else {
				sb.append(0).append(' ');
			}
		}

		System.out.println(sb);
	}

	private static void solve(int depth) {
		if (depth == 15) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (answer[i][j] != current[i][j]) {
						return;
					}
				}
			}
			flag = true;
			return;
		}

		int h = home[depth];
		int a = away[depth];

		// home이 이기는 경우
		current[h][0] += 1;
		current[a][2] += 1;
		solve(depth + 1);
		current[h][0] -= 1;
		current[a][2] -= 1;

		// 비기는 경우
		current[h][1] += 1;
		current[a][1] += 1;
		solve(depth + 1);
		current[h][1] -= 1;
		current[a][1] -= 1;

		// home이 지는 경우
		current[h][2] += 1;
		current[a][0] += 1;
		solve(depth + 1);
		current[h][2] -= 1;
		current[a][0] -= 1;

	}

}