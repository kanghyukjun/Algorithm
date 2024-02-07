import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };
	
	static List<int[]> viruses;
	static int maxSafe = 0;
	
	static int N;
	static int M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		viruses = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2)
					viruses.add(new int[] { i, j });
				arr[i][j] = num;
			}
		}

		// process
		find(0);
		
		// output
		System.out.println(maxSafe);
	}
	
	private static void find(int depth) {
		if(depth == 3) {
			int[][] arrCopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				arrCopy[i] = Arrays.copyOf(arr[i], arr[i].length);
			}
			
			for (int i = 0; i < viruses.size(); i++) {
				int[] virus = viruses.get(i);
				Queue<int[]> queue = new ArrayDeque<>();
				queue.add(virus);
				while (!queue.isEmpty()) {
					int[] cur = queue.poll();
					for (int j = 0; j < 4; j++) {
						int row = cur[0] + drow[j];
						int col = cur[1] + dcol[j];
						if (row < 0 || col < 0 || row >= N || col >= M || arrCopy[row][col] != 0)
							continue;

						arrCopy[row][col] = 2;
						queue.add(new int[] { row, col });
					}
				}
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arrCopy[i][j] == 0)
						count++;
				}
			}
			
			maxSafe = Math.max(maxSafe, count);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] != 0)
					continue;
				
				arr[i][j] = 1;
				find(depth + 1);
				arr[i][j] = 0;
			}
		}
		
	} 
    
}