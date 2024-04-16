import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static class Node {
		boolean isWord;
		Node[] childs;

		public Node() {
			isWord = false;
			childs = new Node['z' - 'a' + 1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Node root = new Node();
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			Node head = root;
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if (head.childs[c - 'a'] == null) {
					head.childs[c - 'a'] = new Node();
				}
				head = head.childs[c - 'a'];
			}
			head.isWord = true;
		}

		// process
		int count = 0;
		TreeSet<String> set = new TreeSet<>();
		Loop: for (int i = 0; i < m; i++) {
			String line = br.readLine();
			Node head = root;
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if (head.childs[c - 'a'] == null) {
					continue Loop;
				}
				head = head.childs[c - 'a'];
			}
			if (head.isWord) {
				count++;
				set.add(line);
			}
		}
		sb.append(count).append('\n');
		while (!set.isEmpty())
			sb.append(set.pollFirst()).append('\n');
		System.out.println(sb);
	}

}