#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>

int size;

void dijkstra(int graph[size][size], int src, int to);
int minDistance(int dist[], bool sptSet[]);
void printSolution(int dist[],int parent[],int src, int to);
void printPath(int parent[], int j);

int main()
{
    //kintamieji
    int nuo = 0;
    int iki = 0;
    int x, y;
    int distance;
    FILE *fptr;

    //duomenu failo atidarymas
    if ((fptr = fopen("data.txt", "r")) == NULL)
    {
        printf("Duomenu failo atidaryti nepavyko");
        return 0;
    }

    //PIRMOS EILUTES duomenu skaitymas
    fscanf(fptr, "%d%d%d", &size, &nuo, &iki);
    if(nuo>=size || iki>=size)
    {
        printf("Miestas neegzistuoja");
        return 0;
    }

    //sukuriam tuscia kaimynystes matrica (Adjacency Matrix)
    int matrica[size][size];

    //paruosiam matrica darbui
    for (int i = 0; i < size; i++)
    {
        for(int j = 0; j < size; j++)
        {
            matrica[i][j]=0;
        }
    }

   int file = getc(fptr);

    //kitu eiluciu skaitymas, nustatotme atstumus tarp miestu matricoje
    while(file != EOF)
    {
        fscanf(fptr,"%d%d%d", &x ,&y ,&distance);

        matrica[x][y] = distance;
        matrica[y][x] = distance;

        file = getc(fptr);
    }

    //bye
    fclose(fptr);

    dijkstra(matrica, nuo, iki);

    return 0;
}

void dijkstra(int graph[size][size], int from, int to)
{
    int dist[size];
    bool sptSet[size];
    int parent[size];
    for (int i = 0; i < size; i++)
    {
        parent[from] = -1;
        dist[i] = INT_MAX;
        sptSet[i] = false;
    }

    dist[from] = 0;
    for(int count=0; count < size-1; count++)
    {
        int u = minDistance(dist, sptSet);
        sptSet[u] = true;

        for(int j  =0; j < size; j++)
        {
            if(!sptSet[j] && graph[u][j] !=0 && dist[u] + graph[u][j] < dist[j])
            {
                parent[j] = u;
                dist[j] = dist[u] + graph[u][j];
            }
        }
    }
        printSolution(dist, parent, from, to);
}

int minDistance(int dist[], bool sptSet[])
{
    int min = INT_MAX, min_index;
    for (int i = 0; i < size; i++){
        if(sptSet[i] == false && dist[i] <= min){
                min = dist[i]; min_index = i;
            }
        }

        return min_index;
}

void printSolution(int dist[],int parent[],int from, int to)
{
    if(dist[to] != INT_MAX){

        printf("Keliaujam is %d i %d\n", from, to);
        printf("Atstumas yra %d\n", dist[to]);
        printf("Optimaliausias marsrutas %d", from);
        printPath(parent, to);

    }
    else printf("Toks marsrutas neegzistuoja");
}

void printPath(int parent[], int j)
{
    if (parent[j] == - 1)
        return;

    printPath(parent, parent[j]);
    printf(" -> %d", j);
}
