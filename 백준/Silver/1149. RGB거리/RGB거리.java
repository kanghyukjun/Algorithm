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
		int[][] map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		int[][] mapSum = new int[N][3];
		mapSum[0] = Arrays.copyOf(map[0], 3);

		for (int i = 1; i < N; i++) {
			mapSum[i][0] = map[i][0] + Math.min(mapSum[i - 1][1], mapSum[i - 1][2]);
			mapSum[i][1] = map[i][1] + Math.min(mapSum[i - 1][0], mapSum[i - 1][2]);
			mapSum[i][2] = map[i][2] + Math.min(mapSum[i - 1][0], mapSum[i - 1][1]);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, mapSum[N - 1][i]);
		}
		
		// output
		System.out.println(min);
	}

}