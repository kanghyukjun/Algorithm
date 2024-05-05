import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {

			// get input
			String order = br.readLine();
			int arrSize = Integer.parseInt(br.readLine());
			int[] arr = new int[arrSize];
			st = new StringTokenizer(br.readLine(), ",|[|]");
			for (int i = 0; i < arrSize; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// process
			// 각 원소를 포함하지 않는다
			// 만약 left >= right가 되면 유효하지 않은 수식이 된다
			int left = -1;
			int right = arrSize;
			boolean isReversed = false;
			boolean flag = true;
			for (int i = 0; i < order.length(); i++) {
				if (order.charAt(i) == 'R') {
					isReversed = !isReversed;
				} else {
					if (!isReversed) {
						left++;
					} else {
						right--;
					}

					if (left >= right) {
						flag = false;
						break;
					}
				}
			}

			// output
			if (!flag) {
				sb.append("error").append('\n');
			} else {
				sb.append('[');
				if (!isReversed) {
//					System.out.println("left: " + left + ", right: " + right);
					for (int i = left + 1; i < right - 1; i++) {
						sb.append(arr[i]).append(',');
					}
					if (left + 1 != right)
						sb.append(arr[right - 1]);
				} else {
					for (int i = right - 1; i > left + 1; i--) {
						sb.append(arr[i]).append(',');
					}
					if (left + 1 != right)
						sb.append(arr[left + 1]);
				}
				sb.append(']').append('\n');
			}
		}

		System.out.println(sb);
	}

}