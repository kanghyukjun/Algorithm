import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				if(pq.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(pq.poll()).append('\n');
			} else {
				pq.add(n);
			}
		}
		
		System.out.println(sb);
	}
	
}