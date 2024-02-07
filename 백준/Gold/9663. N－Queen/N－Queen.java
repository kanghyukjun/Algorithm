import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean[] colCheck;
	static boolean[] leftDownCheck;
	static boolean[] leftUpCheck;
	
	static long count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// get input
		int N = Integer.parseInt(br.readLine());
		colCheck = new boolean[N];
		leftDownCheck = new boolean[2 * N - 1];
		leftUpCheck = new boolean[2 * N - 1];
		
		// process
		nQueen(0, N);
		
		// output
		System.out.println(count);
	}

	private static void nQueen(int row, int N) {
		if(row == N) {
			count++;
			return;
		}
		
		for (int col = 0; col < N; col++) {
			if(!colCheck[col] && !leftDownCheck[col - row + N - 1] && !leftUpCheck[col + row]) {
				colCheck[col] = true;
				leftDownCheck[col - row + N - 1] = true;
				leftUpCheck[col + row] = true;
				
				nQueen(row + 1, N);
				
				colCheck[col] = false;
				leftDownCheck[col - row + N - 1] = false;
				leftUpCheck[col + row] = false;
			}
		}
	}
	
}