import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// process
		int output = divide(2 << (N - 1), r, c);

		// output
		System.out.println(output);
	}

	private static int divide(int N, int r, int c) {
		int count = r / (N / 2) * 2 + c / (N / 2);

		if (N == 2) {
			return count;
		} else {
			return ((N / 2) * (N / 2)) * count
					+ divide(N / 2, r - (N / 2) * (r / (N / 2)), c - (N / 2) * (c / (N / 2)));
		}
	}

}