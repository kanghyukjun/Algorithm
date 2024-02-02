import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// get input
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
        // process
		while(queue.size() > 1) {
			queue.poll();
			int tmp = queue.poll();
			queue.add(tmp);
		}
		System.out.println(queue.poll());
	}
	
}