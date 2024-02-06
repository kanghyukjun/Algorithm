import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> rightPq = new PriorityQueue<>();
		leftPq.add(-10001);
		rightPq.add(10001);

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				leftPq.add(num);
			} else {
				rightPq.add(num);
			}

			if (leftPq.peek() > rightPq.peek()) {
				rightPq.add(leftPq.poll());
				leftPq.add(rightPq.poll());
			}

			sb.append(leftPq.peek()).append('\n');

		}
		System.out.println(sb);
	}

}