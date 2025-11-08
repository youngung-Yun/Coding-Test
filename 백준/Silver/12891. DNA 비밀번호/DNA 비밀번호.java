import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        // init
        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> criteriaMap = new HashMap<>();
        criteriaMap.put('A', Integer.parseInt(st.nextToken()));
        criteriaMap.put('C', Integer.parseInt(st.nextToken()));
        criteriaMap.put('G', Integer.parseInt(st.nextToken()));
        criteriaMap.put('T', Integer.parseInt(st.nextToken()));

        Map<Character, Integer> currentMap = new HashMap<>();
        currentMap.put('A', 0);
        currentMap.put('C', 0);
        currentMap.put('G', 0);
        currentMap.put('T', 0);

        int count = 0;

        for (int i = 0; i < p; i++) {
            char ch = dna.charAt(i);
            currentMap.put(ch, currentMap.get(ch) + 1);
        }

        if (isValid(criteriaMap, currentMap)) {
            ++count;
        }

        for (int i = 0; i < s - p; i++) {
            char out = dna.charAt(i);
            currentMap.put(out, currentMap.get(out) - 1);
            char in = dna.charAt(i + p);
            currentMap.put(in, currentMap.get(in) + 1);

            if (isValid(criteriaMap, currentMap)) {
                ++count;
            }
        }

        System.out.println(count);
    }

    private static boolean isValid(Map<Character, Integer> criteria, Map<Character, Integer> current) {
        for (char ch : criteria.keySet()) {
            if (criteria.get(ch) > current.get(ch)) {
                return false;
            }
        }
        return true;
    }
}