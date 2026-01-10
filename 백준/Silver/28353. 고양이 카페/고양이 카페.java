import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cats = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0;
        int right = n - 1;
        int answer = 0;
        while (left < right) {
            int leftCat = cats[left];
            int rightCat = cats[right];
            if (leftCat + rightCat > k) {
                --right;
            } else {
                ++answer;
                --right;
                ++left;
            }
        }
        System.out.println(answer);
    }
}