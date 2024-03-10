import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		final int INF = 200_000_000;

		// get input
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Edge>[] adjList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[start].add(new Edge(start, end, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// process
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Edge(start, start, 0));
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			if (distance[current.start] < current.cost) {
				continue;
			}

			for (Edge nextNode : adjList[current.start]) {
				if (current.cost + nextNode.cost < distance[nextNode.end]) {
					distance[nextNode.end] = current.cost + nextNode.cost;
					pq.add(new Edge(nextNode.end, -1, distance[nextNode.end]));
				}
			}
		}
		
		// output
		System.out.println(distance[end]);
	}
}