import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		String tmp1 = br.readLine();
		String tmp2 = br.readLine();
		int N = tmp1.length();
		int M = tmp2.length();

		char[] s1 = new char[N + 1];
		for (int i = 1; i <= N; i++) {
			s1[i] = tmp1.charAt(i - 1);
		}
		char[] s2 = new char[M + 1];
		for (int i = 1; i <= M; i++) {
			s2[i] = tmp2.charAt(i - 1);
		}

		// process
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (s1[i] == s2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// output
		System.out.println(dp[N][M]);
	}

}