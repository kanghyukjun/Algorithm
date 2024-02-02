import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	static Map<Character, Character> getPair = new HashMap<Character, Character>() {{
		put('(', ')');
		put('[', ']');
		put('{', '}');
		put('<', '>');
	}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= 10; TC++) {
			// get input
			int len = Integer.parseInt(br.readLine());
			String input = br.readLine();

			// process
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < len; i++) {
				char cur = input.charAt(i);
				if(getPair.containsKey(cur)) {
					// 왼쪽 괄호인 경우
					stk.push(cur);
				} else {
					// 오른쪽 괄호인 경우
					char top = stk.pop();
					if(getPair.get(top) != cur) {
						stk.push(top);
						break;
					}
				}
			}
			
			sb.append('#').append(TC).append(' ');
			if(stk.isEmpty()) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}