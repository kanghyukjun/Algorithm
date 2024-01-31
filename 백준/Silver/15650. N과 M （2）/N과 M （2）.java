import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		// process
		solve(1, 0);
		
		// output
		System.out.println(sb);
	}

	private static void solve(int idx, int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = idx; i <= N; i++) {
			arr[depth] = i;
			solve(i + 1, depth + 1);
		}
	}
}