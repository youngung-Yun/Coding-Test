import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < list.get(0).length(); i++) {
            char ch = list.get(0).charAt(i);
            boolean isSame = true;
            for (int j = 0; j < list.size(); j++) {
                if (ch != list.get(j).charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            sb.append(isSame ? ch : '?');
        }
        System.out.println(sb.toString());
    }
}