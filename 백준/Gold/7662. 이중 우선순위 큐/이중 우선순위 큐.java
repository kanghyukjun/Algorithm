import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			// get input
			// 1. 데이터 삽입 연산
			// 2. 데이터 삭제 연산
			// 2-1. 우선순위가 가장 높은 데이터를 삭제
			// 2-2. 우선순위가 가장 낮은 데이터를 삭제

			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			Map<Integer, Integer> minHeapDeleted = new HashMap<>();
//			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			Map<Integer, Integer> maxHeapDeleted = new HashMap<>();

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String oper = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if ("I".equals(oper)) {
					// 값 삽입
					minHeap.add(num);
					maxHeap.add(num);
				} else {
					// 값 삭제를 할 때 다른 우선순위 큐에도 반영이 되어야 함
					// 각 큐마다 삭제가 될 때 그것에 대한 값을 기록해둔다
					// 만약 다른 큐에서 값을 뽑아서 삭제를 하려고 할 때
					// 다른 큐에 그 값에 대한 횟수가 기록되어 있으면
					// 기록된 숫자가 없을 때까지 값 삭제를 반복한다

					if (num == 1) {
						// 최댓값 삭제
						Integer max = getNext(maxHeap, minHeapDeleted);
						if (max == null)
							continue;

						if (maxHeapDeleted.containsKey(max)) {
							int deleteCount = maxHeapDeleted.get(max);
							maxHeapDeleted.replace(max, deleteCount + 1);
						} else {
							maxHeapDeleted.put(max, 1);
						}
					} else {
						// 최솟값 삭제
						Integer min = getNext(minHeap, maxHeapDeleted);
						if (min == null)
							continue;

						if (minHeapDeleted.containsKey(min)) {
							int deleteCount = minHeapDeleted.get(min);
							minHeapDeleted.replace(min, deleteCount + 1);
						} else {
							minHeapDeleted.put(min, 1);
						}
					}
				}
			}
			// output
			// 최댓값
			Integer max = getNext(maxHeap, minHeapDeleted);
			if (max == null) {
				sb.append("EMPTY").append('\n');
				continue;
			} else {
				sb.append(max).append(' ');
			}

			// 최솟값
			Integer min = getNext(minHeap, maxHeapDeleted);
			sb.append(min).append('\n');
		}
		System.out.println(sb);
	}

	public static Integer getNext(PriorityQueue<Integer> heap, Map<Integer, Integer> heapDeleted) {
		if (heap.isEmpty())
			return null;

		int poll = heap.poll();
		while (heapDeleted.containsKey(poll)) {
			int deleteCount = heapDeleted.get(poll);
			if (deleteCount - 1 > 0)
				heapDeleted.replace(poll, deleteCount - 1);
			else
				heapDeleted.remove(poll);

			if (heap.isEmpty())
				return null;
			poll = heap.poll();
		}
		return poll;
	}

}