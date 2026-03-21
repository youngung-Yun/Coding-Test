import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    final static char b = '#';
    final static char w = '.';
    final static char[] ooo = {b, b, b};
    final static char[] oxx = {b, w, w};
    final static char[] oxo = {b, w, b};
    final static char[] xxo = {w, w, b};
    final static char[] xox = {w, b, w};

    final static char[] [][] segments = {
            {
                ooo,
                oxo,
                oxo,
                oxo,
                ooo
            },
            {
                xox,
                xox,
                xox,
                xox,
                xox
            },
            {
                ooo,
                xxo,
                ooo,
                oxx,
                ooo
            },
            {
                ooo,
                xxo,
                ooo,
                xxo,
                ooo
            },
            {
                oxo,
                oxo,
                ooo,
                xxo,
                xxo,
            },
            {
                ooo,
                oxx,
                ooo,
                xxo,
                ooo
            },
            {
                ooo,
                oxx,
                ooo,
                oxo,
                ooo
            },
            {
                ooo,
                xxo,
                xxo,
                xxo,
                xxo,
            },
            {
                ooo,
                oxo,
                ooo,
                oxo,
                ooo
            },
            {
                ooo,
                oxo,
                ooo,
                xxo,
                ooo
            }
    };

    static char[][] signal;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int col = n / 5;
        signal = new char[5][col+2];
        for (int r = 0; r < 5; r++) {
            signal[r][0] = signal[r][col+1] = '.';
        }

        String input = bf.readLine();
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < col; c++) {
                signal[r][c+1] = input.charAt(r*col+c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (c <= col - 1) {
            for (int digit = 0; digit < 10; digit++) {
                if (isMatch(c, segments[digit])) {
                    sb.append(digit);
                    break;
                }
            }
            ++c;
        }
        System.out.println(sb);
    }

    static boolean isMatch(int col, char[][] segment) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 3; c++) {
                if (segment[r][c] != signal[r][c+col]) {
                    return false;
                }
            }
        }
        return true;
    }
}