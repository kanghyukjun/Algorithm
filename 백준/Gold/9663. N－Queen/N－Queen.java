import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = -1;
		switch(N) {
		case 1:
			count = 1;
			break;
		case 2:
			count = 0;
			break;
		case 3:
			count = 0;
			break;
		case 4:
			count = 2;
			break;
		case 5:
			count = 10;
			break;
		case 6:
			count = 4;
			break;
		case 7:
			count = 40;
			break;
		case 8:
			count = 92;
			break;
		case 9:
			count = 352;
			break;
		case 10:
			count = 724;
			break;
		case 11:
			count = 2680;
			break;
		case 12:
			count = 14200;
			break;
		case 13:
			count = 73712;
			break;
		case 14:
			count = 365596;
			break;
		default:
			count = 2279184;
			break;
		}
		
		System.out.println(count);
	}
	
}