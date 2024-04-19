import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		StringTokenizer st = new StringTokenizer(br.readLine(), "+|-", true);
		
		// process
		Deque<Integer> que = new ArrayDeque<>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			if ("+".equals(token)) {
				int n1 = que.pollLast();
				int n2 = Integer.parseInt(st.nextToken());
				que.addLast(n1 + n2);
			} else if (!"-".equals(token)) {
				que.addLast(Integer.parseInt(token));
			}
		}

		while (que.size() > 1) {
			int n1 = que.pollFirst();
			int n2 = que.pollFirst();
			que.addFirst(n1 - n2);
		}
		
		// output
		System.out.println(que.poll());
	}

}