import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        Map<String, Boolean> map = new HashMap<>();

        for (String n : A) {
            map.put(n, true);
        }
        for (String n : B) {
            if (map.containsKey(n)) {
                map.remove(n);
            }
            else {
                map.put(n, true);
            }
        }


        int answer = map.size();
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}