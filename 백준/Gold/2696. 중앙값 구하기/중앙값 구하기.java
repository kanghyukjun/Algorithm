import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(N / 2 + 1).append('\n');

			// maxHeap
			PriorityQueue<Integer> leftPq = new PriorityQueue<>(Comparator.reverseOrder());
			// minHeap
			PriorityQueue<Integer> rightPq = new PriorityQueue<>();

			leftPq.add(Integer.MIN_VALUE);
			rightPq.add(Integer.MAX_VALUE);

			for (int i = 0; i < N / 10 + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int len = st.countTokens();
				for (int j = 1; j <= len; j++) {
					int num = Integer.parseInt(st.nextToken());
					rightPq.add(num);
					
					if (rightPq.size() - leftPq.size() > 1) {
						leftPq.add(rightPq.poll());
					} else if (rightPq.peek() < leftPq.peek()) {
						leftPq.add(rightPq.poll());
						rightPq.add(leftPq.poll());
					}
					if (j % 2 == 1) {
						sb.append(rightPq.peek()).append(' ');
					}
					if (i % 2 == 1 && j == 10) {
						sb.append('\n');
					}
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}