import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static Trie ROOT = new Trie();
    final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] directories = bf.readLine().split("\\\\");
            Trie current = ROOT;
            for (String directory : directories) {
                if (!current.trie.containsKey(directory)) {
                    current.trie.put(directory, new Trie());
                }
                current = current.trie.get(directory);
            }
        }

        recursion(ROOT, 0);
        System.out.println(sb);
    }

    private static class Trie {
        public TreeMap<String, Trie> trie;

        public Trie() {
            trie = new TreeMap<>();
        }
    }

    private static void recursion(Trie trie, int depth) {
        for (String key : trie.trie.keySet()) {
            for (int space = 0; space < depth; space++) {
                sb.append(' ');
            }
            sb.append(key).append('\n');
            recursion(trie.trie.get(key), depth + 1);
        }
    }
}
