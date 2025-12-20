import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ordered = new int[n];
        Arrays.fill(ordered, -1);

        dfs(array, ordered, 0, n);
    }

    private static void dfs(int[] array, int[] ordered, int number, int n) {
        if (number == n) {
            StringBuilder sb = new StringBuilder();
            for (int i : ordered) {
                sb.append(i).append(' ');
            }
            System.out.println(sb.toString());
            return;
        }

        int biggerCount = array[number];
        int currentCount = 0;
        int currentIdx = 0;
        // 반드시 내 앞에 biggerCount 만큼의 -1(나보다 큰 수가 들어갈 자리)가 있어야 함
        while (currentCount < biggerCount) {
            if (ordered[currentIdx] == -1) {
                ++currentCount;
            }
            ++currentIdx;
        }
        // 비어있는 자리가 나올 때까지 뒤로
        while (ordered[currentIdx] != -1) {
            ++currentIdx;
        }
        ordered[currentIdx] = number + 1;
        dfs(array, ordered, number + 1, n);
        ordered[currentIdx] = -1;
    }
}