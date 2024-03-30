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
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] finds = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < finds.length; i++) {
			finds[i] = Integer.parseInt(st.nextToken());
		}
		
		// process
		Arrays.sort(cards);
		for (int find : finds) {
			sb.append(findTarget(cards, find) ? 1 : 0).append(' ');
		}
		
		// output
		System.out.println(sb);
	}
	
	private static boolean findTarget(int[] cards, int find) {
		boolean flag = false;
		
		// lowerBound 이상 upperBound 이하의 값을 탐색한다
		int lowerBound = 0;
		int upperBound = cards.length - 1;
		while(lowerBound <= upperBound) {
			int mid = (lowerBound + upperBound) / 2; // overflow 날 가능성 없음
			if(cards[mid] == find) {
				flag = true;
				break;
			}
			else if(cards[mid] < find) {
				lowerBound = mid + 1;
			}
			else {
				upperBound = mid - 1;
			}
		}
		
		return flag;
	}
	
}