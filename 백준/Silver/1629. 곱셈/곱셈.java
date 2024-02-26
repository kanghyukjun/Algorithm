import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static Map<Integer, Long> value;

	public static void main(String[] args) throws IOException {
		value = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// process
		long output = solve(A, B, C);

		// output
		System.out.println(output % C);
	}

	private static long solve(int A, int B, int C) {
		if (B == 0) {
			return 1;
		}

		else if (value.containsKey(B)) {
			return value.get(B);
		}

		else {
			long num = -1;
			if (B % 2 == 0) {
				num = (solve(A, B / 2, C) * solve(A, B / 2, C)) % C;
			} else {
				num = ((solve(A, B / 2, C) * solve(A, B / 2, C)) % C * A) % C;
			}
			value.put(B, num);
			return num;
		}
	}

}