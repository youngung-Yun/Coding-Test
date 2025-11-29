import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int seq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (!map.containsKey(a)) {
            map.put(a, seq);
            seq++;
            a = getNextNumber(a, p);
        }
        System.out.println(map.get(a));
    }

    private static int getNextNumber(int n, int p) {
        String str = String.valueOf(n);
        int sum = 0;
        for (char ch : str.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            sum += (int) Math.pow(digit, p);
        }

        return sum;
    }
}