import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static List<Integer> arr;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		// get input
		Set<Integer> dup = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		result = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(!dup.contains(n)) {
				arr.add(n);
				dup.add(n);
			}
		}

		// process
		Collections.sort(arr);
		solve(0, 0);

		// output
		System.out.println(sb);
	}

	private static void solve(int depth, int nextIdx) {
		if (depth == M) {
			for (int i : result) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		}

		else {
			for (int i = nextIdx; i < arr.size(); i++) {
				result[depth] = arr.get(i);
				solve(depth + 1, i);
			}
		}
	}

}