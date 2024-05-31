import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		int length = 64;
		int count = 1;

		while (N > 0) {
			if (length == N)
				N -= length;
			length /= 2;
			if (length < N) {
				N -= length;
				count++;
			}

		}

		// output
		System.out.println(count);
	}

}