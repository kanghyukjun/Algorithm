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
		int[][] cost = new int[N][3];
		int[][] costSum = new int[N][3];
		
		st = new StringTokenizer(br.readLine());
		cost[0][0] = Integer.parseInt(st.nextToken());
		cost[0][1] = Integer.parseInt(st.nextToken());
		cost[0][2] = Integer.parseInt(st.nextToken());
		
		costSum[0] = Arrays.copyOf(cost[0], 3);
		
		// process
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
			
			costSum[i][0] = cost[i][0] + Math.min(costSum[i - 1][1], costSum[i - 1][2]);
			costSum[i][1] = cost[i][1] + Math.min(costSum[i - 1][0], costSum[i - 1][2]);
			costSum[i][2] = cost[i][2] + Math.min(costSum[i - 1][0], costSum[i - 1][1]);
		}

		// output
		System.out.println(Math.min(costSum[N - 1][0], Math.min(costSum[N - 1][1], costSum[N - 1][2])));
	}

}