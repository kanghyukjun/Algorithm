import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			sb.append("#").append(TC).append(" ");
			
			// get input
			char[] arr = br.readLine().toCharArray();

			// process
			char compare = '0';
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if(compare != arr[i]) {
					count++;
					compare = arr[i];
				}
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
}