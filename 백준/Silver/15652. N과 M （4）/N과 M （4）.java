import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// process
		arr = new int[M];
		go(0, 1);

		// output
		System.out.println(sb);
	}

	private static void go(int depth, int idx) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = idx; i <= N; i++) {
			arr[depth] = i;
			go(depth + 1, i);
		}
	}
}