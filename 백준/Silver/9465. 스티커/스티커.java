import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {

			// get input
			int N = Integer.parseInt(br.readLine());
			int[][] value = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					value[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			// 0 : 스티커를 떼지 않았을 때
			// 1 : 스티커를 뗐을 때
			int[][][] dp = new int[2][N][2];
			dp[0][0][1] = value[0][0];
			dp[1][0][1] = value[1][0];

			for (int col = 1; col < N; col++) {
				dp[0][col][0] = Math.max(Math.max(dp[0][col - 1][0], dp[0][col - 1][1]),
						Math.max(dp[1][col - 1][0], dp[1][col - 1][1]));
				dp[0][col][1] = Math.max(Math.max(dp[0][col - 1][0], dp[1][col - 1][0]), dp[1][col - 1][1])
						+ value[0][col];
				
				dp[1][col][0] = Math.max(Math.max(dp[0][col - 1][0], dp[0][col - 1][1]),
						Math.max(dp[1][col - 1][0], dp[1][col - 1][1]));
				dp[1][col][1] = Math.max(Math.max(dp[1][col - 1][0], dp[0][col - 1][0]), dp[0][col - 1][1])
						+ value[1][col];
			}
			
			// output
			sb.append(Math.max(Math.max(dp[0][N-1][0], dp[0][N-1][1]), Math.max(dp[1][N-1][0], dp[1][N-1][1]))).append('\n');
		}
		System.out.println(sb);
	}

}