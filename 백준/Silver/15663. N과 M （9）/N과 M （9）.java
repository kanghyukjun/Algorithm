import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] save;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[10001];
		save = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
		}

		// process
		solve(0);
		
		// output
		System.out.println(sb);
		
	}

	private static void solve(int depth) {
		if (depth == M) {
			for (int num : save) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}

		else {
			for (int i = 1; i < 10001; i++) {
				if(arr[i] != 0) {
					arr[i]--;
					save[depth] = i;
					solve(depth + 1);
					arr[i]++;
				}
			}
		}
	}

}