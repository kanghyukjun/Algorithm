import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static StringBuilder sb;
	static int currentNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// get input
		N = Integer.parseInt(br.readLine());
		
		// process
		solve(0);
		
		// output
		System.out.println(sb);
	}

	private static void solve(int depth) {
		if (depth == N) {
			sb.append(currentNum).append('\n');
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (depth == 0 && i == 0) {
				continue;
			}
			currentNum = currentNum * 10 + i;
			if (isPrime(currentNum)) {
				solve(depth + 1);
			}
			currentNum = (currentNum - i) / 10;
		}
	}

	private static boolean isPrime(double num) {
		if(num <= 1) {
			return false;
		}
		for (int i = 2; i*i <= num; i++) {
			if(num / i == Math.ceil(num / i)) {
				return false;
			}
		}
		
		return true;
	}
}