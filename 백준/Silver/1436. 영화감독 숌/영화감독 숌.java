import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		// 10_000_666
		int count = 0;
		int output = -1;
		for (int num = 1; num <= 10_000_666; num++) {
			String line = Integer.toString(num);
			int sixCount = 0;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '6')
					sixCount++;
				else
					sixCount = 0;
				if (sixCount >= 3)
					break;
			}
			if (sixCount >= 3)
				count++;

			if (count == N) {
				output = num;
				break;
			}
		}

		// output
		System.out.println(output);

	}

}