import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		final int MEM = 0;
		final int COST = 1;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][2];

		int memSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i][MEM] = Integer.parseInt(st.nextToken());
			memSum += arr[i][MEM];
		}
		
		int costSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i][COST] = Integer.parseInt(st.nextToken());
			costSum += arr[i][COST];
		}

		// process
		// M 메모리를 확보해야 함
		// 현재 사용중인 메모리들의 합을 memSum이라고 할 때
		// memSum - M까지의 knapsack

//		int[][] dp = new int[N + 1][memSum - M + 1];
		int[] dp = new int[memSum - M + 1];
		for (int appCount = 1; appCount <= N; appCount++) {
			for (int curMem = memSum - M; curMem >= 1; curMem--) {
				if(curMem < arr[appCount][MEM]) {
//					dp[appCount][curMem] = dp[appCount-1][curMem];
					continue;
				}
				else {
//					dp[appCount][curMem] = Math.max(dp[appCount-1][curMem], dp[appCount-1][curMem - arr[appCount][MEM]] + arr[appCount][COST]);
					dp[curMem] = Math.max(dp[curMem], dp[curMem - arr[appCount][MEM]] + arr[appCount][COST]);
				}
			}
		}
		
		// output
		System.out.println(costSum - dp[memSum - M]);
	}

}