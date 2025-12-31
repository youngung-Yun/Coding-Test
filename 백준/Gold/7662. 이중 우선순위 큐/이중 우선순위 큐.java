import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntUnaryOperator;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                String[] command = br.readLine().split(" ");
                if (command[0].equals("I")) {
                    int n = Integer.parseInt(command[1]);
                    treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                } else {
                    if (treeMap.size() == 0) {
                        continue;
                    }
                    int key;
                    // 최댓값 삭제
                    if (command[1].equals("1")) {
                        key = treeMap.lastKey();
                    } else {
                        // 최솟값 삭제
                        key = treeMap.firstKey();
                    }
                    if (treeMap.get(key) == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, treeMap.get(key) - 1);
                    }
                }
            }
            if (treeMap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

