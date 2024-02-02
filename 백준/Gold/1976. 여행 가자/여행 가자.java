import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] size;

	private static int find(int value) {
		if (value == parent[value]) {
			return value;
		}
		return parent[value] = find(parent[value]);
	}

	private static void union(int value1, int value2) {
		int p1 = find(value1);
		int p2 = find(value2);
		
		if (size[p1] >= size[p2]) {
			parent[p2] = p1;
			size[p1]++;
		} else {
			parent[p1] = p2;
			size[p2]++;
		}
		
	}

	private static boolean isUnion(int value1, int value2) {
		int p1 = find(value1);
		int p2 = find(value2);
		if (p1 == p2) {
			return true;
		}
		return false;
	}

	// 연결되어있지 않은 도시 찾기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		size = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int in = Integer.parseInt(st.nextToken());
				if (in == 1 && !isUnion(i, j)) {
					union(i, j);
				}
			}
		}

		// process
		st = new StringTokenizer(br.readLine());
		Set<Integer> nodes = new HashSet<>();
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < M; i++) {
			int in = Integer.parseInt(st.nextToken());
			if (nodes.add(in)) {
				stk.push(in);
			}
		}

//		System.out.println(Arrays.toString(parent));
		boolean check = true;
		int city1 = -1;
		int city2 = -1;
		if (!stk.isEmpty()) {
			city1 = stk.pop();
		}
		while (!stk.isEmpty()) {
			city2 = stk.pop();
			if (!isUnion(city1, city2)) {
				check = false;
				break;
			}
			city1 = city2;
		}

		if (check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}