import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class SegmentTree {
		private long[] tree;
		private long[] arr;
		private int treeSize;

		public SegmentTree(long[] a) {
			this.arr = a;
			int height = (int) Math.ceil((Math.log(a.length) / Math.log(2)));
			this.treeSize = (int) Math.pow(2, height + 1);
			tree = new long[this.treeSize];

			init(a, 1, 0, arr.length - 1);
		}

		private void init(long[] a, int node, int start, int end) {
			if (start == end) {
				tree[node] = a[start];
			} else {
				init(a, node * 2, start, (start + end) / 2);
				init(a, node * 2 + 1, (start + end) / 2 + 1, end);
				tree[node] = tree[node * 2] + tree[node * 2 + 1];
			}
		}

		public long sum(int left, int right) {
			return getSum(1, 0, arr.length - 1, left, right);
		}

		// left : 구하고 싶은 구간의 맨 왼쪽
		// right : 구하고 싶은 구간의 맨 오른쪽
		// start : 현재 노드의 왼쪽 구간
		// end : 현재 노드의 오른쪽 구간
		private long getSum(int node, int start, int end, int left, int right) {
			if (right < start || left > end) {
				return 0;
			}

			if (left <= start && end <= right) {
				return tree[node];
			}

			long lSum = getSum(node * 2, start, (start + end) / 2, left, right);
			long rSum = getSum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			return lSum + rSum;
		}

		public void update(int idx, long value) {
			updateValue(1, 0, arr.length - 1, idx, value - arr[idx]);
			arr[idx] = value;
		}

		private void updateValue(int node, int start, int end, int idx, long diff) {
			if (start <= idx && idx <= end) {
				tree[node] += diff;
				
				if (start != end) {
					updateValue(node * 2, start, (start + end) / 2, idx, diff);
					updateValue(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int change = Integer.parseInt(st.nextToken());
		int getSum = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		SegmentTree segTree = new SegmentTree(arr);

		// process
		for (int i = 0; i < change + getSum; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());

			// change
			if (order == 1) {
				int idx = Integer.parseInt(st.nextToken());
				long newValue = Long.parseLong(st.nextToken());
				segTree.update(idx - 1, newValue);
			}

			// get Sum
			else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(segTree.sum(left - 1, right - 1)).append('\n');
			}
		}

		// output
		System.out.println(sb);
	}

}