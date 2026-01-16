import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            char name = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            map.put(name, new Node(left, right));
        }

        preOrder(map, 'A', sb);
        sb.append('\n');
        inOrder(map, 'A', sb);
        sb.append('\n');
        postOrder(map, 'A', sb);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void preOrder(Map<Character, Node> map, char name, StringBuilder sb) {
        sb.append(name);

        Node curr = map.get(name);
        if (curr.left != '.') {
            preOrder(map, curr.left, sb);
        }
        if (curr.right != '.') {
            preOrder(map, curr.right, sb);
        }
    }

    private static void inOrder(Map<Character, Node> map, char name, StringBuilder sb) {
        Node curr = map.get(name);
        if (curr.left != '.') {
            inOrder(map, curr.left, sb);
        }
        sb.append(name);
        if (curr.right != '.') {
            inOrder(map, curr.right, sb);
        }
    }

    private static void postOrder(Map<Character, Node> map, char name, StringBuilder sb) {
        Node curr = map.get(name);
        if (curr.left != '.') {
            postOrder(map, curr.left, sb);
        }
        if (curr.right != '.') {
            postOrder(map, curr.right, sb);
        }
        sb.append(name);
    }

    private static class Node {
        public char left;
        public char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}
