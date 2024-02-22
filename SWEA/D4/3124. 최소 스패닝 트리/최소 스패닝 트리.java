import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	static int[] size;

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static boolean makeUnion(int x, int y) {
		int r1 = find(x);
		int r2 = find(y);
		if (r1 == r2) {
			return false;
		}

		if (size[r1] > size[r2]) {
			parent[r2] = r1;
			size[r1] += size[r2];
		} else {
			parent[r1] = r2;
			size[r2] += size[r1];
		}
		return true;
	}

	static class Edge {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());

			parent = new int[V + 1];
			size = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
				size[i] = 1;
			}

			int E = Integer.parseInt(st.nextToken());
			List<Edge> edgeList = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(n1, n2, cost));
			}

			// process
			// Kruskal
			Collections.sort(edgeList, Comparator.comparingInt(o -> o.cost));
			int edgeCount = 0;
			long costSum = 0;
			for (Edge edge : edgeList) {
				if (edgeCount == V - 1) {
					break;
				}

				int n1 = edge.from;
				int n2 = edge.to;
				if (!makeUnion(n1, n2)) {
					continue;
				}
				costSum += edge.cost;
				edgeCount++;
			}

			// output
			sb.append(costSum).append('\n');
		}

		System.out.println(sb);
	}

}