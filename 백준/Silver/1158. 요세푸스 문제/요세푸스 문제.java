import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append('<');

		// get input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

		// process
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		int count = 0;
		while (!deque.isEmpty()) {
			count = count % K + 1;
			int tmp = deque.pollFirst();
			if(count == K) {
				sb.append(tmp).append(", ");
			} else {
				deque.addLast(tmp);
			}
		}

		sb.delete(sb.length() - 2, sb.length()).append('>');
		System.out.println(sb);
	}

}