import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Node {
		char value;
		boolean isDeleted;
		Node nextFriend;
		Node nextDelete;
		
		public Node(char value) {
			this.value = value;
			isDeleted = false;
			nextFriend = null;
			nextDelete = null;
		}
		
		public boolean equals(char c) {
			return value == c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// get input
		String S = br.readLine();
		
		// process
		// A를 지우고, 그 뒤에 있는 B를 지울 수 있다.
		// B를 지우고, 그 뒤에 있는 C를 지울 수 있다.
		// dp? greedy?
		
		// 우선 B를 찾은 후 먼저 B와 C를 지운다?
		// B에서 C를 지울 때 해당 B에서 가장 가까운 C를 지운다
		// A에서 B를 지울 때 해당 A에서 가장 가까운 B를 지운다
		
		// A는 A보다 뒤에 있는 B의 위치를 알고있다
		// B는 B보다 뒤에 있는 C의 위치를 알고있다
		
		// 인덱스 + 연결 리스트 구현
		Node[] nodes = new Node[S.length()];
		Node beforeA = null;
		Node beforeB = null;
		Node beforeC = null;
		for (int i = nodes.length - 1; i >= 0; i--) {
			char c = S.charAt(i);
			nodes[i] = new Node(c);
			
			if(c == 'A') {
				nodes[i].nextFriend = beforeA;
				nodes[i].nextDelete = beforeB;
				beforeA = nodes[i];
			} else if(c == 'B') {
				nodes[i].nextFriend = beforeB;
				nodes[i].nextDelete = beforeC;
				beforeB = nodes[i];
			} else {
				nodes[i].nextFriend = beforeC;
				beforeC = nodes[i];
			}
		}
		
		// B부터 찾은 후 삭제
		int count = 0;
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i].equals('B')) {
				// 가장 가까운 C를 찾기
				Node delete = nodes[i].nextDelete;
				while(delete != null && delete.isDeleted) {
					delete = delete.nextFriend;
				}
				if(delete != null) {
					nodes[i].isDeleted = true;
					delete.isDeleted = true;
					count++;
				}
			}
		}
		
		// A 삭제
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i].equals('A')) {
				// 가장 가까운 B를 찾기
				Node delete = nodes[i].nextDelete;
				while(delete != null && delete.isDeleted) {
					delete = delete.nextFriend;
				}
				if(delete != null) {
					nodes[i].isDeleted = true;
					delete.isDeleted = true;
					count++;
				}
			}
		}
		
		// output
		System.out.println(count);
	}
	
}