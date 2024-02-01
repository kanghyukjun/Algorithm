import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String input;
	static int pwLength;

	static int[] leastDna = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		pwLength = Integer.parseInt(st.nextToken());
		input = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			leastDna[i] = Integer.parseInt(st.nextToken());
		}

		// process
		int count = 0;
		int[] dnaSum = new int[4];
		for (int i = 0; i < pwLength; i++) {
			dnaSum[getIdx(input.charAt(i))]++;
		}
		if (check(dnaSum)) {
			count++;
		}

		for (int i = 0; i < input.length() - pwLength; i++) {
			dnaSum[getIdx(input.charAt(i))]--;
			dnaSum[getIdx(input.charAt(i + pwLength))]++;
			if(check(dnaSum)) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	public static int getIdx(char c) {
		if (c == 'A') {
			return 0;
		} else if (c == 'C') {
			return 1;
		} else if (c == 'G') {
			return 2;
		}
		return 3;
	}

	public static boolean check(int[] dnaSum) {
		return leastDna[0] <= dnaSum[0] && leastDna[1] <= dnaSum[1] && leastDna[2] <= dnaSum[2]
				&& leastDna[3] <= dnaSum[3];
	}
}