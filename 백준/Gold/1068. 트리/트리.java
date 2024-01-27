import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
//	public static final int MAX = 50;
	
	public static class Node {
		int value;
		List<Integer> child; // 자손 노드를 index로 저장
		
		public Node(int value) {
			this.value = value;
			child = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());
		list = new Node[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = new Node(i);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rootIdx = -1;
		for (int i = 0; i < list.length; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				rootIdx = i;
				continue;
			}
			list[parent].child.add(i);
		}
		
		int delete = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < list.length; i++) {
			list[i].child.remove(Integer.valueOf(delete));
		}
		
		// process
		check = new boolean[N];
		check[delete] = true;
		dfs(rootIdx);
		
		System.out.println(count);
	}

	public static boolean[] check;
	public static int count = 0;
	public static Node[] list;
	
	private static void dfs(int idx) {
		if(check[idx]) {
			return;
		}
		check[idx] = true;
		
		if(list[idx].child.size()==0) {
			count++;
		}else {
			for (int i = 0; i < list[idx].child.size(); i++) {
				dfs(list[idx].child.get(i));
			}
		}
	}

}