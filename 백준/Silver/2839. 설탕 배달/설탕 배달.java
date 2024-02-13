import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp = new int[5001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		solve(N);

		// output
		if (dp[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}

	private static int solve(int kilo) {
		if (kilo == 0) {
			return 0;
		} else if (kilo < 5) {
			if (kilo == 3) {
				return dp[kilo] = 1;
			} else {
				return dp[kilo] = Integer.MAX_VALUE;
			}
		} else if (dp[kilo] != 0) {
			return dp[kilo];
		} else {
			int three = solve(kilo - 3);
			int five = solve(kilo - 5);
			if (three != Integer.MAX_VALUE || five != Integer.MAX_VALUE) {
				dp[kilo] = Math.min(solve(kilo - 3), solve(kilo - 5)) + 1;
			} else {
				dp[kilo] = Integer.MAX_VALUE;
			}
			return dp[kilo];
		}
	}

}