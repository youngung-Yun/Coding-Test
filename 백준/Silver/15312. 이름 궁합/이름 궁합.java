import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    final static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String a = bf.readLine();
        String b = bf.readLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            list.add(count[a.charAt(i) - 'A']);
            list.add(count[b.charAt(i) - 'A']);
        }

        while (list.size() > 2) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                newList.add((list.get(i-1) + list.get(i)) % 10);
            }
            list = newList;
        }

        System.out.println("" + list.get(0) + list.get(1));
    }
}