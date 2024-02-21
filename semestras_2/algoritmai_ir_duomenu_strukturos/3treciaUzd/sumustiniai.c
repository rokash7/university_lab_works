#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>
#include "eile.h"
#include "list.c"
#include "stekas.h"
#include "stekas.c"

int main()
{
    Stekas *laikiklis1 = NULL;
    Stekas *laikiklis2 = NULL;

    Queue *q1 = (Queue *)malloc(sizeof(Queue));
    Queue *q2 = (Queue *)malloc(sizeof(Queue));
    Queue *q3 = (Queue *)malloc(sizeof(Queue));

    double kaina = 0;
    double pelnas = 0;

    double nuostoliai1 = 0;
    double nuostoliai2 = 0;
    double nuostoliai3 = 0;

    int tikimybe;
    int kiekis;
    int periodiskumas;
    int ismetamasH;
    int darbasMin;
    int darbasH;
    int t=0;
    int sumustiniuSK1 = 0;
    int sumustiniuSK2 = 0;
    int likeSumustiniai = 0;

    //srand(time(0));

    printf("Kokia tikimybe, kad klientas sumustini pirks? ");
    scanf("%d", &tikimybe);

    printf("Koks yra patiekiamu sumusitniu kiekis? ");
    scanf("%d", &kiekis);

    printf("Koks yra patiekiamu sumustiniu periodiskumas minutemis? ");
    scanf("%d", &periodiskumas);

    printf("Kiek valandu prastovejes sumustinis bus ismestas? ");
    scanf("%d", &ismetamasH);

    printf("Kokia yra sumustinio kaina? ");
    scanf("%lf", &kaina);

    printf("Koks yra darbo dienos ilgis valandomis? ");
    scanf("%d", &darbasH);

    darbasMin = darbasH * 60;

    //susikuriam eiles
    init(q1);
    init(q2);
    init(q3);

    for(int i = 0; i < kiekis; i++)
    {
        enqueue(q1, darbasH);
        enqueue(q2, darbasH);
        enqueue(q3, darbasH);
    }

    for(t=0; t<darbasMin; t++)
    {
        //sumustinio padejimas
        if(t % periodiskumas == 0 && t != 0)
        {
            if(sumustiniuSK1 > sumustiniuSK2)
            {
                for(int i = 0; i < kiekis; i++)
                {
                    push(&laikiklis2, darbasH);
                    sumustiniuSK1++;
                }
            }
            else
            {
                for(int i = 0; i < kiekis; i++)
                {
                    push(&laikiklis1, darbasH);
                    sumustiniuSK2++;
                }
            }
            if(q1->count > q2->count) ////////////////////////////////////////////////////////////////////////////////////
            {
                for(int i = 0; i < kiekis; i++)
                {
                    enqueue(q2, darbasH);
                }
            }
            else
            {
                for(int i = 0; i < kiekis; i++)
                {
                    enqueue(q1, darbasH);
                }
            }
            enqueue(q3, darbasH);
        }

        //sumustinio paemimas
        if(tikimybe >= randSkaicius())
        {
            pelnas += kaina;
            if(((rand() % 2) + 1) == 1)
            {
                if(sumustiniuSK1 == 0)//jei 1 laikiklis tuscias, imam is 2
                {
                    pop(&laikiklis2);
                    sumustiniuSK2--;
                }
                else
                {
                    pop(&laikiklis1);
                    sumustiniuSK1--;
                }
            }
            else
            {
                if(sumustiniuSK2 == 0)
                {
                    pop(&laikiklis1);
                    sumustiniuSK1--;
                }
                else
                {
                    pop(&laikiklis2);
                    sumustiniuSK2--;
                }
            }
            if(((rand() % 2) + 1) == 1)
            {
                if(q1->count == 0)
                {
                    dequeue(q2);
                }
                else
                {
                    dequeue(q1);
                }
            }
            else
            {
                if(q2->count == 0)
                {
                    dequeue(q1);
                }
                else
                {
                    dequeue(q2);
                }
            }
            if(q3->count == 0)
            {
                break;
            }
            else dequeue(q3);
        }
        if(t % 60 == 0 && t != 0)
        {
            darbasH--;
        }
    }
    while(isEmpty(laikiklis1) == false || isEmpty(laikiklis2) == false)
    {
        if(top(laikiklis1) >= ismetamasH)
        {
            likeSumustiniai++;
        }
        if(top(laikiklis2) >= ismetamasH)
        {
            likeSumustiniai++;
        }
        pop(&laikiklis1);
        pop(&laikiklis2);
    }

    while(q1->front!=NULL)
    {
        if(q1->front->data >= ismetamasH)
        {
            nuostoliai1 += kaina;
        }
        q1->front = q1->front->next;
    }
    while(q2->front!=NULL)
    {
        if(q2->front->data >= ismetamasH)
        {
            nuostoliai2 += kaina;
        }
        q2->front = q2->front->next;
    }
    while(q3->front!=NULL)
    {
        if(q3->front->data >= ismetamasH)
        {
            nuostoliai3 += kaina;
        }
        q3->front = q3->front->next;
    }
    printf("Pelnas: %f\n", pelnas);
    printf("Nuostoliai su steck tipo laikikliu: %f\n", nuostoliai1);
    printf("Nuostoliai su 2 eiles laikikliais: %f\n", nuostoliai2);
    printf("Nuostoliai su1 eiles laikikliu: %f\n", nuostoliai3);
}

int randSkaicius()
{
    int var = (rand()%100)+1;
    return var;
}
