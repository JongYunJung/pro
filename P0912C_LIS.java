import java.io.FileInputStream;
import java.util.*;
public class Solution {
	static int [] d;
	static int [] a;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			d = new int [N];
			a = new int [N];
			int max = 1;
			for(int i = 0; i<N; i++)
			{
				a[i] = sc.nextInt();
				d[i] = 1;
			}
			for(int i = 1; i<N; i++)
			{
				for(int j = 0; j<i; j++)
				{
					if(a[j]<a[i] && (d[j]+1)>d[i])
					{
						d[i] = d[j] + 1;
						if( max <d[i])
							max = d[i];
					}
				}
			}
			System.out.println("#"+tc +" "+max);
		}
	}
}
