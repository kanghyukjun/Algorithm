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
		StringBuilder sb = new StringBuilder();

		// get inout
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] adjList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}

		// process
		int[] isChecked = new int[N + 1];
		Queue<Integer> que = new ArrayDeque<>();
		que.add(1);
		isChecked[1] = -1;
		while (!que.isEmpty()) {
			int current = que.poll();
			for (Integer adjNode : adjList[current]) {
				if(isChecked[adjNode] == 0) {
					isChecked[adjNode] = current;
					que.add(adjNode);
				}
			}
		}
		
		// output
		for (int i = 2; i <= N; i++) {
			sb.append(isChecked[i]).append('\n');
		}
		System.out.println(sb);
	}

}