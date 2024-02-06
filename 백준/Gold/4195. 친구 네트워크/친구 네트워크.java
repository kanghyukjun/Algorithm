import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> size;
	static List<Integer> parent;
	static Map<String, Integer> map;
	static int friendCount;

	private static int find(int x) {
		if (parent.get(x) == x) {
			return x;
		}
		parent.set(x, find(parent.get(x)));
		return parent.get(x);
	}

	private static void union(int x, int y) {
		int r1 = find(x);
		int r2 = find(y);

		if (size.get(r1) >= size.get(r2)) {
			parent.set(r2, r1);
			size.set(r1, size.get(r1) + size.get(r2));
		} else {
			parent.set(r1, r2);
			size.set(r2, size.get(r2) + size.get(r1));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			// init
			size = new ArrayList<>();
			parent = new ArrayList<>();
			map = new HashMap<String, Integer>();
			friendCount = 0;

			// get input
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken(), f2 = st.nextToken();
				
				if (map.get(f1) == null) {
					map.put(f1, friendCount);
					size.add(1);
					parent.add(friendCount);
					friendCount++;
				}
				if (map.get(f2) == null) {
					map.put(f2, friendCount);
					size.add(1);
					parent.add(friendCount);
					friendCount++;
				}
				
				// 두 친구 union
				int x = find(map.get(f1));
				int y = find(map.get(f2));
				if (x != y) {
					union(x, y);
				}
				sb.append(size.get(find(x))).append('\n');
			}
		}
		System.out.println(sb);
	}

}