import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		List<Node> childs;

		public Node() {
			super();
			childs = new ArrayList<>();
		}

		public boolean isLeaf() {
			return childs.size() == 0;
		}

	}

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int deleted = Integer.parseInt(br.readLine());

		// process
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node();
		}

		Node root = null;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (i == deleted || parent == deleted)
				continue;

			if (parent == -1) {
				root = nodes[i];
			} else {
				nodes[parent].childs.add(nodes[i]);
			}
		}
		find(root);

		// output
		System.out.println(count);
	}

	private static void find(Node node) {
		if (node != null) {
			if (node.isLeaf())
				count++;
			else {
				for (Node child : node.childs) {
					find(child);
				}
			}
		}
	}

}