import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		adjList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}

		// process
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}

		// DFS
		visited = new boolean[N + 1];
		visited[start] = true;
		sb.append(start).append(' ');
		dfs(start);
		
		// BFS
		sb.append('\n');
		visited = new boolean[N + 1];
		visited[start] = true;
		sb.append(start).append(' ');
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		while(!que.isEmpty()) {
			int current = que.poll();
			for (Integer adjNode : adjList[current]) {
				if(!visited[adjNode]) {
					sb.append(adjNode).append(' ');
					visited[adjNode] = true;
					que.add(adjNode);
				}
			}
		}
		
		// output
		System.out.println(sb);
	}

	private static void dfs(int start) {
		for (Integer adjNode : adjList[start]) {
			if(!visited[adjNode]) {
				sb.append(adjNode).append(' ');
				visited[adjNode] = true;
				dfs(adjNode);
			}
		}
	}

}