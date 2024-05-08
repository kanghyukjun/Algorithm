import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 100 * 100 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] adjMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j)
					adjMatrix[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjMatrix[n1][n2] = 1;
			adjMatrix[n2][n1] = 1;
		}

		// process
		for (int node = 1; node <= N; node++) {
			for (int row = 1; row <= N; row++) {
				if (node == row)
					continue;

				for (int col = 1; col <= N; col++) {
					adjMatrix[row][col] = Math.min(adjMatrix[row][col], adjMatrix[row][node] + adjMatrix[node][col]);
				}
			}
		}
		
		// output
		int person = -1;
		int minSum = INF * 100;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += adjMatrix[i][j];
				if(sum > minSum)
					break;
			}
			if(sum < minSum) {
				minSum = sum;
				person = i;
			}
		}
		System.out.println(person);
	}

}