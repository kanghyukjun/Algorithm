import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
			pq.add(Integer.parseInt(br.readLine()));
		}

		// process
		int output = 0;
		while (pq.size() != 1) {
			int min1 = pq.poll();
			int min2 = pq.poll();
			int sum = min1 + min2;
			output += sum;
			pq.add(sum);
		}
		
		// output
		System.out.println(output);
	}

}