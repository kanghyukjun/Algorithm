import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static class Node<E> {
		E value;
		Node<E> next;

		private Node() {}
		
		private Node(E value) {
			this.value = value;
		}
	}

	private static class LinkedList<E> {
		Node<E> headDummy;

		private LinkedList() {
			headDummy = new Node();
		}

		private void add(int idx, int length, E[] list) {
			Node<E> before = headDummy;
			for (int i = 0; i < idx; i++) {
				before = before.next;
			}
			Node<E> after = before.next;

			Node<E> tmp = null;
			for (int i = 0; i < length; i++) {
				tmp = new Node<E>(list[i]);
				before.next = tmp;
				before = tmp;
			}
			tmp.next = after;
		}

		private Node<E> getHead() {
			return headDummy.next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= 10; TC++) {
			sb.append('#').append(TC).append(' ');

			// get input
			LinkedList<Integer> list = new LinkedList<>();
			int initLength = Integer.parseInt(br.readLine());
			Integer[] init = new Integer[initLength];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < initLength; i++) {
				init[i] = Integer.parseInt(st.nextToken());
			}

			// process
			list.add(0, initLength, init);
			br.readLine();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int length = Integer.parseInt(st.nextToken());
				
				Integer[] arr = new Integer[length];
				for (int i = 0; i < length; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				list.add(idx, length, arr);
			}
			
			Node<Integer> head = list.getHead();
			for (int i = 0; i < 10; i++) {
				if(head != null) {
					sb.append(head.value).append(' ');
					head = head.next;
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}