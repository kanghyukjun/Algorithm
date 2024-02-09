import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int[][] arr;
	private static boolean[] isSelected;
	private static int absMin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// process
			// 중복이 아닌 조합
			absMin = Integer.MAX_VALUE;
			makeCombination(0, 0);
			
			// output
			sb.append(absMin).append('\n');
		}
		
		System.out.println(sb);
	}

	public static void makeCombination(int depth, int idx) {
		if (depth == N / 2) {
			int sum1 = 0;
			int sum2 = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(isSelected[i] && isSelected[j]) {
						sum1 += arr[i][j];
					}
					else if(!isSelected[i] && !isSelected[j]) {
						sum2 += arr[i][j];
					}
				}
			}
			
			absMin = Math.min(absMin, Math.abs(sum1 - sum2));
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				makeCombination(depth + 1, i + 1);
				isSelected[i] = false;
			}
		}
	}
}