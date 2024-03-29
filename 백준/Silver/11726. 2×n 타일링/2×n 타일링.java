import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int n = Integer.parseInt(br.readLine());
		
		// process
		int[] arr = new int[1001];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = (arr[i - 1] % 10007 + arr[i - 2] % 10007) % 10007;
		}
		
		// output
		System.out.println(arr[n]);
	}

}