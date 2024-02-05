import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append('<');

		// get input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

		// process
		boolean[] isChecked = new boolean[N + 1];
		int curIdx = 1;
		int kCount = 0;
		int remain = N;
		while (remain > 0) {
			if (!isChecked[curIdx]) {
				kCount++;
				if (kCount % K == 0) {
					isChecked[curIdx] = true;
					sb.append(curIdx).append(", ");
					remain--;
				}
			}
			curIdx = (curIdx % N) + 1;
		}
		sb.delete(sb.length() - 2, sb.length()).append('>');
		System.out.println(sb);
	}

}