import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		loop1: for (int TC = 0; TC < N; TC++) {
			String in = br.readLine();
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < in.length(); i++) {
				if(in.charAt(i) == '(') {
					stk.push('(');
				}
				else {
					if(stk.isEmpty()) {
						sb.append("NO").append('\n');
						continue loop1;
					}
					stk.pop();
				}
			}
			if(stk.isEmpty()) {
				sb.append("YES").append('\n');
			}
			else {
				sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}
	
}