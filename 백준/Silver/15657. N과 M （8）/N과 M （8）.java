import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] output;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = new int[M];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// process
		Arrays.sort(arr);
		solve(0, 0);
		
		// output
		System.out.println(sb);
	}

	private static void solve(int depth, int next) {
		if (depth == M) {
			for (int i : output) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		} else {
			for (int i = next; i < arr.length; i++) {
				output[depth] = arr[i];
				solve(depth + 1, i);
			}
		}
	}

}