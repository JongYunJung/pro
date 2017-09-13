#include <stdio.h>

int N, M;

int t[1001][1001];
int d[1001][1001];
void find(void);
int main(void)
{
	freopen("Text.txt", "r", stdin);
	scanf("%d %d", &N, &M);

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			scanf("%d", &t[i][j]); 
		}
		
	}
	find();
	printf("%d\n", d[N][M]);
}

void find(void)
{
	// 첫줄은 왼쪽에서만..
	for (int j = 1; j <= M; j++)
	{
		d[1][j] = d[1][j - 1] + t[1][j];
	}
	// 둘째줄 부터는 모든 가능 경로 중 최대..
	for (int i = 2; i <= N; i++)
	{
		// 윗줄에서 오는 경우의 [i-1][j]에서 내려와서 [i][j]까지 올때의 비용 비교..
		// left, right를 배열로 처리해 중복을 좀 줄입시다...
		for (int j = 1; j <= M; j++)
		{
			int left = 0x80000000;
			for (int k = 1; k<j; k++)
			{
				left = (d[i - 1][k] > left ? d[i - 1][k] : left) + t[i][k];
			}
			int right = 0x80000000;
			for (int k = M; k > j; k--)
			{
				right = (d[i - 1][k] > right ? d[i - 1][k] : right) + t[i][k];
			}
			int tmp = (left > right ? left : right);
			d[i][j] = (tmp > d[i - 1][j] ? tmp : d[i - 1][j]) + t[i][j];
		}
	}
	// 마지막 줄도 왼쪽에서만..
	/*if (N >= 2)
	{
		for (int j = 1; j <= M; j++)
		{
			int left = 0x80000000;
			for (int k = 1; k < j; k++)
			{
				left = (d[N - 1][k] > left ? d[N - 1][k] : left) + t[N][k];
			}
			d[N][j] = (left > d[N - 1][j] ? left : d[N - 1][j]) + t[N][j];
		}
	}*/
}
