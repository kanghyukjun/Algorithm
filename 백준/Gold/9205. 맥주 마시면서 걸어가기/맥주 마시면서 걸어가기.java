import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {

			// get input
			int convNum = Integer.parseInt(br.readLine());
			int[][] location = new int[convNum + 2][2];
			for (int i = 0; i < location.length; i++) {
				st = new StringTokenizer(br.readLine());
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}

			// process
			// 두 좌표사이 거리는 x 좌표 차이 + y 좌표 차이 (맨해튼 거리)
			// 1병 마심 -> 50m 갈 수 있다
			// 20병 마심 -> 1000m 갈 수 있다
			// 완탐
			int[][] adjMatrix = new int[convNum + 2][convNum + 2];
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = i; j < adjMatrix.length; j++) {
					adjMatrix[i][j] = distance(location[i], location[j]);
					adjMatrix[j][i] = adjMatrix[i][j];
				}
			}

			// floyd-marshall 변형
			for (int node = 0; node < adjMatrix.length; node++) {
				for (int row = 0; row < adjMatrix.length; row++) {
					if (node == row)
						continue;
					
					// 맥주를 마시는 시간 동안 갈 수 있는 거리이면
					// 거리를 업데이트 한다
					if (adjMatrix[row][node] <= 1000) {
						for (int col = 0; col < adjMatrix.length; col++) {
							adjMatrix[row][col] = Math.min(adjMatrix[row][col], adjMatrix[node][col]);
						}
					}
				}
			}
			
			// output
			sb.append(adjMatrix[0][location.length - 1] <= 1000 ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}

	private static int distance(int[] arr1, int[] arr2) {
		return Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] - arr2[1]);
	}

}