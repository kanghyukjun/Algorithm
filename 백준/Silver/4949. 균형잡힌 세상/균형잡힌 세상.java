import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		String line = null;
		while (!".".equals(line = br.readLine())) {
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				char current = line.charAt(i);
				if (current == '(' || current == '[') {
					stk.push(current);
				} else if (current == ')') {
					if(stk.isEmpty()) {
						stk.push('0');
						break;
					}
					
					char pop = stk.pop();
					if(pop != '(') {
						stk.push(pop);
						break;
					}
				} else if (current == ']') {
					if(stk.isEmpty()) {
						stk.push('0');
						break;
					}
					char pop = stk.pop();
					if(pop != '[') {
						stk.push(pop);
						break;
					}
				}
			}
			
			if(stk.size() != 0)
				sb.append("no").append('\n');
			else
				sb.append("yes").append('\n');
		}
		
		System.out.println(sb);
	}

}