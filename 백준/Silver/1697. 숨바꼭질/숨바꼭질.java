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
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		// process
		int[] map = new int[100_001];
		Arrays.fill(map, 100_001);
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { from, 0 });
		map[from] = 0;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			if (map[current[0]] < current[1])
				continue;

			if (current[0] + 1 <= 100_000 && map[current[0] + 1] > current[1] + 1) {
				map[current[0] + 1] = current[1] + 1;
				que.add(new int[] { current[0] + 1, current[1] + 1 });
			}

			if (current[0] - 1 >= 0 && map[current[0] - 1] > current[1] + 1) {
				map[current[0] - 1] = current[1] + 1;
				que.add(new int[] { current[0] - 1, current[1] + 1 });
			}

			if (current[0] * 2 <= 100_000 && map[current[0] * 2] > current[1] + 1) {
				map[current[0] * 2] = current[1] + 1;
				que.add(new int[] { current[0] * 2, current[1] + 1 });
			}
		}
		
		// process
		System.out.println(map[to]);
	}

}