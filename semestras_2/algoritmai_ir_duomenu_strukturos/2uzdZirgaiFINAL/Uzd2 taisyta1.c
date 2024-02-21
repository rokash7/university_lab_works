e#include<stdio.h>
#include <stdlib.h>

int solve(int n, int **lenta);
int solveUtil(int x, int y, int movei, int **lenta, int xMove[8], int yMove[8], int n);
void print(int **lenta, int n);
int isSafe(int x, int y, int **lenta, int n);

int main()
{
    int n=0;
    printf("iveskite kvadrato dydi: ");
    scanf("%d", &n);

    int **lenta = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++)
    {
        lenta[i] = (int *)malloc(n * sizeof(int));
    }

	solve(n, lenta);

	for(int i = 0; i < n; i++)
    {
        free(lenta[i]);
	}
	free(lenta);
	return 0;
}

int solve(int n, int **lenta)
{

    //sukuriam lenta/matrica
    for (int x = 0; x < n; x++)
    {
        for (int y = 0; y < n; y++)
        {
            lenta[x][y] = -1;
        }
    }

    //xMove[] ir yMove[] apibrezia galimus zirgo judesius-
    int xMove[8] = {  2, 1, -1, -2, -2, -1,  1,  2 };
    int yMove[8] = {  1, 2,  2,  1, -1, -2, -2, -1 };

    //pradine busena
    lenta[0][0] = 0;

    if (solveUtil(0, 0, 1, lenta, xMove, yMove, n)==0){ //iejimas i backtrackinancia funkcija, jei ji grazina 0, sprendimas nerastas
        printf("Sprendimas nerastas\n");
        return 0;
    }
    else{ //jei grazinamas ne 0, sprendimas rastas ir spausdinamas
        print(lenta, n);
    }

    return 1;
}

int solveUtil(int x, int y, int movei, int **lenta, int *xMove, int *yMove, int n)
{
    int k, next_x, next_y;
    if (movei == n * n)
    {
        return 1;
    }


    for (k=0; k < n; k++){
        next_x = x + xMove[k];
        next_y = y + yMove[k];

        if(isSafe(next_x, next_y, lenta, n)){
        lenta[next_x][next_y] = movei;
            if (solveUtil(next_x, next_y, movei + 1, lenta, xMove, yMove, n) == 1)
            {
                return 1;
            }

            else
            {
            lenta[next_x][next_y] = -1;// backtracking
            }
        }
   }

   return 0;
}

void print(int **lenta, int n)
{
    for (int x = 0; x < n; x++)
    {
        for (int y = 0; y < n; y++)
            printf(" %2d ", lenta[x][y]);
        printf("\n");
    }
}

int isSafe(int x, int y, int **lenta, int n)
{ //patikrina, ar arklio ejimas neiseina is lentos
    return ( x >= 0 && x < n && y >= 0 && y < n && lenta[x][y]==-1);
}
