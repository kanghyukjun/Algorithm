import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int WEIGHT = 0;
	final static int VALUE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		int[][] stuff = new int[N + 1][2];
		int[][] dp = new int[N + 1][maxWeight + 1];

		// process
		for (int curStuff = 1; curStuff <= N; curStuff++) {
			st = new StringTokenizer(br.readLine());
			stuff[curStuff][WEIGHT] = Integer.parseInt(st.nextToken());
			stuff[curStuff][VALUE] = Integer.parseInt(st.nextToken());

			for (int curWeight = 1; curWeight <= maxWeight; curWeight++) {
				if (curWeight < stuff[curStuff][WEIGHT]) {
					dp[curStuff][curWeight] = dp[curStuff - 1][curWeight];
				} else {
					dp[curStuff][curWeight] = Math.max(dp[curStuff - 1][curWeight],
							dp[curStuff - 1][curWeight - stuff[curStuff][WEIGHT]] + stuff[curStuff][VALUE]);
				}
			}
		}
		
		// output
		System.out.println(dp[N][maxWeight]);
	}

}