import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int MOD = 1234567891;
	static long[] getFactorial = new long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		getFactorial[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			getFactorial[i] = ((getFactorial[i-1] % MOD) * (i % MOD)) % MOD;
		}

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			// process
			// 1. 분모와 분자를 계속 계산하며 나머지 연산을 이용해서 값을 구한다
			// 2. 원래 수에 mod 연산을 한 값은
			// 3. 각각의 분모와 분자에 나머지 연산을 하며 구한 값에 A(분자)와 B(분모)에
			// 4. (A x B^(M-2)) % M의 나머지 값과 동일하다
			long A = getFactorial[N];
			long B = (getFactorial[R] % MOD) * (getFactorial[N - R] % MOD) % MOD;
			sb.append(((A % MOD) * getPower(B, MOD - 2)) % MOD).append('\n');
		}
		System.out.println(sb);
	}

	public static long getPower(long lower, int upper) {
		if (upper == 0) {
			return 1;
		} else if (upper == 1) {
			return lower % MOD;
		} else if (upper % 2 == 0) {
			long output = getPower(lower, upper / 2) % MOD;
			return (output * output) % MOD;
		} else {
			long output = getPower(lower, upper / 2) % MOD;
			return (((output * output) % MOD) * lower % MOD) % MOD;
		}
	}

}