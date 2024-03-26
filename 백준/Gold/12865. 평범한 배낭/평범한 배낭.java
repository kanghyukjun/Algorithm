import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		final int W = 0;
		final int V = 1;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] stuff = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][W] = Integer.parseInt(st.nextToken());
			stuff[i][V] = Integer.parseInt(st.nextToken());
		}

		// process
		int[][] dp = new int[N + 1][K + 1];
		for (int stuffNum = 1; stuffNum <= N; stuffNum++) {
			for (int weight = 1; weight <= K; weight++) {
				if (stuff[stuffNum][W] > weight)
					dp[stuffNum][weight] = dp[stuffNum - 1][weight];
				else {
					dp[stuffNum][weight] = Math.max(dp[stuffNum - 1][weight],
							dp[stuffNum - 1][weight - stuff[stuffNum][W]] + stuff[stuffNum][V]);
				}
			}
		}

		// output
		System.out.println(dp[N][K]);
	}

}