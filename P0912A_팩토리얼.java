import java.io.FileInputStream;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			long fact = 1;
			for(int i = 2; i<= N; i++)
			{
				fact = i*fact%D;
			}
			System.out.println("#"+tc+" "+fact);
		}

	}

}
