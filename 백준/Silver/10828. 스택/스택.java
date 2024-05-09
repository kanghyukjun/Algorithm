import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// get input
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stk = new ArrayDeque<>(N + 1);

		// process
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if ("push".equals(order)) {
				stk.addLast(Integer.parseInt(st.nextToken()));
			} else if ("pop".equals(order)) {
				if(stk.isEmpty())
					sb.append(-1);
				else
					sb.append(stk.pollLast());
				sb.append('\n');
			} else if ("size".equals(order)) {
				sb.append(stk.size()).append('\n');
			} else if ("empty".equals(order)) {
				if(stk.isEmpty())
					sb.append(1);
				else
					sb.append(0);
				sb.append('\n');
			} else if ("top".equals(order)) {
				if(stk.isEmpty())
					sb.append(-1);
				else
					sb.append(stk.peekLast());
				sb.append('\n');
			}
		}
		
		// output
		System.out.println(sb);
	}

}