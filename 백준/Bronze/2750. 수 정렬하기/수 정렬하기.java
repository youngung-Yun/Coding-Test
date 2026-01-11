import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // 삽입 정렬로 구현

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            int number = Integer.parseInt(br.readLine());
            array[i] = number;
        }

        for (int i = 1; i < n; ++i) {
            int inserted = array[i];

            int target = i - 1;
            while (target >= 0 && array[target] > inserted) {
                array[target + 1] = array[target];
                --target;
            }
            array[target + 1] = inserted;
        }

        for (int number : array) {
            sb.append(number).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}