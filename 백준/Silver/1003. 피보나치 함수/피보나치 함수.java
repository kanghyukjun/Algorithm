import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		dp = new long[41][2];
		dp[0][0] = 1;
		dp[1][1] = 1;

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			// process
			int n = Integer.parseInt(br.readLine());
			long[] out = fibonacci(n);
			sb.append(out[0]).append(' ').append(out[1]).append('\n');
		}

		// output
		System.out.println(sb);
	}

	private static long[] fibonacci(int n) {
		if (n == 0) {
			return dp[0];
		} else if (n == 1) {
			return dp[1];
		} else if (dp[n][0] != 0 || dp[n][1] != 0) {
			return dp[n];
		} else {
			long[] m1 = fibonacci(n - 1);
			long[] m2 = fibonacci(n - 2);
			dp[n][0] = m1[0] + m2[0];
			dp[n][1] = m1[1] + m2[1];
			
			return dp[n];
		}
	}

}