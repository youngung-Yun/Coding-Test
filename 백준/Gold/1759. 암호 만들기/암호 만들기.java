import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {

	private static Set<Character> set = new HashSet<>();
	private static List<String> result = new ArrayList<>();

	public static void main(String args[]) throws Exception {
		/*
		 * 1. 가능한 문자들 배열 정렬
		 * 2. 가능한 조합 구함
		 * 3. 자음 모음 개수 세서 가능하면 저장
		 */

		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int l = Integer.parseInt(input[0]); // 암호 길이
		int c = Integer.parseInt(input[1]); // 문자 개수
		String[] inputs = br.readLine().split(" ");

		char[] alphabets = new char[c];
		for (int i = 0; i < c; i++) {
			alphabets[i] = inputs[i].charAt(0);
		}
		Arrays.sort(alphabets);

		char[] password = new char[l];

		recursion(0, alphabets, c, password, l, 0);

		result.stream().forEach(p -> System.out.println(p));
	}

	static void recursion(int seq, char[] alphabets, int c, char[] password, int l, int curr) {
		if (seq == l) {
			int consonant = 0;
			int vowel = 0;
			for (char ch : password) {
				if (set.contains(ch)) {
					++vowel;
				} else {
					++consonant;
				}
			}

			if (consonant >= 2 && vowel >= 1) {
				StringBuilder sb = new StringBuilder();
				for (char ch : password) {
					sb.append(ch);
				}
				result.add(sb.toString());
			}
			return;
		}

		for (int i = curr; i < c; i++) {
			password[seq] = alphabets[i];
			recursion(seq + 1, alphabets, c, password, l, i + 1);
		}
	}
}