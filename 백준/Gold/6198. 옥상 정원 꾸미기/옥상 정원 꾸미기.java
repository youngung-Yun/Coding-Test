import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(bf.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0L;
        /*
         * 나의 오른쪽에 있는 나보다 큰 첫 번째 빌딩 위치 찾기
         * 스택에 peek가 나보다 작거나 같으면, 그 빌딩의 첫 번째 빌딩은 나임
         * 스택에서 뺀 후 인덱스 계산하기
         * 스택은 반드시 내림차순이 유지됨
         * 스택에 끝까지 남아있으면 모든 빌딩 확인 가능
         */
        for (int i = 0; i < n; i++) {
            int height = buildings[i];
            while (!stack.isEmpty() && buildings[stack.peek()] <= height) {
                int lower = stack.pop();
                ans += (i - lower) - 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans += (n - 1 - stack.pop());
        }
        System.out.println(ans);
    }
}