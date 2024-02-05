import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static class Pair {
		int height;
		int idx;

		public Pair(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		Pair[] tower = new Pair[N + 1];
		int[] receive = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tower[i] = new Pair(Integer.parseInt(st.nextToken()), i);
		}

		// process
		Stack<Pair> stk = new Stack<>();
		for (int i = N; i > 0; i--) {
			while (!stk.isEmpty() && stk.peek().height <= tower[i].height) {
				Pair pop = stk.pop();
				receive[pop.idx] = i;
			}
			stk.push(tower[i]);
		}

		// output
		for (int i = 1; i <= N; i++) {
			sb.append(receive[i]).append(' ');
		}
		System.out.println(sb);
	}

}