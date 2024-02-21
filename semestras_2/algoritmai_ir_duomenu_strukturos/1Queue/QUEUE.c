#include <stdio.h>
#include <stdlib.h>
#include "queue_prototipai.h"
#include "queue_funkciju_realizacija.c"

int main(){
    int operacijosPasirinkimas;
    queue *q;
    q = malloc(sizeof(queue));
    int value; float temp;
    int elementas;
    int eileSukurta=0;

    for(;;){
        printf("0 - sukurti tuscia eile\n1 - patikrinti, ar eile tuscia\n2 - patikrinti, ar eile pilna\n3 - ideti nauja elementa i eile\n4 - isimti elementa is eiles\n5 - gauti pirmo eiles elemento duomenis, neisimant jo is eiles\n6 - gauti eiles elementu skaiciu\n7 - sunaikinti eile\n8 - uzdaryti programa\n");
        scanf("%d", &operacijosPasirinkimas);
        printf("\n");

        switch(operacijosPasirinkimas){
            case 0:
                if(eileSukurta==0){
                    sukurtiTuciaEile(q);
                    printf("eile sukurta\n\n");
                    eileSukurta=1;
                }
                else{
                    printf("Eile jau sukurta\n\n");
                }
                break;
            case 1:
                if(eileSukurta==1 && eileTuscia(q)==1){
                    printf("eile tuscia\n\n");
                }
                else if(eileSukurta==0){
                    printf("eile nesukurta\n\n");
                }
                else{
                    printf("eile nera tuscia\n\n");
                }
                break;
            case 2:
                pilnas(q);
                break;
            case 3:
                if(eileSukurta==0){
                    printf("eile nesukurta\n\n");
                }
                else if(eileSukurta==1){
                    printf("iveskite sveikaji skaiciu, kuri norite ideti i eile: ");
                    scanf("%f", &temp);//jeigu skaicius nera sveikasis
                    value=(int)temp; //paverciam sveiku

                    idejimas(q, value);
                }
                printf("\n");
                break;
            case 4:
                if(eileSukurta==0){
                    printf("eile nesukurta\n\n");
                }
                else if(eileSukurta==1){
                    elementas=isemimas(q);
                    printf("isimto elemento reiksme: %d\n", elementas);
                }
                break;
            case 5:
                if(eileSukurta==0 && eileTuscia(q)==1){
                    printf("eile nesukurta\n\n");
                }
                else if(eileSukurta==1 && eileTuscia(q)==0 && kiekis(q)!=0){
                    printf("%d\n\n",gautiPirmoReiksme(q));
                }
                else{
                    printf("eile tuscia\n\n");
                }
                break;
            case 6:
                if(eileSukurta==0){
                    printf("eile nesukurta\n\n");
                }
                else if(eileSukurta==1){
                    printf("%d\n\n", kiekis(q));
                }
                break;
            case 7:
                if(eileSukurta==0){
                    printf("eile nesukurta\n\n");
                }
                else if(eileSukurta==1){
                    naikintiEile(q);
                    printf("eile sunaikinta\n\n");
                    eileSukurta=0;
                }
                break;
            case 8:
                return 0;
            default:
                printf("iveskite skaiciu, atitinkanti egzistuojancia operacija\n");
        }
    }

    return 0;
}
