import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int N;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// get input
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = br.readLine();
			}

			// process
			int output = solve();

			sb.append('#').append(tc).append(' ').append(output).append('\n');
		}
		System.out.println(sb);
	}

	private static int solve() {
		int sum = 0;

		for (int i = 0; i <= N / 2; i++) {
			for (int j = (N / 2) - i; j <= (N / 2) + i; j++) {
				sum += Character.getNumericValue(arr[i].charAt(j));
			}
		}

		for (int i = 1; i <= N / 2; i++) {
			for (int j = i; j < N - i; j++) {
				sum += Character.getNumericValue(arr[(N / 2) + i].charAt(j));
			}
		}

		return sum;
	}
}