import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static String[] types =
            {"ISTJ", "ISFJ", "INFJ", "INTJ",
            "ISTP", "ISFP", "INFP", "INTP",
            "ESTP", "ESFP", "ENFP", "ENTP",
            "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
    static Map<String, Integer> map = new HashMap<>();

    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            ans = 12;
            initMap();

            int n = Integer.parseInt(bf.readLine());
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                String mbti = stk.nextToken();
                map.put(mbti, map.get(mbti) + 1);
            }

            dfs(new String[3], 0);

            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(String[] arr, int depth) {
        if (depth == 3) {
            int distance = getDistance(arr[0], arr[1]) +
                    getDistance(arr[1], arr[2]) +
                    getDistance(arr[2], arr[0]);
            ans = Integer.min(ans, distance);
            return;
        }

        for (String mbti : types) {
            if (map.get(mbti) == 0) {
                continue;
            }
            arr[depth] = mbti;
            map.put(mbti, map.get(mbti) - 1);
            dfs(arr, depth + 1);
            map.put(mbti, map.get(mbti) + 1);
        }
    }

    private static int getDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++distance;
            }
        }
        return distance;
    }

    private static void initMap() {
        for (String mbti : types) {
            map.put(mbti, 0);
        }
    }
}