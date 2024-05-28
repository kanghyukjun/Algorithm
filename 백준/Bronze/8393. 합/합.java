import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// get input
		int n = Integer.parseInt(br.readLine());
		
		// process
		int sum = IntStream.rangeClosed(1, n).sum();
		
		// output
		System.out.println(sum);
	}
	
}