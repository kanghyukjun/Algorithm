import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			// get input
			int dumpCount = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			// process
			Collections.sort(list);
			for (int i = 0; i < dumpCount; i++) {
				if (solve(list)) {
					break;
				}
			}

			sb.append('#').append(tc).append(' ').append(list.get(list.size() - 1) - list.get(0)).append('\n');
		}
		System.out.println(sb);
	}

	private static boolean solve(List<Integer> list) {
		int min = list.get(0);
		int max = list.get(list.size() - 1);

		if (max - min <= 1) {
			return true;
		}

		min++;
		max--;

		list.remove(0);
		list.remove(list.size() - 1);

		int idx = 0;
		while (list.get(idx) < min) {
			idx++;
		}
		list.add(idx, min);

		idx = list.size() - 1;
		while (list.get(idx) > max) {
			idx--;
		}
		list.add(idx + 1, max);
		
		return false;
	}

}