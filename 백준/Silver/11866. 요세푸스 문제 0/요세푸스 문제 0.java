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
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// process
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		sb.append('<');
		while(que.size() > 1) {
			for (int i = 0; i < M - 1; i++) {
				que.add(que.poll());
			}
			sb.append(que.poll()).append(", ");
		}
		
		sb.append(que.poll()).append('>');
		
		// output
		System.out.println(sb);
	}

}