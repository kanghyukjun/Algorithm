import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			int length = Integer.parseInt(br.readLine());
			int[] arr = new int[length + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// process
			// 본인을 포함하는 최장 길이가 idx인 가장 작은 수
			arr[0] = Integer.MIN_VALUE;
			int[] dp = new int[length + 1];
			dp[0] = 0;
			int max = 0;
			for (int i = 1; i <= length; i++) {
				for (int j = i; j >= 0; j--) {
					if (arr[j] < arr[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				max = Math.max(max, dp[i]);
			}

			// output
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}

}