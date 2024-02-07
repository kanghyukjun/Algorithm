import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int oper = Integer.parseInt(st.nextToken());
			switch (oper) {
			case 1:
				arr = one(arr);
				break;
			case 2:
				arr = two(arr);
				break;
			case 3:
				arr = three(arr);
				break;
			case 4:
				arr = four(arr);
				break;
			case 5:
				arr = five(arr);
				break;
			case 6:
				arr = six(arr);
				break;
			}
		}

		// output
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static int[][] one(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[N - i - 1][j];
			}
		}
		return tmp;
	}

	private static int[][] two(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[i][M - j - 1];
			}
		}
		return tmp;

	}

	private static int[][] three(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[j][N - i - 1] = arr[i][j];
			}
		}
		return tmp;
	}

	private static int[][] four(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[M - j - 1][i] = arr[i][j];
			}
		}
		return tmp;
	}

	// 1번 구역
	// i : 0 ~ N / 2 - 1
	// j : 0 ~ M / 2 - 1

	// 2번 구역
	// i : 0 ~ N / 2 - 1
	// j : M / 2 ~ M - 1

	// 3번 구역
	// i : N / 2 ~ N - 1
	// j : M / 2 ~ M - 1

	// 4번 구역
	// i : N / 2 ~ N - 1
	// j : 0 ~ M / 2 - 1

	private static int[][] five(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][M / 2 + j] = arr[i][j]; // 1번 구역 -> 2번 구역
				tmp[N / 2 + i][M / 2 + j] = arr[i][M / 2 + j]; // 2번 구역 -> 3번 구역
				tmp[N / 2 + i][j] = arr[N / 2 + i][M / 2 + j]; // 3번 구역 -> 4번 구역
				tmp[i][j] = arr[N / 2 + i][j]; // 4번 구역 -> 1번 구역
			}
		}
		return tmp;
	}

	private static int[][] six(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[N / 2 + i][j] = arr[i][j]; // 1번 구역 -> 4번 구역
				tmp[N / 2 + i][M / 2 + j] = arr[N / 2 + i][j]; // 4번 구역 -> 3번 구역
				tmp[i][M / 2 + j] = arr[N / 2 + i][M / 2 + j]; // 3번 구역 -> 2번 구역
				tmp[i][j] = arr[i][M / 2 + j]; // 2번 구역 -> 1번 구역
			}
		}
		return tmp;
	}

}