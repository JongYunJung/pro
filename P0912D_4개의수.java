import java.io.FileInputStream;
import java.util.*;
public class Solution {
	static int [] d;
	static int [] a;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			a = new int [4];
			for(int i=0;i<4;i++)
			{
				a[i]= sc.nextInt();
			}
			d = new int [a[3]+1];
			find();
			System.out.println("#"+tc+" "+d[a[3]]);
		}
	}
	public static void find()
	{

		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= a[3]; i++)
		{
			d[i] += d[i-1];
			if (i >= a[1])
				d[i] += d[i - a[1]];
			if (i >= a[2])
				d[i] += d[i - a[2]];
		}
	}
}
