import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		for (int i = K - 1; list.size() > 1; i = (i + K) % list.size()) {
			sb.append(list.get(i)).append(", ");
			list.remove(i);
			i--;
		}
		sb.append(list.get(0)).append('>');
		
		System.out.println(sb);
	}

}