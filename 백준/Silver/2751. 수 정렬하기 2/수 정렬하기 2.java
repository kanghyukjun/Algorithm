import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// get input
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list =  new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		// process
		Collections.sort(list);
		
		// output
		list.forEach(x -> sb.append(x).append('\n'));
		System.out.println(sb);
	}
	
}