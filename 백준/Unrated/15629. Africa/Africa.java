import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<String> countries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            countries.add(bf.readLine());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            String country = countries.get(i);
            if (country.equals("botswana")) {
                ans += 0;
            } else if (country.equals("ethiopia")) {
                ans += 50;
            } else if (country.equals("kenya")) {
                ans += 50;
            } else if (country.equals("namibia")) {
                int southAfrica = countries.indexOf("south-africa");
                if (southAfrica != -1 && southAfrica < i) {
                    ans += 40;
                } else {
                    ans += 140;
                }
            } else if (country.equals("south-africa")) {
                ans += 0;
            } else if (country.equals("tanzania")) {
                ans += 50;
            } else if (country.equals("zambia")) {
                if (i >= 1 && countries.get(i - 1).equals("zimbabwe")) {
                    ans += 50;
                } else if (i + 1 < n && countries.get(i + 1).equals("zimbabwe")) {
                    continue;
                } else {
                    ans += 50;
                }
            } else if (country.equals("zimbabwe")) {
                if (i >= 1 && countries.get(i - 1).equals("zambia")) {
                    ans += 50;
                } else if (i + 1 < n && countries.get(i + 1).equals("zambia")) {
                    continue;
                } else {
                    ans += 30;
                }
            }
        }

        System.out.println(ans);
    }
}
