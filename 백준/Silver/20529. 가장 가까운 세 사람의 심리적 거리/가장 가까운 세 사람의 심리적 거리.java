import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int min;
	static String[] arr;
	static String[] save;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// 사람이 17명이라면 같은 MBTI를 가지는 사람이 적어도 두명 있다
		// 사람이 33명이라면 같은 MBTI를 가지는 사람이 적어도 세명 있다
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			arr = new String[N];
			if (N > 32) {
				br.readLine();
				sb.append(0).append('\n');
				continue;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			// 조합 생성해서 값 계산하기
			min = 13;
			save = new String[3];
			solve(0, 0);
			sb.append(min).append('\n');
		}
		System.out.println(sb);
	}

	private static void solve(int depth, int idx) {
		if (depth == 3) {
			// 계산
			int sum = 0;
			sum += getDiff(save[0], save[1]);
			sum += getDiff(save[1], save[2]);
			sum += getDiff(save[2], save[0]);
			min = Math.min(sum, min);
		} else {
			for (int i = idx; i < arr.length; i++) {
				save[depth] = arr[i];
				solve(depth + 1, i + 1);
			}
		}
	}

	private static int getDiff(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
		}
		return count;
	}

}