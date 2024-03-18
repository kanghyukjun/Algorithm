import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		// get input
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				pq.add(num);
			}
			
			else {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}
				else {
					sb.append(pq.poll()).append('\n');
				}
			}
		}
		
		// output
		System.out.println(sb);
	}
	
}