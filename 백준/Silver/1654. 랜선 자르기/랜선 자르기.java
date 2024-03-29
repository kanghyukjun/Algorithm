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
		int lanNum = Integer.parseInt(st.nextToken());
		int needLan = Integer.parseInt(st.nextToken());
		int[] lans = new int[lanNum];
		int max = 0;
		for (int i = 0; i < lanNum; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lans[i]);
		}
		
		// process
		// target개를 만들 수 있는 랜선의 최대 길이를 찾아라
		// 최대한 target개에 맞출 수 있다면 그 때가 랜선의 최대 길이가 되겠지?
		
		// lowerBound 이상, upperBound 이하인 값 중 찾을 것이다
		// 이 중 target개를 만들 수 있는 방법 중 가장 긴 lan 길이를 찾을 것이다
		long lowerBound = 1; // 무조건 만들 수 있는 방법의 수
		long upperBound = max; // 무조건 만들 수 없는 방법의 수
		long output = -1;
		while(lowerBound <= upperBound) {
			long mid = (lowerBound + upperBound) / 2;
//			int mid = lowerBound / 2 + upperBound / 2;
			
			// 만약 해당 길이로 잘랐는데 가능하다
			// 답이 될 수 있다
			// 더 긴 길이로 잘라보자
			if(available(lans, mid, needLan)) {
				output = mid;
				lowerBound = mid + 1;
			}
			
			// 만약 해당 길이로 잘랐는데 불가능하다
			// 답이 될 수 없다
			// 더 작은 길이로 잘라보자
			else {
				upperBound = mid - 1;
			}
		}
		
		System.out.println(output);
	}
	
	public static boolean available(int[] lans, long cut, int needLan) {
		long count = 0;
		for (int lan : lans) {
			count += lan / cut;
		}
		return count >= needLan;
	}
	
}