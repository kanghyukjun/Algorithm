import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = null;
		for (int TC = 1; TC <= 10; TC++) {
			sb.append('#').append(br.readLine()).append(' ');

			// get input
			Integer[] arr = new Integer[8];
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// process
			Queue<Integer> que = new ArrayDeque<>(Arrays.asList(arr));
			int sub = 1;
			while (true) {
				int num = que.poll();
				num -= sub;
				if (num <= 0) {
					que.add(0);
					break;
				}
				que.add(num);
				sub = (sub % 5) + 1;
			}

			while (!que.isEmpty()) {
				sb.append(que.poll()).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}