import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = Integer.MIN_VALUE;
			int back = 0;
			for (int i = 1; i <= length; i++) {
				int left = 0;
				int right = i; // 본인의 위치가 i일 때 최장길이가 i보다 클 수 없으므로
				int find = -1;

				// 이분탐색
				// L이상, R이하인 범위를 찾는다
				// 0 1 3 5 7
				// mid값은 1 3 5 7에서 6이 들어갈 범위를 찾는다
				// 찾은 값이 6보다 큰 값 중 가장 작아야 함
				// 이전 값은 6보다 작은 값중 가장 커야함
				while (left <= right) {
					int mid = (left + right) / 2;

					if (dp[mid] < arr[i]) {
						left = mid + 1;
					} else if (dp[mid] >= arr[i]) {
						find = mid;
						right = mid - 1;
					}
				}
				if (find == -1) {
					dp[++back] = arr[i];
				}
				else {
					dp[find] = arr[i];
				}

			}

			// output
			for(int i=length; i>=1; i--) {
				if(dp[i] != Integer.MAX_VALUE) {
					sb.append(i).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}

}