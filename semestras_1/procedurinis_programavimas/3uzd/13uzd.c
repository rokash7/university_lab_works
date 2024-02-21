#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char * pakeitimas(char tekstas[]);

int main(int ArgumentuSk, char * FailoVardas[]){
    FILE * duomenys=NULL;
    FILE * rezultatai=NULL;
    char tekstas[255];
    char * kopija;

    duomenys=fopen(FailoVardas[1], "r"); //atidaro duomenu faila

    if(duomenys==NULL){ //tikrina ar duomenu failas yra
        printf("Duomenu failo rasti nepavyko.\n");
        exit(1);
    }

    rezultatai=fopen(FailoVardas[2], "w"); //sukuria rezultatu faila

    if(rezultatai==NULL){ //tikrina ar imanoma sukurti rezultatu faila
        printf("Rezultatu failo sukurti nepavyko");
        exit(1);
    }


    while(!feof(duomenys)){ //nuskaito duomenis is duomenu failo i char masyva
        fgets(tekstas, 255, duomenys);
        kopija=pakeitimas(tekstas);
        fprintf(rezultatai, "%s", kopija);
    }

    return 0;
}
char * pakeitimas(char tekstas[]){
    int n=0;
    char temp;
    int zodzioPradzia=0;
    char VS;
    int VSnr;
    int z=0;
    int ismesti[255];
    int c=0;
    int c1=0;
    static char kopija[255];

    n=strlen(tekstas);

    for(int i=0; i<n; i++){ //tikrina ar vidurinis zodzio simbolis yra skaicius
        temp=tekstas[i];

        if(temp==' '||temp=='\n'||temp=='\0'){
            if((i-zodzioPradzia)%2==0&&i!=0){
                VSnr=(i+zodzioPradzia)/2;
                VS=tekstas[VSnr];

                if(VS=='0'||VS=='1'||VS=='2'||VS=='3'||VS=='4'||VS=='5'||VS=='6'||VS=='7'||VS=='8'||VS=='9'){
                    for(int j=zodzioPradzia+1; j<i; j++){
                        ismesti[c]=j;
                        c++;
                    }
                }
            }
            zodzioPradzia=i;
        }
    }

    for(int i=0;i<n;i++){ //ismeta nereikalingus simbolius

        if(i!=ismesti[c1]){
            kopija[z]=tekstas[i];
            printf("%c", kopija[z]);
            z++;
        }
        else{
            c1++;
        }
    }
    kopija[z]='\0';

    return kopija;
}
