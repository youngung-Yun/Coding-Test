import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 같은 패를 5장 이상 냈을 때 이변을 눈치챔.
        // 그 패를 처음 내기 이전 패들은 기억할 필요가 없음.
        Map<String, List<Integer>> mahjong = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        String[] tiles = br.readLine().split(" ");
        int result = -1;
        for (int i = 0; i < n; i++) {
            String tile = tiles[i];
            if (!mahjong.containsKey(tile)) {
                mahjong.put(tile, new ArrayList<>());
            }
            mahjong.get(tile).add(i);
            if (mahjong.get(tile).size() >= 5) {
                int last = mahjong.get(tile).size() - 1;
                int memory = mahjong.get(tile).get(last) - mahjong.get(tile).get(last - 4) + 1;
                if (result == -1) {
                    result = memory;
                } else {
                    result = Integer.min(result, memory);
                }
            }
        }
        System.out.println(result);
    }
}