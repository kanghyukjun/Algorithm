import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Meeting {
		int start;
		int end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// process
		Arrays.sort(meetings, (m1, m2) -> {
			if (m1.end == m2.end)
				return m1.start - m2.start;
			return m1.end - m2.end;
		});
		
		int endTime = -1;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(meetings[i].start >= endTime) {
				count++;
				endTime = meetings[i].end;
			}
		}
		
		// output
		System.out.println(count);
	}

}