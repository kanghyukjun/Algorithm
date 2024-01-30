import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] switches;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// get input
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			if (st.nextToken().equals("1")) {
				switches[i] = true;
			} else {
				switches[i] = false;
			}
		}

		int students = Integer.parseInt(br.readLine());
		for (int i = 0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			String gender = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (gender.equals("1")) {
				// 남자
				male(num);
			} else {
				// 여자
				female(num);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(switches[i]) {
				sb.append(1).append(' ');
			}else {
				sb.append(0).append(' ');
			}
			if(i % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

	// 하한 : 1, 상한 : N
	private static void female(int num) {
		int leftIdx = num - 1;
		int rightIdx = num + 1;
		switches[num] = !switches[num];

		while (leftIdx >= 1 && rightIdx <= N && switches[leftIdx] == switches[rightIdx]) {
			switches[leftIdx] = !switches[leftIdx];
			switches[rightIdx] = !switches[rightIdx];
			leftIdx -= 1;
			rightIdx += 1;
		}
	}

	private static void male(int num) {
		for (int i = 1; i * num <= N; i++) {
			switches[i * num] = !switches[i * num];
		}
	}

}