import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] DNAs = new String[n];
        for (int i = 0; i < n; i++) {
            DNAs[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int hammingDistance = 0;
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('A', 0);
            map.put('T', 0);
            map.put('G', 0);
            map.put('C', 0);
            for (String DNA : DNAs) {
                map.put(DNA.charAt(i), map.get(DNA.charAt(i)) + 1);
            }
            char[] keys = new char[] {'A', 'C', 'G', 'T'};
            char ch = keys[0];
            for (char key : keys) {
                if (map.get(ch) < map.get(key)) {
                    ch = key;
                }
            }
            hammingDistance += (n - map.get(ch));
            sb.append(ch);
        }
        sb.append('\n').append(hammingDistance);
        System.out.println(sb.toString());
    }
}
