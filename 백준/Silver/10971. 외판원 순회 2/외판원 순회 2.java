import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int min;
	static boolean[] isChecked;
	static int[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		adjMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		for (int start = 1; start <= N; start++) {
			isChecked = new boolean[N + 1];
			isChecked[start] = true;
			solve(0, 0, start, start);
		}
		
		// output
		System.out.println(min);

	}

	private static void solve(int depth, int sum, int currentIdx, int home) {
		if (depth == N - 2) {
			int nextIdx = -1;
			for (int i = 1; i <= N; i++) {
				if(!isChecked[i]) {
					nextIdx = i;
					break;
				}
			}
			if(adjMatrix[currentIdx][nextIdx] == 0 || adjMatrix[nextIdx][home] == 0) {
				return;
			}
			
			min = Math.min(min, sum + adjMatrix[currentIdx][nextIdx] + adjMatrix[nextIdx][home]);
		}

		else {
			for (int i = 1; i <= N; i++) {
				if(adjMatrix[currentIdx][i] == 0) {
					continue;
				}
				if (!isChecked[i]) {
					isChecked[i] = true;
					solve(depth + 1, sum + adjMatrix[currentIdx][i], i, home);
					isChecked[i] = false;
				}
			}
		}

	}

}