// https://buyandpray.tistory.com/73 참고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// process
		dp = new int[N + 1];
		int back = 1;
		for (int i = 1; i <= N; i++) {
			// 이진 탐색을 이용해 새롭게 삽입을 할 위치를 찾기
			int idx = binarySearch(0, back, arr[i]);

			// 찾았으면 해당 위치를 업데이트
			if (idx != -1) {
				dp[idx] = arr[i];
			}

			// 그렇지 않다면 back에 해당 인덱스를 추가하고 back을 1 증가시키기
			else {
				dp[back] = arr[i];
				back++;
			}
		}

		// output
//		System.out.println(Arrays.toString(dp));
		System.out.println(back - 1);
	}

	private static int binarySearch(int left, int right, int find) {
		int mid = (left + right) / 2;

		if (left > right) {
			return -1;
		}

		else if (mid  + 1 < dp.length && dp[mid] < find && find <= dp[mid + 1]) {
			return mid + 1;
		}

		else if (dp[mid] < find) {
			return binarySearch(mid + 1, right, find);
		}

		else {
			return binarySearch(left, mid - 1, find);
		}

	}

}