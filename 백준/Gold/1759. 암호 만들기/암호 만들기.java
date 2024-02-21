import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int vowelCount = 0; // 모음
	static int consonantCount = 0; // 자음
	static char[] password;
	static int n;
	static char[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		password = new char[length];
		n = Integer.parseInt(st.nextToken());
		arr = new char[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		// process
		Arrays.sort(arr);
		solve(0, 0);
		
		// output
		System.out.println(sb);
	}

	private static void solve(int depth, int nextIdx) {
		if (depth == password.length) {
			if (vowelCount >= 1 && consonantCount >= 2) {
				for (char c : password) {
					sb.append(c);
				}
				sb.append('\n');
			}

			return;
		}

		for (int i = nextIdx; i < n; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				vowelCount++;
				password[depth] = arr[i];
				solve(depth + 1, i + 1);
				vowelCount--;
			} else {
				consonantCount++;
				password[depth] = arr[i];
				solve(depth + 1, i + 1);
				consonantCount--;
			}
		}
	}

}