import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 101;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		int nLadders = Integer.parseInt(st.nextToken());
		int nSnakes = Integer.parseInt(st.nextToken());

		int[] ladder = new int[101];
		int[] snake = new int[101];
		for (int i = 0; i < nLadders; i++) {
			st = new StringTokenizer(br.readLine());
			ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < nSnakes; i++) {
			st = new StringTokenizer(br.readLine());
			snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		// process
		int[] map = new int[101];
		Arrays.fill(map, INF);
		map[1] = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(1);
		while (!que.isEmpty()) {
			int current = que.poll();
			if(current == 100)
				break;
			
			for (int i = 6; i >= 1; i--) {
				int next = current + i;
				if (next > 100)
					continue;
				
				if (ladder[next] != 0) {
					int afterLadder = ladder[next];
					if (map[afterLadder] > map[current] + 1) {
						map[afterLadder] = map[current] + 1;
						que.add(afterLadder);
					}
				} else if (snake[next] != 0) {
					int afterSnake = snake[next];
					if (map[afterSnake] > map[current] + 1) {
						map[afterSnake] = map[current] + 1;
						que.add(afterSnake);
					}
				} else {
					if (map[next] > map[current] + 1) {
						map[next] = map[current] + 1;
						que.add(next);
					}
				}
			}
		}
		
		// output
		System.out.println(map[100]);
	}

}