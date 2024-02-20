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

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new List[N + 1];
		int[] in = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()), second = Integer.parseInt(st.nextToken());
			adjList[first].add(second);
			in[second]++;
		}
		
		// process
		List<Integer> start = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(in[i] == 0) {
				start.add(i);
			}
		}
		
		// BFS
		Queue<Integer> que = new ArrayDeque<>();
		que.addAll(start);
		while(!que.isEmpty()) {
			int current = que.poll();
			sb.append(current).append(' ');
			for (Integer adjIdx : adjList[current]) {
				in[adjIdx]--;
				if(in[adjIdx] == 0) {
					que.add(adjIdx);
				}
			}
		}
		
		// output
		System.out.println(sb);
	}
}