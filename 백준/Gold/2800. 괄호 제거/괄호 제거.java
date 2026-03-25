import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String baseExpression = bf.readLine();
        /*
         * 1. 짝이 맞는 모든 괄호쌍 찾기
         * 2. 모든 괄호쌍에 대한 부분집합 구함
         * 3. 현재 부분집합에 포함된 괄호쌍은 제거한 새로운 식 만듦
         * 4. 정렬하여 출력
         */
        TreeSet<String> newExpressions = new TreeSet<>();

        List<int[]> pairs = findPairs(baseExpression);
        int n = pairs.size();
        for (int bitmask = 1; bitmask < (0b1 << n); bitmask++) {
            newExpressions.add(removeBracket(baseExpression, pairs, bitmask, n));
        }

        StringBuilder sb = new StringBuilder();
        for (String expression : newExpressions) {
            sb.append(expression).append('\n');
        }
        System.out.println(sb);
    }

    static List<int[]> findPairs(String expression) {
        List<int[]> pairs = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int openIdx = stack.pop();
                pairs.add(new int[] {openIdx, i});
            }
        }
        return pairs;
    }

    static String removeBracket(String expression, List<int[]> pairs, int bitmask, int n) {
        Set<Integer> indices = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if ((bitmask & (0b1 << i)) == 0) {
                continue;
            }
            int[] pair = pairs.get(i);
            indices.add(pair[0]);
            indices.add(pair[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (indices.contains(i)) {
                continue;
            }
            sb.append(expression.charAt(i));
        }
        return sb.toString();
    }
}