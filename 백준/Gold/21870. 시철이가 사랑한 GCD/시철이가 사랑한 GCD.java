import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		// 매물 번호와 GCD를 이용해 자취방의 아름다움을 예측한다
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// process
		solve(arr, 0, arr.length - 1, 0);

		// output
		System.out.println(max);
	}

	private static void solve(int[] arr, int startIdx, int endIdx, int gcdSum) {
		if (startIdx == endIdx) {
			max = Math.max(max, gcdSum + arr[startIdx]);
			return;
		}

		else {
			int mid = (endIdx + startIdx + 1) / 2;
//			System.out.println("start: " + startIdx + ", mid: " + mid + ", end: " + endIdx);

			// left
			solve(arr, mid, endIdx, gcdSum + getGCD(arr, startIdx, mid - 1));

			// right
			solve(arr, startIdx, mid - 1, gcdSum + getGCD(arr, mid, endIdx));

		}

	}

	private static int getGCD(int[] arr, int startIdx, int endIdx) {
		int minNum = arr[startIdx];
		for (int i = startIdx; i <= endIdx; i++) {
			minNum = Math.min(minNum, arr[i]);
		}

		int gcdFirst = arr[startIdx];
		for (int i = startIdx + 1; i <= endIdx; i++) {
			gcdFirst = gcd(gcdFirst, arr[i]);
		}

		return gcdFirst;
	}

	private static int gcd(int a, int b) {
		int c;
		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

}