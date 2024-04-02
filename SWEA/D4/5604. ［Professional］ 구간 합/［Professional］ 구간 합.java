import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static Map<Long, Long> f = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// init
		long sum = 0;
		for (long i = 0; i < 10; i++) {
			sum += i;
			f.put(i, sum);
		}

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			long from = Long.parseLong(st.nextToken());
			long to = Long.parseLong(st.nextToken());

			// process
			sb.append(F(to) - F(from - 1)).append('\n');
		}

		// output
		System.out.println(sb);
	}

	public static long F(long n) {
		if (n < 0) {
			return 0;
		} else if (f.containsKey(n)) {
			return f.get(n);
		}
		long g = G(n);
		int length = Long.toString(n).length();
		long pow = (long) Math.pow(10, length - 1);
		long val = F(n - g) + (n / pow) * g + F(n % pow);
		f.put(n, val);
		return val;
	}

	private static long G(long n) {
		int length = Long.toString(n).length();
		return n % (long) Math.pow(10, length - 1) + 1;
	}

}

// 0~999까지의 합은
// (0+1+2+3+4+5+6+7+8+9) * N + S * 10
// N : 0~99까지의 갯수 = 100
// S : 0~99까지의 합 = 900

// F(120) = F(99) + 1 * 21 + F(20)
// G(n) = 21
// F(220) = F(199) + 2 * 21 + F(20)
// G(n) = n % Math.pow(10, 3) + 1