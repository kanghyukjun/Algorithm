import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] money;
	static int[] parent;

	public static int find(int n1) {
		if (n1 == parent[n1]) {
			return n1;
		}
		return parent[n1] = find(parent[n1]);
	}

	public static boolean union(int n1, int n2) {
		int r1 = find(n1);
		int r2 = find(n2);
		if (r1 == r2) {
			return false;
		}

		if (money[r1] < money[r2]) {
			parent[r2] = r1;
		} else {
			parent[r1] = r2;
		}
		return true;
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		money = new int[N + 1];
		parent = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}

		// process
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			union(n1, n2);
		}
		
		int minSum = 0;
		for (int i = 1; i <= N; i++) {
			if (i == parent[i]) {
				minSum += money[i];
			}
		}

		if (minSum <= k) {
			System.out.println(minSum);
		} else {
			System.out.println("Oh no");
		}
	}

}