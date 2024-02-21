import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;
	static boolean[] isChecked;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o1 = Integer.parseInt(st.nextToken());
			int o2 = Integer.parseInt(st.nextToken());
			adjList[o1].add(o2);
			adjList[o2].add(o1);
		}

		// process
		for (int i = 0; i < N; i++) {
			isChecked = new boolean[N];
			isChecked[i] = true;
			dfs(i, 0);
			if (flag) {
				break;
			}
		}

		// output
		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void dfs(int startIdx, int depth) {
		if (depth == 4) {
			flag = true;
			return;
		}

		for (Integer adjIdx : adjList[startIdx]) {
			if (!isChecked[adjIdx]) {
				isChecked[adjIdx] = true;
				dfs(adjIdx, depth + 1);
				isChecked[adjIdx] = false;
			}
		}

	}

}