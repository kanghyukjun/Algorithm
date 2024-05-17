import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Person {
		int weight;
		int height;
		int count;

		public Person(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
			this.count = 0;
		}

		public boolean isSmallerThan(Person p) {
			return this.weight < p.weight && this.height < p.height;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		Person[] people = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// process
		// 키와 몸무게 둘 다 클 때 덩치가 더 크다고 말을 할 수 있다
		// 자신보다 더 큰 덩치의 사람이 k명이면 그 사람의 덩치 등수는 k+1이 된다
		for (Person person : people) {
			for (Person opposite : people) {
				if (person.isSmallerThan(opposite))
					person.count++;
			}
		}

		// output
		for (Person person : people) {
			sb.append(person.count + 1).append(' ');
		}
		System.out.println(sb);
	}

}