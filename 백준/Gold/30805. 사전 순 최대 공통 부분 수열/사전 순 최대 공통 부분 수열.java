import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }

        /*
         1. 두 수열이 모두 가지고 있는 수 중 가장 큰 수 찾음(같으면 앞에 있는 숫자)
         2. 그 숫자의 뒤부터 1번 반복
         */
        List<Integer> seq = new ArrayList<>();
        int startA = 0;
        int startB = 0;
        while (startA < n && startB < m) {
            int max = -1;
            int aIdx = 0;
            int bIdx = 0;
            for (int i = startA; i < a.length; i++) {
                int element = a[i];
                int idx = indexOf(b, element, startB);
                if (idx == -1) {
                    continue;
                }
                if (element > max) {
                    max = element;
                    aIdx = i;
                    bIdx = idx;
                }
            }
            if (max == -1) {
                break;
            }
            seq.add(max);
            startA = aIdx + 1;
            startB = bIdx + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(seq.size()).append('\n');
        for (int e : seq) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }

    private static int indexOf(int[] arr, int value, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}