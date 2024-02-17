import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int[] find = new int[2];
		st = new StringTokenizer(br.readLine());
		find[0] = Integer.parseInt(st.nextToken());
		find[1] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}

		// process
		int[] count = new int[N + 1];
		Queue<Integer> que = new ArrayDeque<>();
		que.add(find[0]);
		while (!que.isEmpty()) {
			int current = que.poll();
			for (Integer adj : list[current]) {
				if (count[adj] != 0)
					continue;
				count[adj] = count[current] + 1;
				if (adj == find[1]) {
					break;
				}
				que.add(adj);
			}
		}

		// output
		if (count[find[1]] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(count[find[1]]);
		}
	}

}