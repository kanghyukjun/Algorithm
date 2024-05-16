import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		TreeSet<String> ts = new TreeSet<>((s1, s2)->{
			if(s1.length() == s2.length())
				return s1.compareTo(s2);
			else
				return s1.length() - s2.length();
		});
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			ts.add(br.readLine());
		}

		// process
		while (!ts.isEmpty()) {
			sb.append(ts.pollFirst()).append('\n');
		}
		
		// output
		System.out.println(sb);

	}

}