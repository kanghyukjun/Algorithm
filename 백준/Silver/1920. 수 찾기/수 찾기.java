import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// get input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] find = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		
		// process
		// binary search
		Arrays.sort(arr);
		for (int target : find) {
			sb.append(binarySearch(arr, target) ? 1 : 0).append('\n');
		}
		System.out.println(sb);
	}
	
	public static boolean binarySearch(int[] arr, int target) {
		boolean flag = false;
		
		// l이상, r이하인 값들을 찾을 것이다
		int l = 0, r = arr.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(arr[mid] < target) {
				l = mid + 1;
			}
			else if(target < arr[mid]) {
				r = mid - 1;
			}
			else {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
}