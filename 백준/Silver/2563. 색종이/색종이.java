import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean check[][] = new boolean[102][102];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= 10; j++) {
				for (int k = 1; k <= 10; k++) {
					check[j + row][k + col] = true;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length; j++) {
				if(check[i][j])
					count++;
			}
		}
		System.out.println(count);
	}

}