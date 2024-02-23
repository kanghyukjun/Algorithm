import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 회전초밥집에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 (무료로 제공받을 수 있는 초밥)

		int[] chobap = new int[N + k]; // 회전초밥집에 놓인 접시
		for (int i = 1; i <= N; i++) {
			chobap[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N + 1; i < chobap.length; i++) {
			chobap[i] = chobap[i - N];
		}
//		System.out.println(Arrays.toString(chobap));

		// process
		// init (1 ~ k-1까지 합)
		int[] cnt = new int[d + 1];
		int sum = 0;
		for (int i = 1; i < k; i++) {
			if (cnt[chobap[i]] == 0) {
				sum++;
			}
			cnt[chobap[i]]++;
		}

		// slide window
		int max = 0;
		for (int i = k; i < chobap.length; i++) {
			// i 위치 추가
			if (cnt[chobap[i]] == 0) {
				sum++;
			}
			cnt[chobap[i]]++;

			// i - k위치 감소
			if (cnt[chobap[i - k]] == 1) {
				sum--;
			}
			cnt[chobap[i - k]]--;

			if (cnt[c] == 0) {
				max = Math.max(max, sum + 1);
			} else {
				max = Math.max(max, sum);
			}
		}
		
		// output
		System.out.println(max);
	}

}