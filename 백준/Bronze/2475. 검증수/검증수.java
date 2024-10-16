import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String[] numbers = input.split(" ");
        
        int result = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .map(n -> n * n)
                .sum() % 10;
        
        System.out.println(result);
    }
}