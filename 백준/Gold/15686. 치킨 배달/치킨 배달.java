import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static List<Pair> chicken;
	static List<Pair> house;
	static Pair[] selectedChicken;
	static int min;

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		selectedChicken = new Pair[M];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new Pair(i, j));
				} else if (map[i][j] == 1) {
					house.add(new Pair(i, j));
				}
			}
		}

		// process
		solve(0, 0);

		// output
		System.out.println(min);
	}

	private static int getDistance(Pair from, Pair to) {
		return Math.abs(from.row - to.row) + Math.abs(from.col - to.col);
	}

	private static void solve(int depth, int idx) {
		if (depth == M) {
			int[] houseDistance = new int[house.size()];
			Arrays.fill(houseDistance, Integer.MAX_VALUE);
			for (Pair chicken : selectedChicken) {
				for (int i = 0; i < houseDistance.length; i++) {
					houseDistance[i] = Math.min(houseDistance[i], getDistance(chicken, house.get(i)));
				}
			}

			int count = 0;
			for (int i = 0; i < houseDistance.length; i++) {
				count += houseDistance[i];
			}
			min = Math.min(min, count);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			selectedChicken[depth] = chicken.get(i);
			solve(depth + 1, i + 1);
		}
	}

}