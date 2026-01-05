import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] straws = new int[n];
        for (int i = 0; i < n; i++) {
            straws[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(straws);
        int max = -1;
        // 삼각형은 가장 긴 변의 길이가 다른 두 변의 길이의 합보다 작음
        for (int i = n - 1; i >= 2; i--) {
            if (straws[i-1] + straws[i-2] > straws[i]) {
                max = straws[i-2] + straws[i-1] + straws[i];
                break;
            }
        }
        System.out.println(max);
    }
}
