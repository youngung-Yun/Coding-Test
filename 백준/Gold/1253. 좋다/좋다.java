import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int current = list[i];
            int l = 0;
            int r = n - 1;
            while (l < r) {
                if (l == i) {
                    ++l;
                    continue;
                }
                if (r == i) {
                    --r;
                    continue;
                }

                int sum = list[l] + list[r];
                if (sum == current) {
                    ++count;
                    break;
                } else if (sum < current) {
                    ++l;
                } else {
                    --r;
                }
            }
        }

        System.out.println(count);
    }
}