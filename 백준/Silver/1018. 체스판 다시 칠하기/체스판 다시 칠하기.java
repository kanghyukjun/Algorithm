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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// process
		int min = 50 * 50 + 1;
		for (int rStart = 0; rStart < R - 7; rStart++) {
			for (int cStart = 0; cStart < C - 7; cStart++) {
				int startWithWhiteCount = 0;
				int startWithBlackCount = 0;

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						// white로 시작할 때 i와 j의 합이 홀수이면 B, 짝수이면 W
						// black으로 시작할 때 i와 j의 합이 홀수이면 W, 짝수이면 B
						if ((i + j) % 2 == 0) {
							// whiteCount
							if (map[i + rStart][j + cStart] != 'W')
								startWithWhiteCount++;
							// blackCount
							if (map[i + rStart][j + cStart] != 'B')
								startWithBlackCount++;
						} else {
							// whiteCount
							if (map[i + rStart][j + cStart] != 'B')
								startWithWhiteCount++;
							// blackCount
							if (map[i + rStart][j + cStart] != 'W')
								startWithBlackCount++;
						}

					}
				}

				min = Math.min(min, Math.min(startWithWhiteCount, startWithBlackCount));
			}
		}
		
		// output
		System.out.println(min);

	}

}