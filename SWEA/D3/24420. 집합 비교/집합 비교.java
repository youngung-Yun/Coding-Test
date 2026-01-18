import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Set<Integer> setA = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                setA.add(Integer.parseInt(st.nextToken()));
            }
            Set<Integer> setB = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                setB.add(Integer.parseInt(st.nextToken()));
            }
            Set<Integer> intersectionA = new HashSet<>(setA);
            intersectionA.retainAll(setB);
            Set<Integer> intersectionB = new HashSet<>(setB);
            intersectionB.retainAll(setA);

            char operator;
            if (setA.size() == intersectionA.size() && setB.size() == intersectionB.size()) {
                operator = '=';
            } else if (setA.size() == intersectionA.size()) {
                operator = '<';
            } else if (setB.size() == intersectionB.size()) {
                operator = '>';
            } else {
                operator = '?';
            }

            sb.append(operator).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}