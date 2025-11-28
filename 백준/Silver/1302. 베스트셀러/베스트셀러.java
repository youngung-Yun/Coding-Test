import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            bookMap.put(title, bookMap.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int max = 0;
        for (String title : bookMap.keySet()) {
            if (max < bookMap.get(title)) {
                maxTitle = title;
                max = bookMap.get(title);
            } else if (max == bookMap.get(title)) {
                if (maxTitle.compareTo(title) > 0) {
                    maxTitle = title;
                    max = bookMap.get(title);
                }
            }
        }
        
        System.out.println(maxTitle);
        br.close();
    }
}