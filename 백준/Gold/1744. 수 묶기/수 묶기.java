import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(seq);

        // 음수 또는 0 : 본인들끼리 절댓값이 큰 수끼리 묶는게 이득
        // 1 : 안묶는게 이득
        // 나머지: 큰 수끼리 묶는게 이득


        int separator = 0;
        while (separator < n && seq[separator] <= 0) {
            ++separator;
        }

        int ans = 0;

        int negativeIdx = 0;
        while (negativeIdx < separator) {
            // 음수 또는 0은 무조건 절댓값 큰 2개씩 묶는게 이득, 혼자면 묶지 않음
            if (negativeIdx + 1 < separator) {
                ans += (seq[negativeIdx] * seq[negativeIdx + 1]);
                negativeIdx += 2;
            } else {
                ans += seq[negativeIdx];
                ++negativeIdx;
            }
        }

        int positiveIdx = n - 1;
        while (positiveIdx >= separator) {
            // 양수를 혼자 묶는 경우 :
            // 1. 1인 경우
            // 2. seq[idx-1]이 양수가 아닌 경우
            // 3. seq[idx-1]이 1인 경우
            if (seq[positiveIdx] == 1 || positiveIdx - 1 < separator || seq[positiveIdx-1] == 1) {
                ans += seq[positiveIdx];
                --positiveIdx;
            } else {
                ans += (seq[positiveIdx] * seq[positiveIdx - 1]);
                positiveIdx -= 2;
            }
        }

        System.out.println(ans);
    }
}
