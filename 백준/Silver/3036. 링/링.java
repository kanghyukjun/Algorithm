import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int gcd = getGCD(first, arr[i]);
			sb.append(first / gcd).append('/').append(arr[i] / gcd).append('\n');
		}

		System.out.println(sb);
	}

	public static int getGCD(int a, int b) {
		while (a % b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return b;
	}

}