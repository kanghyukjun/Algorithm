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

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new List[N + 1];
		int[][] party = new int[M][];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		int truthNum = Integer.parseInt(st.nextToken());
		List<Integer> knowTruth = new ArrayList<>();
		for (int i = 0; i < truthNum; i++) {
			knowTruth.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new int[Integer.parseInt(st.nextToken())];
			party[i][0] = Integer.parseInt(st.nextToken());
			for (int j = 1; j < party[i].length; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
				adjList[party[i][j - 1]].add(party[i][j]);
				adjList[party[i][j]].add(party[i][j - 1]);
			}
		}

		// process
		boolean[] isChecked = new boolean[N + 1];
		Queue<Integer> que;
		for (Integer start : knowTruth) {
			que = new ArrayDeque<>();
			que.add(start);
			isChecked[start] = true;
			while (!que.isEmpty()) {
				int cur = que.poll();
				for (Integer adj : adjList[cur]) {
					if (!isChecked[adj]) {
						isChecked[adj] = true;
						que.add(adj);
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < party.length; i++) {
			boolean check = true;
			for (int j = 0; j < party[i].length; j++) {
				if(isChecked[party[i][j]]) {
					check = false;
					break;
				}
			}
			if(check)
				count++;
		}
		System.out.println(count);
	}

}