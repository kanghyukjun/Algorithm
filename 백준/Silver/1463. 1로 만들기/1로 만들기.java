import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		dp = new int[N + 1];
		int output = solve(N);

		// output
		System.out.println(output);
	}

	private static int solve(int n) {
		if(n == 1) {
			return 0;
		}
		else if (n < 4) {
			return 1;
		}
		else if (dp[n] != 0) {
			return dp[n];
		}

		int min = Integer.MAX_VALUE;

		if (n % 3 == 0) {
			min = Math.min(min, solve(n / 3));
		}

		if (n % 2 == 0) {
			min = Math.min(min, solve(n / 2));
		}

		min = Math.min(min, solve(n - 1));

		return dp[n] = min + 1;
	}
}