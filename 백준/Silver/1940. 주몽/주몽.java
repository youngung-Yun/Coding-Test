import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int count = 0;

        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = list[l] + list[r];
            if (sum == m) { // 갑옷 완성
                ++count;
                ++l;
                --r;
            } else if (sum > m) {
                --r;
            } else {
                ++l;
            }
        }

        System.out.println(count);
    }
}