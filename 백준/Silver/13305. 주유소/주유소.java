import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // 현재 지역 기름 가격 vs 지금까지 들른 지역 주유소 가격 최솟값
        // 현재 지역 기름 가격이 더 싸면 최솟값 갱신
        // 최솟값 * distance 만큼 기름값 소모

        int n = Integer.parseInt(br.readLine());
        long[] distances = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] prices = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long total = prices[0] * distances[0];
        long min = prices[0];

        for (int i = 1; i < distances.length; i++) {
            min = Math.min(min, prices[i]);
            total += min * distances[i];
        }

        System.out.println(total);
    }   
}
