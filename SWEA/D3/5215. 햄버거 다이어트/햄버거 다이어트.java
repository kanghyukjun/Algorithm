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
			st = new StringTokenizer(br.readLine());
			int numFood = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
			int[][] foods = new int[numFood + 1][2];
			for (int i = 1; i <= numFood; i++) {
				st = new StringTokenizer(br.readLine());
				foods[i][0] = Integer.parseInt(st.nextToken());
				foods[i][1] = Integer.parseInt(st.nextToken());
			}

			// process
			int[][] dp = new int[numFood + 1][weight + 1];
			for (int currentFood = 1; currentFood <= numFood; currentFood++) {
				for (int currentWeight = 1; currentWeight <= weight; currentWeight++) {
					if (currentWeight < foods[currentFood][1]) {
						dp[currentFood][currentWeight] = dp[currentFood - 1][currentWeight];
					} else {
						dp[currentFood][currentWeight] = Math.max(dp[currentFood - 1][currentWeight],
								dp[currentFood - 1][currentWeight - foods[currentFood][1]] + foods[currentFood][0]);
					}
				}
			}
			sb.append(dp[numFood][weight]).append('\n');
		}
		System.out.println(sb);
	}

}