import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int[] save;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		save = new int[M];
		
		int[] arr = new int[N];
		boolean[] isChecked = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// process
		Arrays.sort(arr);
		solve(M, 0, arr, isChecked);
		
		// output
		System.out.println(sb);
	}
	
	private static void solve(int end, int depth, int[] arr, boolean[] isChecked) {
		if(depth == end) {
			for (int num : save) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!isChecked[i]) {
				isChecked[i] = true;
				save[depth] = arr[i];
				solve(end, depth+1, arr, isChecked);
				isChecked[i] = false;
			}
		}
	}
}