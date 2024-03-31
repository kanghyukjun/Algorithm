import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// process
		int count = 0;
		for (int size = 1; size < arr.length; size++) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				sum += arr[i];
			}
			// size가 3이라고 하면
			// 0부터 2까지의 합을 미리 구해둔다
			for (int start = size; start < arr.length; start++) {
				sum = sum + arr[start] - arr[start - size];
				if(sum  == find)
					count++;
			}
		}
		
		System.out.println(count);
		
	}

}