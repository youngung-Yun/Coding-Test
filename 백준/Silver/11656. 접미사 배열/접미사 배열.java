import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        List<String> words = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            words.add(word.substring(i));
        }

        words.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        words.forEach(w -> sb.append(w).append('\n'));

        System.out.println(sb.toString());
        br.close();
    }
}