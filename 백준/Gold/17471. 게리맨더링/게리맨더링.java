import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] populations;
	static List<Integer>[] adjList;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		populations = new int[N + 1];
		adjList = new List[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				int adjNode = Integer.parseInt(st.nextToken());
				adjList[i].add(adjNode);
//				adjList[adjNode].add(i);
			}
		}

		// process
		boolean[] check = new boolean[N + 1];
		makeSet(N, 0, 1, check);

		// output
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void makeSet(int N, int depth, int nextIdx, boolean[] check) {
		if (depth == N) {
			boolean[] notChecked1 = new boolean[N + 1];
			boolean[] notChecked2 = new boolean[N + 1];
			int startIdx1 = -1;
			int startIdx2 = -1;
			for (int i = 1; i <= N; i++) {
				if (check[i]) {
					notChecked1[i] = true;
					startIdx1 = i;
				} else {
					notChecked2[i] = true;
					startIdx2 = i;
				}
			}
//			System.out.println(Arrays.toString(notChecked1));
//			System.out.println(Arrays.toString(notChecked2));

			if (startIdx1 == -1 || startIdx2 == -1) {
				return;
			}

			// 첫 번째 구역 순회
			int populations1 = populations[startIdx1];
			Queue<Integer> que = new ArrayDeque<>();
			que.add(startIdx1);
			notChecked1[startIdx1] = false;
			while (!que.isEmpty()) {
				int current = que.poll();
				for (Integer adjNode : adjList[current]) {
					if (notChecked1[adjNode]) {
						notChecked1[adjNode] = false;
						populations1 += populations[adjNode];
						que.add(adjNode);
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				if (notChecked1[i]) {
					return;
				}
			}

			// 두 번째 구역 순회
			int populations2 = populations[startIdx2];
			que.clear();
			que.add(startIdx2);
			notChecked2[startIdx2] = false;
			while (!que.isEmpty()) {
				int current = que.poll();
				for (Integer adjNode : adjList[current]) {
					if (notChecked2[adjNode]) {
						notChecked2[adjNode] = false;
						populations2 += populations[adjNode];
						que.add(adjNode);
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				if (notChecked2[i]) {
					return;
				}
			}

			min = Math.min(min, Math.abs(populations1 - populations2));
			return;
		}

		for (int i = nextIdx; i <= N; i++) {
			check[depth + 1] = true;
			makeSet(N, depth + 1, i + 1, check);
			check[depth + 1] = false;
			makeSet(N, depth + 1, i + 1, check);
		}
	}

}