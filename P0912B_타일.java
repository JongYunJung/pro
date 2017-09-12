import java.io.FileInputStream;
import java.util.*;
public class Solution {
	static long [] d;

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		d = new long [31];
		d[1] = 1;
		d[2] = 3;
		d[3] = 6;
		for(int i=4; i<=30; i++)
			d[i] = d[i-1]+2*d[i-2]+d[i-3];
		for(int tc=1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			System.out.println("#"+tc+" "+d[N]);
		}
		
	}
}
