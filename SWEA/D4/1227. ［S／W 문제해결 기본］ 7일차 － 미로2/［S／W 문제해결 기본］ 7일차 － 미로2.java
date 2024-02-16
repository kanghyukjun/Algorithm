import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= 10; TC++) {
			sb.append('#').append(br.readLine()).append(' ');

			// get input
			char[][] map = new char[100][100];
			int[] start = new int[] { 1, 1 };
			int[] end = new int[2];
			for (int i = 0; i < 100; i++) {
				String in = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = in.charAt(j);
					if(map[i][j] == '3') {
						end[0] = i;
						end[1] = j;
					}
				}
			}

			// process
			map[1][1] = '1';
			Queue<int[]> que = new ArrayDeque<>();
			que.add(start);
			boolean flag = false;
			while (!que.isEmpty()) {
				int[] current = que.poll();
				for (int i = 0; i < 4; i++) {
					int nextRow = current[0] + drow[i];
					int nextCol = current[1] + dcol[i];
					if (map[nextRow][nextCol] == '1')
						continue;
					map[nextRow][nextCol] = '1';
					que.add(new int[] { nextRow, nextCol });
					if(nextRow == end[0] && nextCol == end[1]) {
						flag = true;
						break;
					}
				}
			}
			
			// output
			if(flag) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}