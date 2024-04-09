import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;
    static List<Integer>[] adj;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // get input
        int N = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        adj = new List[N+1];
        checked = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        // process
        checked[1] = true;
        dfs(1);

        // output
        System.out.println(count);
    }

    private static void dfs(int i) {
        for (int v : adj[i]) {
            if(!checked[v]) {
                count++;
                checked[v] = true;
                dfs(v);
            }
        }
    }
}