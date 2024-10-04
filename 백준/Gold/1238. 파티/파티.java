import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Road {
		int dest;
		int cost;

		public Road(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}

	}

	final static int INF = 10_000_001;
	static int N;
	static List<Road>[] neighbors;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		neighbors = new List[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (neighbors[start] == null)
				neighbors[start] = new ArrayList<>();
			neighbors[start].add(new Road(dest, cost));
		}

		// process
		// 1번부터 N번까지의 학생이 X에 도착하고, X로부터 갈 수 있는 가장 짧은 거리를 구한다.
		// 그 거리중, 가장 긴 거리를 출력한다.
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, getShort(i, X) + getShort(X, i));
		}

		System.out.println(max);
	}

	public static int getShort(int start, int dest) {
		int[] isChecked = new int[N + 1];
		Arrays.fill(isChecked, INF);
		isChecked[start] = 0;

		PriorityQueue<Road> pq = new PriorityQueue<Road>((r1, r2) -> r1.cost - r2.cost);
		pq.add(new Road(start, 0));

		while (!pq.isEmpty()) {
			Road current = pq.poll();
			
			if (isChecked[current.dest] < current.cost)
				continue;
			
			for (Road road : neighbors[current.dest]) {
				if (isChecked[road.dest] > current.cost + road.cost) {
					isChecked[road.dest] = current.cost + road.cost;
					pq.add(new Road(road.dest, current.cost + road.cost));
				}
			}
		}

		return isChecked[dest];
	}

}