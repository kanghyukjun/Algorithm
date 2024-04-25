import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[] count = new int[N];
			int size = 0;
			Map<String, Integer> idxMap = new HashMap<>();

			// process
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String type = st.nextToken();

				if (!idxMap.containsKey(type)) {
					idxMap.put(type, size);
					count[size]++;
					size++;
				} else {
					count[idxMap.get(type)]++;
				}
			}
			int output = 1;
			for (int i = 0; i < size; i++) {
				output *= (count[i] + 1);
			}

			// output
			sb.append(output - 1).append('\n');
		}
		System.out.println(sb);
	}

}