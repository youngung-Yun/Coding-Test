import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] visitors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = 0;
        for (int i = 0; i < x; i++) {
            total += visitors[i];
        }
        int result = total;
        int count = 1;
        int left = 0;
        int right = x;
        while (right < n) {
            total -= visitors[left];
            ++left;
            total += visitors[right];
            ++right;
            if (result == total) {
                ++count;
            } else if (result < total) {
                result = total;
                count = 1;
            }
        }
        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result);
            System.out.println(count);
        }

    }
}