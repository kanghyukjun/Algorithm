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
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N + 1][N + 1];
			int M = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			int max = 0;
			int prevSum = 0;
			for (int i = 1; i < M; i++) {
				for (int j = 1; j < M; j++) {
					prevSum += arr[i][j];
				}
			}

			for (int i = 1; i <= N - M + 1; i++) {
				// 이전 행에서의 sum 값을 이용해 이번 행 계산
				int currentSum = prevSum;
				for (int j = 1; j < M; j++) {
					currentSum -= arr[i - 1][j];
					currentSum += arr[i + M - 1][j];
				}

				int slideSum = currentSum;
				for (int j = 1; j <= N - M + 1; j++) {
					for (int k = 0; k < M; k++) {
						slideSum -= arr[i + k][j - 1];
						slideSum += arr[i + k][j + M - 1];
					}
					max = Math.max(max, slideSum);
				}
				// 다음 행에 넘기기 위한 값 저장
				prevSum = currentSum;
			}
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}

}