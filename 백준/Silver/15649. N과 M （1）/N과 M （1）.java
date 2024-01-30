// https://st-lab.tistory.com/114 참고
import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		check = new boolean[n];
	    dfs(n,m,0);
	    System.out.print(sb);
	}
	public static void dfs(int n, int m, int depth) {
	    if(depth==m){
	        for(int val:arr){
	            sb.append(val+" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    
	    for(int i=0; i<n; i++){
	        if(!check[i]){
	            check[i] = true;
	            arr[depth] = i+1;
	            dfs(n,m,depth+1);
	            check[i] = false;
	        }
	    }
	}
}