import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] check;
	static int[] saved;
	static StringBuilder sb;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// process
		check = new boolean[N + 1];
		saved = new int[M];
		solve(0);
		
		// output
		System.out.println(sb);
	}

	private static void solve(int depth) {
		if (depth == M) {
			for (int num : saved) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!check[i]) {
				check[i] = true;
				saved[depth] = i;
				solve(depth + 1);
				check[i] = false;
			}
		}
	}

}