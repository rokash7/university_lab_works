#include <stdio.h>
#include <stdlib.h>
#include "header1.h"

int main(){
    int n=0; int elementas; int delNr;

    printf("iveskite elementu skaiciu: ");
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        printf("iveskite %d elemento reiksme: ", i+1);
        scanf("%d", &elementas);

        elementoSukurimas(elementas, &pirmas);
    }

    if(n>0){
        printf("kuri elementa norite istrinti? ");
        scanf("%d", &delNr);

        if(delNr>n||delNr<1){
            printf("elementas tokiu numeriu neegzistuoja");
        }
        else{
            trynimas(delNr);
            printList(pirmas);
        }
    }

    return 0;
}
