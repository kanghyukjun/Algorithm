import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');
			
			// get input
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && adjMatrix[i][j] == 0)
						adjMatrix[i][j] = INF;
				}
			}
			
			// process
			for (int node = 0; node < adjMatrix.length; node++) {
				for (int row = 0; row < adjMatrix.length; row++) {
					if(row == node || adjMatrix[row][node] == INF)
						continue;
					
					for (int col = 0; col < adjMatrix.length; col++) {
						if(adjMatrix[node][col] != INF) {
							adjMatrix[row][col] = Math.min(adjMatrix[row][col], adjMatrix[row][node] + adjMatrix[node][col]);
						}
					}
				}
			}
			
//			for (int i = 0; i < adjMatrix.length; i++) {
//				for (int j = 0; j < adjMatrix.length; j++) {
//					System.out.print(adjMatrix[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			
			// output
			int minSum = INF;
			for (int i = 0; i < adjMatrix.length; i++) {
				int sum = 0;
				for (int j = 0; j < adjMatrix.length; j++) {
					sum += adjMatrix[i][j];
					if(sum > minSum)
						break;
				}
				minSum = Math.min(minSum, sum);
			}
			sb.append(minSum).append('\n');
		}
		System.out.println(sb);
	}
	
}