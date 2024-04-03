import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			List<Integer>[] adjList = new List[N + 1];
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}

			// process
//			특정 노드 n이 주어졌을 때
//			n을 제외한 다른 모든 노드에 대해서
//
//			다른 노드에서 출발해서 n에 도달하거나
//			n에서 출발해서 다른 노드에 도달하는 경우에서 어떤 방법으로든
//			모든 노드에 접근할 수 있다면 그 노드는 자신의 키를 알 수 있다
//
//			모든 점에서 BFS로 노드 방문 후 방문할 수 있었던 노드를 기록
//			n에 대해서 순번을 알 수 있는지 확인하려면
//			1. 현재 n에 대해서 갈 수 있었던 노드를 모두 기록한다
//			2. 다른 모든 노드에 대해서 n에 갈 수 있는지 기록한다
//			3. 모두 방문할 수 있다면 true
			Set<Integer>[] reachable = makeReachableSet(adjList);
			Set<Integer>[] result = new Set[N + 1];
			for (int i = 1; i <= N; i++) {
				result[i] = new HashSet<>();
				result[i].addAll(reachable[i]);
			}
			
			int count = 0;
			for (int node = 1; node <= N; node++) {
				// 다른 노드 방문해보기
				for (int others = 1; others <= N; others++) {
					if (others == node)
						continue;
					if(reachable[others].contains(node)) {
						result[node].add(others);
					}
				}
				
				if(result[node].size() == N) {
					count++;
				}
			}
			
			// output
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	private static Set<Integer>[] makeReachableSet(List<Integer>[] adjList) {
		Set<Integer>[] set = new Set[adjList.length];
		for (int i = 1; i < set.length; i++) {
			set[i] = new HashSet<>();
		}

		// bfs
		for (int start = 1; start < set.length; start++) {
			Queue<Integer> que = new ArrayDeque<>();
			que.add(start);
			while (!que.isEmpty()) {
				int current = que.poll();
				if (set[start].contains(current))
					continue;
				set[start].add(current);
				for (Integer next : adjList[current]) {
					que.add(next);
				}
			}
		}

		return set;
	}

}