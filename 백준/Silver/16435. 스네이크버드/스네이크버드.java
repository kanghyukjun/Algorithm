import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		int[] feeds = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			feeds[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(feeds);
		
		// process
		for (int i = 0; i < feeds.length; i++) {
			if(feeds[i] > L)
				break;
			L++;
		}
		
		// output
		System.out.println(L);
	}
	
}