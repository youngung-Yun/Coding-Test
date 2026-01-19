import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.BrokenBarrierException;

public class Solution
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; ++testCase) {
			int currentSecond = timeToSecond(br.readLine());
			int appointmentSecond = timeToSecond(br.readLine());
			if (currentSecond > appointmentSecond) {
				appointmentSecond += (24 * 60 * 60);
			}
			
			int secondDiff = Math.abs(currentSecond - appointmentSecond);
			
			sb.append('#').append(testCase).append(' ').append(secondToTime(secondDiff)).append('\n');
		}
		System.out.println(sb);
	}
	
	static int timeToSecond(String timeFormat) {
		int hour = Integer.parseInt(timeFormat.substring(0, 2));
		int minute = Integer.parseInt(timeFormat.substring(3, 5));
		int second = Integer.parseInt(timeFormat.substring(6, 8));

		return second + (minute * 60) + (hour * 60 * 60);
	}
	
	static String secondToTime(int time) {
		int second = time % 60;
		time /= 60;
		int minute = time % 60;
		time /= 60;
		int hour = time % 60;
		
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}