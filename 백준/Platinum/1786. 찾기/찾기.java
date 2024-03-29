import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();

		// process
		int[] pi = getPi(pattern);
		List<Integer> find = new ArrayList<>();

		int patternIdx = 0;
		for (int textIdx = 0; textIdx < text.length; textIdx++) {
			// 이전 부분까지 일치하는 부분을 다시 매치시켜서 비교한다
			// patternIdx가 0이 되면 탈출, 패턴의 처음부터 다시 비교
			while (patternIdx > 0 && text[textIdx] != pattern[patternIdx]) {
				patternIdx = pi[patternIdx - 1];
			}

			// 일치하는 값을 찾았다면 patternIdx를 하나 증가
			// 다음 for문에서 text와 다시 비교
			if (text[textIdx] == pattern[patternIdx]) {
				patternIdx++;
				
				// 만족하는 문자열을 찾았다면
				if (patternIdx == pattern.length) {
					find.add(textIdx - pattern.length + 1 + 1); // 1번 인덱스부터 시작해서
					patternIdx = pi[patternIdx - 1];
				}
			}
		}
		
		// output
		sb.append(find.size()).append('\n');
		find.forEach(x -> sb.append(x).append(' '));
		System.out.println(sb);
	}

	private static int[] getPi(char[] pattern) {
		int length = pattern.length;
		int[] pi = new int[length];

		int pre = 0;
		for (int sub = 1; sub < length; sub++) {
			// pre가 0보다 같거나 작거나, pattern[sub] == pattern[pre]일 경우 멈춰야 한다
			// 작은 kmp 느낌
			// 만약 문자가 다르다면 이전까지 저장된 최대 pi값을 이용해 패턴을 이동시킨다
			while (pre > 0 && pattern[sub] != pattern[pre]) {
				pre = pi[pre - 1];
			}

			if (pattern[sub] == pattern[pre]) {
				pi[sub] = ++pre;
			}

		}
		return pi;
	}

}