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
			rightPq.add(num);
			if(rightPq.size() - leftPq.size() > 1) {
				leftPq.add(rightPq.poll());
			}
			leftPq.add(rightPq.poll());
			rightPq.add(leftPq.poll());
			leftPq.add(rightPq.poll());
			rightPq.add(leftPq.poll());
			
			if(rightPq.size() > leftPq.size()) {
				sb.append(rightPq.peek()).append('\n');
			} else if(rightPq.size() < leftPq.size()) {
				sb.append(leftPq.peek()).append('\n');
			} else {
				sb.append(Math.min(rightPq.peek(), leftPq.peek())).append('\n');
			}
		}
		System.out.println(sb);
	}

}