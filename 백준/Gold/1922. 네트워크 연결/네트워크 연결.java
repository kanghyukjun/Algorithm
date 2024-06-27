import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] size;

	static int getParent(int n) {
		if(n == parent[n]) return n;
		return parent[n] = getParent(parent[n]);
	}

	static boolean isUnion(int n1, int n2) {
		int p1 = getParent(n1);
		int p2 = getParent(n2);
		return p1 == p2;
	}

	static void union(int n1, int n2) {
		int p1 = getParent(n1);
		int p2 = getParent(n2);

		if (size[p1] > size[p2]) {
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}

	static class Edge {
		int n1;
		int n2;
		int cost;

		public Edge(int n1, int n2, int cost) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		size = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		int M = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a, b, c));
		}

		// process
		int cost = 0;
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int p1 = getParent(current.n1);
			int p2 = getParent(current.n2);
			if (isUnion(p1, p2))
				continue;

			union(p1, p2);
			cost += current.cost;
		}
		
		// output
		System.out.println(cost);
	}

}