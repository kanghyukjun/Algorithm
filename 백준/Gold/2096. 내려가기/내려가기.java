import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 입력 값인 N을 가져옵니다.
        int N = Integer.parseInt(br.readLine());
        
        // 최대 합과 최소 합을 계산하기 위한 배열을 초기화합니다.
        int[] maxSum = new int[3];
        int[] minSum = new int[3];
        
        for (int i = 0; i < N; i++) {
            // 각 라인의 입력을 받아서 배열로 변환합니다.
            String[] input = br.readLine().split(" ");
            int[] arr1 = new int[3];
            int[] arr2 = new int[3];
            
            // 문자열을 정수로 변환
            for (int j = 0; j < 3; j++) {
                arr1[j] = Integer.parseInt(input[j]);
                arr2[j] = arr1[j];
            }
            
            // maxSum 업데이트
            arr1[0] += Math.max(maxSum[0], maxSum[1]);
            arr1[1] += Math.max(maxSum[0], Math.max(maxSum[1], maxSum[2]));
            arr1[2] += Math.max(maxSum[1], maxSum[2]);
            maxSum = arr1;
            
            // minSum 업데이트
            arr2[0] += Math.min(minSum[0], minSum[1]);
            arr2[1] += Math.min(minSum[0], Math.min(minSum[1], minSum[2]));
            arr2[2] += Math.min(minSum[1], minSum[2]);
            minSum = arr2;
        }

        // 결과 출력
        System.out.println(Math.max(maxSum[0], Math.max(maxSum[1], maxSum[2])) + " " + Math.min(minSum[0], Math.min(minSum[1], minSum[2])));
    }
}