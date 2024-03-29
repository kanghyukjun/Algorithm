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
		int targetLength = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < trees.length; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		// process
		// lowerBound <= target <= upperBound 값을 찾을 것임
		int lowerBound = 0; // 무조건 나무를 얻을 수 있는 길이
		int upperBound = max; // 무조건 나무를 얻을 수 없는 길이
		int output = -1;
		while(lowerBound <= upperBound) {
			int mid = (lowerBound + upperBound) / 2;
			
			// 가능하다면 답이 될 수 있다
			// 더 좋은 답이 있을 수 있으므로 더 위에서 잘라본다
			if(available(trees, mid, targetLength)) {
				output = mid;
				lowerBound = mid + 1;
			}
			// 가능하지 않다면 더 아래에서 나무를 잘라야 한다
			// 또한, 답이 될 수 없다
			else {
				upperBound = mid - 1;
			}
		}
		
		System.out.println(output);
	}
	
	private static boolean available(int[] trees, int cut, int targetLength) {
		long sum = 0;
		for (int tree : trees) {
			if(tree <= cut)
				continue;
			sum += tree - cut;
		}
		return sum >= targetLength;
	}
	
}