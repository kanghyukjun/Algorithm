import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int max;
	static int N;
	static int limit;
	static int[] snacks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			max = -1;
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}

			// process
			set(0, 0, 0);
			
			// output
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}

	private static void set(int depth, int startIdx, int sum) {
		if (depth == 2) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = startIdx; i < N; i++) {
			if (sum + snacks[i] <= limit) {
				set(depth + 1, i + 1, sum + snacks[i]);
			}
		}
	}

}