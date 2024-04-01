import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int ROW;
	static int COL;
	static int[][] map;
	static final int INF = 999;

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	static List<List<int[]>> unions = new ArrayList<>();
	static int[] parent;
	static int[] size;

	static class Edge implements Comparable<Edge> {
		int node1;
		int node2;
		int cost;

		public Edge(int node1, int node2, int cost) {
			super();
			this.node1 = node1;
			this.node2 = node2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Edge [node1=" + node1 + ", node2=" + node2 + ", cost=" + cost + "]";
		}

	}

	static int getParent(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = getParent(parent[x]);
	}

	static boolean isUnion(int x, int y) {
		int xP = getParent(x);
		int yP = getParent(y);
		if (xP == yP)
			return true;
		return false;
	}

	static void union(int x, int y) {
		int xP = getParent(x);
		int yP = getParent(y);

		if (size[xP] < size[yP]) {
			parent[xP] = yP;
		} else {
			parent[yP] = xP;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		map = new int[ROW][COL];

		for (int i = 0; i < ROW; i++) {
			Arrays.fill(map[i], -2);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < COL; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					map[i][j] = -1;
			}
		}

		// process
		// divide area
		int areaSum = 1;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] == -1) {
					List<int[]> union = new ArrayList<>();
					union.add(new int[] { i, j });
					bfs(map, i, j, areaSum, union);

					unions.add(union);
					areaSum++;
				}
			}
		}

		// generate edge
		// Kruskal
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				if (map[i][j] == -2)
//					System.out.print("  ");
//				else
//					System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		PriorityQueue<Edge> pq = getEdgeList(unions);
		parent = new int[unions.size()];
		size = new int[unions.size()];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int sum = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
//			System.out.println(edge);
			int n1 = edge.node1;
			int n2 = edge.node2;
			if (!isUnion(n1, n2)) {
				union(n1, n2);
				sum += edge.cost;
			}
		}

		// output
		boolean flag = true;
		for (int i = 0; i < parent.length; i++) {
			if (!isUnion(0, i)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag ? sum : -1);
	}

	private static PriorityQueue<Edge> getEdgeList(List<List<int[]>> unions) {
		int[][] adjMatrix = new int[unions.size()][unions.size()];
		for (int i = 0; i < adjMatrix.length; i++) {
			Arrays.fill(adjMatrix[i], INF);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (List<int[]> island : unions) {
			for (int[] coord : island) {
				int startIsland = map[coord[0]][coord[1]];
				for (int dir = 0; dir < 4; dir++) {
					int row = coord[0] + drow[dir];
					int col = coord[1] + dcol[dir];
					int count = 0;
					// 범위를 벗어나거나 값을 찾았다면 종료해야 함
					while (check(map, row, col) && !(map[row][col] != -2)) {
						if (map[row][col] == startIsland) {
							count = -1;
							break;
						}
						row += drow[dir];
						col += dcol[dir];
						count++;
					}
					// 다른 섬을 찾은 경우
					if (check(map, row, col) && count > 1) {
						adjMatrix[startIsland][map[row][col]] = Math.min(adjMatrix[startIsland][map[row][col]], count);
					}
				}
			}
		}

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j] != INF && adjMatrix[i][j] != 1) {
					pq.add(new Edge(i, j, adjMatrix[i][j]));
				}
			}
		}
		return pq;
	}

	private static void bfs(int[][] map, int row, int col, int sum, List<int[]> union) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { row, col });
		map[row][col] += sum;

		while (!que.isEmpty()) {
			int[] coord = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nRow = coord[0] + drow[dir];
				int nCol = coord[1] + dcol[dir];
				if (!check(map, nRow, nCol))
					continue;

				if (map[nRow][nCol] == -1) {
					map[nRow][nCol] += sum;
					que.add(new int[] { nRow, nCol });
					union.add(new int[] { nRow, nCol });
				}
			}
		}
	}

	private static boolean check(int[][] map, int row, int col) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}