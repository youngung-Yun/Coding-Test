import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int counts[] = new int[100_001];
        int result = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            int rightElement = array[right];
            ++counts[rightElement];
            ++right;
            // element를 추가 했을 때 개수가 초과되면, left에서 element가 나올 때까지 크기를 줄여야 함
            while (counts[rightElement] > k) {
                int leftElement = array[left];
                --counts[leftElement];
                ++left;
            }
            result = Integer.max(result, right - left);
        }
        System.out.println(result);
    }
}