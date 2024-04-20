import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int pocketmonNo;
		Map<Character, Node> childs;

		public Node() {
			pocketmonNo = 0;
			childs = new HashMap<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// process
		Node root = new Node();
		String[] noToName = new String[N + 1];
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			noToName[i] = br.readLine();
			map.put(noToName[i], i);
//			Node head = root;
//
//			for (int j = 0; j < noToName[i].length(); j++) {
//				char c = noToName[i].charAt(j);
//				if (!head.childs.containsKey(c))
//					head.childs.put(c, new Node());
//				head = head.childs.get(c);
//			}
//			head.pocketmonNo = i;
		}

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (isNum(input)) {
				sb.append(noToName[Integer.parseInt(input)]).append('\n');
			} else {
//				Node head = root;
//				for (int j = 0; j < input.length(); j++) {
//					head = head.childs.get(input.charAt(j));
//				}
//				sb.append(head.pocketmonNo).append('\n');
				sb.append(map.get(input)).append('\n');
			}
		}

		// output
		System.out.println(sb);
	}

	public static boolean isNum(String string) {
		return 0 <= string.charAt(0) - '0' && string.charAt(0) - '0' <= 9;
	}

}