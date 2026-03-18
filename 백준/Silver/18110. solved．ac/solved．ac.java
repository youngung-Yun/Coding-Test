import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
		}
		list.sort((a,b)->a-b);
		int firstIndex=0;
		int lastIndex=n-1;
		
		double del = n*0.3;
		del = Math.round(del/2);
		
		firstIndex += del;
		lastIndex -=del;
		
		double total=0;
		for(int i=firstIndex; i<=lastIndex;i++) {
			total+= list.get(i);
		}
		
		total= Math.round(total/(n-(del*2)));
		
		System.out.println((int)total);
		
	}
	

}
