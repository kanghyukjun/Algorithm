import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine()); // OI가 나오는 횟수
		br.readLine(); // length
		String s = br.readLine();

		// process
		int[] OIs = new int[s.length()];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'O') {
				continue;
			}

			if (i - 1 >= 0 && s.charAt(i - 1) == 'O' && i - 2 >= 0 && s.charAt(i - 2) == 'I') {
				OIs[i] = OIs[i - 2] + 1;
			}
			if(OIs[i] >= N) {
				count++;
			}
		}
		
		// output
		System.out.println(count);
	}

}