import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int TC = 1; TC <= 10; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			int N = Integer.parseInt(br.readLine());

			boolean valid = true;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String value = st.nextToken();
				if ((st.countTokens() == 2 && value.charAt(0) - '0' >= 0 && value.charAt(0) - '0' <= 9)
						|| (!st.hasMoreTokens() && (value.charAt(0) - '0' < 0 || value.charAt(0) - '0' > 9))) {
					valid = false;
				}
			}
			if (valid) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

}