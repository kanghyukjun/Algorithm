import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		size = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		

		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			int u1 = Integer.parseInt(st.nextToken());
			int u2 = Integer.parseInt(st.nextToken());

			if (oper.equals("0")) {
				// 합집합 만들기
				union(u1, u2);
			} else {
				// union 판단
				if(find(u1) == find(u2)) {
					sb.append("yes").append('\n');
				} else {
					sb.append("no").append('\n');
				}
			}
		}
		System.out.println(sb);
	}
	
	private static int find(int n) {
		if(n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	private static boolean union(int n1, int n2) {
		int r1 = find(n1);
		int r2 = find(n2);
		if(r1 == r2) {
			return false;
		}
		
		if(size[r1] >= size[r2]) {
			parent[r2] = r1;
		} else {
			parent[r1] = r2;
		}
		return true;
	}
}