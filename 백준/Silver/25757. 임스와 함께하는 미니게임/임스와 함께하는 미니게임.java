import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        char game = stk.nextToken().charAt(0);
        int needPlayer = 0;
        if (game == 'Y') {
            needPlayer = 1;
        } else if (game == 'F') {
            needPlayer = 2;
        } else if (game == 'O') {
            needPlayer = 3;
        }

        Set<String> player = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String nickname = bf.readLine();
            player.add(nickname);
        }

        System.out.println(player.size() / needPlayer);
    }
}