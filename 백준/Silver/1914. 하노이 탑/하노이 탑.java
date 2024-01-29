import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static StringBuilder sb;
	static int num;
	static BigInteger count = new BigInteger("0");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// get input
		num = Integer.parseInt(br.readLine());
		BigInteger output = new BigInteger("2").pow(num).subtract(new BigInteger("1"));
		System.out.println(output);
		// process
		if(num <= 20) {
			hanoi(num, 1, 2, 3);
			System.out.println(sb);
		}
	}

	public static void hanoi(int n, int from, int tmp, int to) {
		if (n == 1) {
			if (num <= 20) {
				sb.append(from).append(" ").append(to).append("\n");
			}
			return ;
		}

		hanoi(n - 1, from, to, tmp);
		if (num <= 20) {
			sb.append(from).append(" ").append(to).append("\n");
		}
		hanoi(n - 1, tmp, from, to);
	}

}