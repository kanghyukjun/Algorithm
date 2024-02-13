import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int[] kyu;
	static int[] in;
	static int[] inCard;
	static boolean[] inCheck;
	static int loseCount;
	static int winCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			sb.append('#').append(TC + 1).append(' ');

			// get input
			Set<Integer> kyuContains = new HashSet<>();
			kyu = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < kyu.length; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				kyuContains.add(kyu[i]);
			}

			// process
			in = new int[9];
			inCard = new int[9];
			inCheck = new boolean[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!kyuContains.contains(i)) {
					in[idx] = i;
					idx++;
				}
			}
			loseCount = 0;
			winCount = 0;
			solve(0);
			
			// output
			sb.append(winCount).append(' ').append(loseCount).append('\n');
		}
		System.out.println(sb);
	}

	private static void solve(int depth) {
		if (depth == 9) {
			int inCount = 0;
			int kyuCount = 0;
			for (int i = 0; i < 9; i++) {
				if(kyu[i] < inCard[i]) {
					inCount += kyu[i] + inCard[i];
				} else if(kyu[i] > inCard[i]) {
					kyuCount += kyu[i] + inCard[i];
				}
			}
			if(inCount < kyuCount) {
				winCount++;
			} else if(inCount > kyuCount) {
				loseCount++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if(!inCheck[i]) {
				inCheck[i] = true;
				inCard[depth] = in[i];
				solve(depth + 1);
				inCheck[i] = false;
			}
		}
	}

}