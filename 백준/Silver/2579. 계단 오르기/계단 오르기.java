import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	final static int USE = 0;
	final static int NOT_USE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[301];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// process
		int[][] dp = new int[301][2];
		dp[0][USE] = arr[0];
		dp[0][NOT_USE] = arr[0];
		dp[1][USE] = dp[0][NOT_USE] + arr[1];
		dp[1][NOT_USE] = arr[1];

		for (int i = 2; i < N; i++) {
			dp[i][USE] = dp[i - 1][NOT_USE] + arr[i];
			dp[i][NOT_USE] = Math.max(dp[i - 2][USE], dp[i - 2][NOT_USE]) + arr[i];
		}

		// output
		System.out.println(Math.max(dp[N - 1][USE], dp[N - 1][NOT_USE]));

	}

}