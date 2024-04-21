import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[21];

		// process
		for (int TC = 0; TC < N; TC++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = -1;
			if (st.hasMoreTokens())
				num = Integer.parseInt(st.nextToken());

			if ("add".equals(order)) {
				arr[num] = true;
			} else if ("remove".equals(order)) {
				arr[num] = false;
			} else if ("check".equals(order)) {
				sb.append(arr[num] ? 1 : 0).append('\n');
			} else if ("toggle".equals(order)) {
				arr[num] = arr[num] ? false : true;
			} else if ("all".equals(order)) {
				arr = getAll(21);
			} else if ("empty".equals(order)) {
				arr = new boolean[21];
			}
		}
		
		// output
		System.out.println(sb);
	}

	static boolean[] getAll(int size) {
		boolean[] all = new boolean[size];
		for (int i = 0; i < all.length; i++) {
			all[i] = true;
		}
		return all;
	}

}