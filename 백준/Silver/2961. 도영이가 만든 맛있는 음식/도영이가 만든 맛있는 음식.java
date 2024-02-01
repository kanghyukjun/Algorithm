import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int SOUR = 0;
	final static int BITTER = 1;

	static int[][] arr;
	static int currentSour = 1;
	static int currentBitter = 0;

	static int min = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][SOUR] = Integer.parseInt(st.nextToken());
			arr[i][BITTER] = Integer.parseInt(st.nextToken());
		}

		// process
		for (int i = 1; i <= N; i++) {
			solve(i, 0, 0);
		}
		
		// output
		System.out.println(min);
	}

	private static void solve(int end, int depth, int startIdx) {
		if (end == depth) {
			min = Math.min(min, Math.abs(currentSour - currentBitter));
			return;
		}

		for (int i = startIdx; i < arr.length; i++) {
			currentSour *= arr[i][SOUR];
			currentBitter += arr[i][BITTER];
			solve(end, depth + 1, i + 1);
			currentSour /= arr[i][SOUR];
			currentBitter -= arr[i][BITTER];
		}
	}

}