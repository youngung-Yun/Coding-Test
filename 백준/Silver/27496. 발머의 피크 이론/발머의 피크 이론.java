import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] alcohol = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < l) {
                total += alcohol[i];
            }
            else {
                total += alcohol[i];
                total -= alcohol[i-l];
            }
            if (total >= 129 && total <= 138) {
                ++count;
            }
        }
        System.out.println(count);
    }
}