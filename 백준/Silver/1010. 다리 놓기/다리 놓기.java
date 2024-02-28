import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int T = 0; T < TC; T++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N < M) {
				int tmp = M;
				M = N;
				N = tmp;
			}
			// N C M
			int[][] dp = new int[N + 1][M + 1];
			dp[0][0] = 1;
			for (int n = 1; n <= N; n++) {
				for (int c = 0; c <= M; c++) {
					if (c == 0 || n == c) {
						dp[n][c] = 1;
					} else {
						dp[n][c] = dp[n - 1][c - 1] + dp[n - 1][c];
					}
				}
			}

			sb.append(dp[N][M]).append('\n');
		}
		System.out.println(sb);
	}

}