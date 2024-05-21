import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int pollPointer = 0;
		int addPointer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if ("push".equals(order)) {
				int X = Integer.parseInt(st.nextToken());
				arr[addPointer++] = X;
			} else if ("pop".equals(order)) {
				if (pollPointer == addPointer) {
					sb.append(-1).append('\n');
				} else {
					sb.append(arr[pollPointer++]).append('\n');
				}
			} else if ("size".equals(order)) {
				sb.append(addPointer - pollPointer).append('\n');
			} else if ("empty".equals(order)) {
				if (pollPointer == addPointer) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if ("front".equals(order)) {
				if (pollPointer == addPointer) {
					sb.append(-1).append('\n');
				} else {
					sb.append(arr[pollPointer]).append('\n');
				}
			} else {
				if (pollPointer == addPointer) {
					sb.append(-1).append('\n');
				} else {
					sb.append(arr[addPointer - 1]).append('\n');
				}
			}
		}
		System.out.println(sb);
	}

}