import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[K];

		// process
		int pointer = 0; // [0, pointer)

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				pointer--;
			} else {
				arr[pointer] = num;
				pointer++;
			}
		}

		// output
		int sum = 0;
		for (int i = 0; i < pointer; i++) {
			sum += arr[i];
		}
		System.out.println(sum);

	}

}