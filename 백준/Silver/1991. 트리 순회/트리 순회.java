import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		Node left;
		char value;
		Node right;

		public Node(char value) {
			this.value = value;
		}
	}

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node((char) (i + 'A'));
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(left != '.' ) {
				nodes[parent - 'A'].left = nodes[left - 'A'];
			}
			if(right != '.') {
				nodes[parent - 'A'].right = nodes[right - 'A'];
			}
		}

		// process
		preOrder(nodes[0]);
		sb.append('\n');
		inOrder(nodes[0]);
		sb.append('\n');
		postOrder(nodes[0]);

		// output
		System.out.println(sb);
	}

	private static void preOrder(Node node) {
		if (node == null)
			return;
		sb.append(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) {
		if(node == null)
			return;
		inOrder(node.left);
		sb.append(node.value);
		inOrder(node.right);
	}

	private static void postOrder(Node node) {
		if(node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.value);
	}

}