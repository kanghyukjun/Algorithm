import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp = new int[50001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int min = 50000;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, 1 + dp[i - j * j]);
			}
			dp[i] = min;
		}

		// output
		System.out.println(dp[N]);
	}

}