
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static class Node implements Comparable<Node> {
		int vert;
		int weight;
		
		public Node(int vert, int weight) {
			this.vert = vert;
			this.weight = weight;
		}
		@Override
		public boolean equals(Object object) {
			return this.vert == ((Node)object).vert;
		}
		@Override
		public int compareTo(Node node) {
			if(this.weight > node.weight)
				return 1;
			else if(this.weight < node.weight)
				return -1;
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점 갯수
		int E = Integer.parseInt(st.nextToken()); // 간선 갯수
		int start = Integer.parseInt(br.readLine());
		
		int[] distance = new int[V+1];
		boolean[] check = new boolean[V+1];
		check[0] = true;
		check[start] = true;
		
		ArrayList<Node>[] list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
//			var to_list = list[from];
//			int index = to_list.indexOf(new Node(to,0));
//			
//			// 최소 weight를 가진 간선만 남겨두기
//			if(index != -1) {
//				Node old = to_list.get(index);
//				if(old.weight < weight)
//					continue;
//				else {
//					to_list.remove(index);
//					to_list.add(new Node(to, weight));
//				}
//			}
//			else {
//				to_list.add(new Node(to, weight));
//			}
		}
		
		distance = Dijkstra(start, list, V);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(distance[i]+"\n");
		}
		System.out.print(sb);
	}
	public static int[] Dijkstra(int start, ArrayList<Node>[] list, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(node.weight > distance[node.vert]) continue;
			
			var to_list = list[node.vert];
			for(int i=0; i<to_list.size(); i++) {
				Node to = to_list.get(i);
				if(distance[to.vert] > distance[node.vert] + to.weight) {
					distance[to.vert] = distance[node.vert] + to.weight;
					pq.offer(new Node(to.vert, distance[to.vert]));
				}
			}
		}
		return distance;
	}
}