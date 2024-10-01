import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<String>((s1, s2) -> s2.compareTo(s1));

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String oper = st.nextToken();

			if (oper.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String current = iter.next();
			sb.append(current).append("\n");
		}
		System.out.println(sb);
	}

}