import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] size;

	public static int getParent(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = getParent(parent[x]);
	}

	public static boolean isUnion(int x, int y) {
		return getParent(x) == getParent(y);
	}

	public static void union(int x, int y) {
		int xP = getParent(x);
		int yP = getParent(y);

		if (size[yP] > size[xP]) {
			parent[xP] = yP;
			size[yP]++;
		} else {
			parent[yP] = xP;
			size[xP]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		size = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		// process
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if (!isUnion(n1, n2)) {
				union(n1, n2);
			}
		}

		// output
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (i == getParent(i))
				count++;
		}
		System.out.println(count);
	}

}