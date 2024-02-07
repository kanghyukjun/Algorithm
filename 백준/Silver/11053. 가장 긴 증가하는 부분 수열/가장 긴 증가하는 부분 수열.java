import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// process
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int output = 1;
		for (int i = N - 1; i >= 0; i--) {
			int max = 0;
			for (int j = i + 1; j < N; j++) {
				if (arr[i] < arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			if(max >= 1) {
				dp[i] = max + 1;
			}
			output = Math.max(dp[i], output);
		}

		// output
		System.out.println(output);
	}

}