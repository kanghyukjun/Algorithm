import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	static int[] size;

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static boolean isUnion(int x, int y) {
		return find(x) == find(y);
	}

	static void union(int x, int y) {
		int p1 = find(x);
		int p2 = find(y);
		if (p1 == p2) {
			return;
		}

		if (size[p1] > size[p2]) {
			parent[p2] = p1;
			size[p1] += size[p2];
		} else {
			parent[p1] = p2;
			size[p2] += size[p1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			size = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				size[i] = 1;
			}

			// process
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int o1 = Integer.parseInt(st.nextToken());
				int o2 = Integer.parseInt(st.nextToken());

				if (order == 0) {
					// 합집합 형성
					union(o1, o2);
				} else if (order == 1) {
					// 같은 집합에 포함인지 확인
					// 같은 집합이면 1, 아니면 0
					if (isUnion(o1, o2)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}