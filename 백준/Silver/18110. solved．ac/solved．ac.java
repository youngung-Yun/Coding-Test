import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] counts = new int[31];

        for (int i = 0; i < n; i++) {
            int difficulty = Integer.parseInt(br.readLine());
            ++counts[difficulty];
        }

        int trimmedMean = (int) Math.round(n * 0.15);
        int left = trimmedMean;
        int right = trimmedMean;
        int leftIndex = 1;
        int rightIndex = 30;
        
        while (left > 0) {
            if (counts[leftIndex] >= left) {
                counts[leftIndex] -= left;
                left = 0;
            }
            else {
                left -= counts[leftIndex];
                counts[leftIndex] = 0;
                ++leftIndex;
            }
        }

        while (right > 0) {
            if (counts[rightIndex] >= right) {
                counts[rightIndex] -= right;
                right = 0;
            }
            else {
                right -= counts[rightIndex];
                counts[rightIndex] = 0;
                --rightIndex;
            }
        }

        int total = 0;
        for (int i = 1; i < counts.length; i++) {
            total += i * counts[i];
        }

        long answer = Math.round(total * 1.0 / (n - 2 * trimmedMean));

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}