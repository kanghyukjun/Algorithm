import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int sum;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		sum = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			if (arr[i][0] == 1) {
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
		}

		// process
		Stack<Integer> stk = new Stack<>();
		int currentWork = -1;
		for (int time = 1; time <= N; time++) {
			
			// 현재 시간대에 업무가 없을 때
			// 원래 하고 있던 업무를 수행
			if(arr[time][0] == 0) {
				if(currentWork == -1) {
					continue;
				}
				arr[currentWork][2]--;
				if(arr[currentWork][2] == 0) {
					sum += arr[currentWork][1];
					currentWork = stk.pop();
				}
				
			}
			
			// 현재 시간대에 새로운 업무가 있을 때
			// 원래 하고 있던 업무를 스택에 넣고 새로운 업무를 수행
			else {
				stk.push(currentWork);
				currentWork = time;
				arr[currentWork][2]--;
				if(arr[currentWork][2] == 0) {
					sum += arr[currentWork][1];
					currentWork = stk.pop();
				}
			}
		}

		// output
		System.out.println(sum);
	}


}