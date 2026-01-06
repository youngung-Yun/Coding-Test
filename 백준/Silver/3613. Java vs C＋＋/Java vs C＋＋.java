import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String variableName = br.readLine();
        boolean withUnderscore = variableName.indexOf('_') != -1;
        boolean withCapital = false;
        for (char ch : variableName.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                withCapital = true;
                break;
            }
        }
        boolean isStartWithCapital = Character.isUpperCase(variableName.charAt(0));
        boolean isStartWithUnderscore = variableName.charAt(0) == '_';
        boolean isEndWithUnderscore = variableName.charAt(variableName.length() - 1) == '_';
        boolean WithoutCotinuousUnderscore = true;
        for (int i = 1; i < variableName.length(); i++) {
            if (variableName.charAt(i - 1) == '_' && variableName.charAt(i) == '_') {
                WithoutCotinuousUnderscore = false;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isStartWithUnderscore || isEndWithUnderscore || !WithoutCotinuousUnderscore) {
            sb.append("Error!");
        } else if (!withUnderscore && !isStartWithCapital) {
            for (char ch : variableName.toCharArray()) {
                // Java to C++
                if (Character.isUpperCase(ch)) {
                    sb.append('_');
                    sb.append(Character.toLowerCase(ch));
                } else {
                    sb.append(ch);
                }
            }
        } else if (withUnderscore && !withCapital) {
            boolean isCapital = false;
            for (char ch : variableName.toCharArray()) {
                // C++ to Java
                if (ch == '_') {
                    isCapital = true;
                    continue;
                }
                if (isCapital) {
                    sb.append(Character.toUpperCase(ch));
                    isCapital = false;
                } else {
                    sb.append(ch);
                }
            }
        } else {
            sb.append("Error!");
        }
        System.out.println(sb);
    }
}