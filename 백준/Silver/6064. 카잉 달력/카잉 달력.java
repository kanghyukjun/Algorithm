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
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// process
			boolean flag = false;
			for (int count = x; count <= M * N; count += M) {
				if (((count - 1) % N) + 1 == y) {
					sb.append(count).append('\n');
					flag = true;
					break;
				}
			}

			if (!flag)
				sb.append(-1).append('\n');
		}

		System.out.println(sb);

	}

}