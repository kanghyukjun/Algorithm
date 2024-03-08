import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		// process
		Queue<long[]> que = new ArrayDeque<>();
		que.add(new long[] { A, 0 });
		long output = -2;
		while (!que.isEmpty()) {
			long[] current = que.poll();

			long one = current[0] * 10 + 1;
			long two = current[0] * 2;

			if (one <= B) {
				if (one == B) {
					output = current[1] + 1;
					break;
				} else {
					que.add(new long[] { one, current[1] + 1 });
				}
			}

			if (two <= B) {
				if (two == B) {
					output = current[1] + 1;
					break;
				} else {
					que.add(new long[] { two, current[1] + 1 });
				}
			}
			
		}
		// output
		System.out.println(output + 1);
	}

}