import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= 10; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int startIdx = Integer.parseInt(st.nextToken());
			List<Integer>[] adjList = new List[101];
			for (int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}

			// process
			int output = solve(startIdx, adjList);

			// output
			sb.append(output).append('\n');
		}

		System.out.println(sb);
	}

	private static int solve(int startIdx, List<Integer>[] adjList) {
		// maxIdxNum의 인덱스는 count의 길이
		// count의 길이가 같다면 가장 번호가 큰 노드의 값을 저장
		int[] maxIdxNum = new int[100];
		int[] count = new int[101];
		count[startIdx] = 0;
		maxIdxNum[0] = startIdx;
		int lastCount = 0;

		Queue<Integer> que = new ArrayDeque<>();
		que.add(startIdx);
		while (!que.isEmpty()) {
			int current = que.poll();
			for (Integer adjNode : adjList[current]) {
				if (adjNode != startIdx && count[adjNode] == 0) {
					count[adjNode] = count[current] + 1;
					lastCount = Math.max(lastCount, count[adjNode]);
					if (maxIdxNum[count[adjNode]] < adjNode) {
						maxIdxNum[count[adjNode]] = adjNode;
					}
					que.add(adjNode);
				}
			}
		}

		return maxIdxNum[lastCount];
	}

}