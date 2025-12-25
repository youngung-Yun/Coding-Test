import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Node head = new Node(' ');
        Node prev = head;
        for (char ch : word.toCharArray()) {
            Node newNode = new Node(ch);
            prev.next = newNode;
            newNode.prev = prev;
            prev = newNode;
        }
        int n = Integer.parseInt(br.readLine());
        Node cursor = prev;
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("L")) {
                if (cursor.ch != ' ') {
                    cursor = cursor.prev;
                }
            } else if (command[0].equals("D")) {
                if (cursor.next != null) {
                    cursor = cursor.next;
                }
            } else if (command[0].equals("B")) {
                if (cursor.ch != ' ') {
                    cursor.prev.next = cursor.next;
                    if (cursor.next != null) {
                        cursor.next.prev = cursor.prev;
                    }
                    cursor = cursor.prev;
                }
            } else {
                Node newNode = new Node(command[1].charAt(0));
                newNode.next = cursor.next;
                if (cursor.next != null) {
                    cursor.next.prev = newNode;
                }
                newNode.prev = cursor;
                cursor.next = newNode;
                cursor = newNode;
            }
        }
        StringBuilder sb = new StringBuilder();
        Node iter = head.next;
        while (iter != null) {
            sb.append(iter.ch);
            iter = iter.next;
        }
        System.out.println(sb.toString());
    }

    private static class Node {
        public char ch;
        public Node next;
        public Node prev;

        public Node(char ch) {
            this.ch = ch;
        }
    }
}
