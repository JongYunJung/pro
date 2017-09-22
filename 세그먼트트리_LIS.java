import java.io.FileInputStream;
import java.util.*;

public class Solution {

	static int [] id;
	static int [] t; 
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			id = new int [N+1];
			t = new int [1000000];
			
			
			for(int i = 0; i<N; i++)
			{
				int n1 = sc.nextInt();
				id[n1] = i;
				
			}
			int LIS = 0;
	
			for(int i=1; i<=N; i++)
			{
				LIS = findMax(1, id[i], 0, N-1)+1;
				update(1, id[i], LIS, 0, N-1);
			}
			System.out.println("#"+tc+" "+t[1]);
		}

	}
	public static int findMax(int n, int idx, int s, int e)
	{
		if(idx<s)
			return 0;
		else
		{
			if(e<=idx)
				return t[n];
			
			else
			{
				int r1 = findMax(n*2, idx, s, (s+e)/2);
				int r2 = findMax(n*2+1, idx, (s+e)/2+1, e);
				return r1>r2?r1:r2;
			}
		}
	}

	public static void update(int n, int i, int LIS, int s, int e)
	{
		if( i<s || e<i)
			return;
		else
		{
				if(t[n]<LIS)
				{
					t[n] = LIS;
				}
				if(s==e)
				{
					return;
				}
				else if(i<=((s+e)/2))
				{
					update(n*2, i, LIS, s, (s+e)/2);
				}
				else if(((s+e)/2)<i)
				{
					update(n*2+1, i, LIS, (s+e)/2+1, e);
				}
			
		}
	}


}
 
