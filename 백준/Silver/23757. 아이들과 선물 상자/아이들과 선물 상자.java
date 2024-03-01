import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> gift = new PriorityQueue<>(Comparator.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			gift.add(Integer.parseInt(st.nextToken()));
		}

		int[] child = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			child[i] = Integer.parseInt(st.nextToken());
		}

		// process
		boolean flag = false;
		for (int i = 0; i < child.length; i++) {
			int giftRem = gift.poll() - child[i];

			if (giftRem < 0) {
				flag = true;
				break;
			} else if (giftRem > 0) {
				gift.add(giftRem);
			}
		}

		// output
		System.out.println(flag ? 0 : 1);
	}

}