import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// process
		int[] map = new int[100001];
		Arrays.fill(map, Integer.MAX_VALUE);
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		map[start] = 0;
		while (!que.isEmpty()) {
			int current = que.poll();

			if (current + 1 <= 100000 && map[current + 1] > map[current] + 1) {
				map[current + 1] = map[current] + 1;
				que.add(current + 1);
			}
			
			if (current - 1 >= 0 && map[current - 1] > map[current] + 1) {
				map[current - 1] = map[current] + 1;
				que.add(current - 1);
			}
			
			if(current*2 <= 100000 && map[current*2] > map[current]) {
				map[current*2] = map[current];
				que.add(current * 2);
			}
		}
		
		// output
		System.out.println(map[end]);
	}

}