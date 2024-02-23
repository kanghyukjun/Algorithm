import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	static int[] size;
	static List<Edge> adjList;
	static int[] save;
	static Pair[] coord;

	static class Pair {
		int row, col;

		public Pair() {
		}

		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public double getPowDistance(Pair c) {
			return Math.pow(c.row - this.row, 2) + Math.pow(c.col - this.col, 2);
		}

	}

	static class Edge {
		int from;
		int to;
		double cost;

		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		int r1 = find(x);
		int r2 = find(y);

		if (size[r1] > size[r2]) {
			parent[r2] = r1;
			size[r1] += size[r2];
		} else {
			parent[r1] = r2;
			size[r2] += size[r1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
//		for (int TC = 1; TC <= 1; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			int N = Integer.parseInt(br.readLine());
			parent = new int[N];
			size = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				size[i] = 1;
			}
			adjList = new ArrayList<>();
			save = new int[2];

			coord = new Pair[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coord[i] = new Pair();
				coord[i].row = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coord[i].col = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());

			// process
			makeSet(0, 0);
			Collections.sort(adjList, Comparator.comparingDouble(o -> o.cost));

			double costSum = 0;
			int edgeCount = 0;
			for (Edge edge : adjList) {
				if (edgeCount == N - 1) {
					break;
				}

				int p1 = find(edge.from);
				int p2 = find(edge.to);
				if (p1 == p2) {
					continue;
				}
				edgeCount++;
				costSum += edge.cost;
				union(p1, p2);
			}

			// output
			sb.append(Math.round(costSum * E)).append('\n');
		}
		System.out.println(sb);
	}

	private static void makeSet(int depth, int nextIdx) {
		if (depth == 2) {
			adjList.add(new Edge(save[0], save[1], coord[save[0]].getPowDistance(coord[save[1]])));
			return;
		}

		for (int i = nextIdx; i < coord.length; i++) {
			save[depth] = i;
			makeSet(depth + 1, i + 1);
		}
	}

}