import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int value;
		int idx;

		public Node(int value, int idx) {
			super();
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), i);
		}

		// process
		// nlogn + n
		Arrays.sort(nodes);
		int[] output = new int[N];
		int count = 0;
		output[nodes[0].idx] = count;

		for (int i = 1; i < N; i++) {
			if (nodes[i - 1].value < nodes[i].value) {
				output[nodes[i].idx] = ++count;
			} else {
				output[nodes[i].idx] = count;
			}
		}

		// output
		for (int i : output) {
			sb.append(i).append(' ');
		}
		System.out.println(sb);
	}

}