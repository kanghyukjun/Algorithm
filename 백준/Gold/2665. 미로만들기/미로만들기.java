import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] moves = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N * N; i++) {
            if (letsGo(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean letsGo(int max) {
        boolean find = false;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0));
        int[][] isChecked = new int[N][N];

        for (int[] row : isChecked) {
            Arrays.fill(row, 2501);
        }

        while (!que.isEmpty()) {
            if (find) break;

            Node node = que.poll();
            int row = node.row;
            int col = node.col;
            int destruction = node.destruction;

            for (int[] move : moves) {
                int nRow = row + move[0];
                int nCol = col + move[1];

                if (!isValid(nRow, nCol)) continue;

                if (nRow == N - 1 && nCol == N - 1) {
                    find = true;
                    break;
                }

                if (isWall(nRow, nCol)) {
                    if (destruction + 1 <= max && isChecked[nRow][nCol] > destruction + 1) {
                        que.add(new Node(nRow, nCol, destruction + 1));
                        isChecked[nRow][nCol] = destruction + 1;
                    }
                } else {
                    if (isChecked[nRow][nCol] > destruction) {
                        que.add(new Node(nRow, nCol, destruction));
                        isChecked[nRow][nCol] = destruction;
                    }
                }
            }
        }

        return find;
    }

    public static boolean isValid(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }

    public static boolean isWall(int row, int col) {
        return map[row][col] == 0;
    }

    static class Node {
        int row;
        int col;
        int destruction;

        Node(int row, int col, int destruction) {
            this.row = row;
            this.col = col;
            this.destruction = destruction;
        }
    }
}