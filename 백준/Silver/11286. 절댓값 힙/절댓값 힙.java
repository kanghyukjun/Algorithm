import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	private static class AbsNum implements Comparable<AbsNum> {
		int num;
		int abs;

		public AbsNum(int num) {
			this.num = Math.abs(num);
			this.abs = num < 0 ? -1 : 1;
		}

		@Override
		public int compareTo(AbsNum o) {
			if (this.num == o.num) {
				return this.abs - o.abs;
			}

			return this.num - o.num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<AbsNum> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num != 0) {
				pq.add(new AbsNum(num));
			} else {
				if (pq.isEmpty()) {
					sb.append(0);
				} else {
					AbsNum abs = pq.poll();
					sb.append(abs.num * abs.abs);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

}