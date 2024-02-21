#include <stdio.h>
#include <stdlib.h>

void ivedimas(int *nptr, int **sk_masyvas);
int vidurkis(int n, int sk_masyvas[]);

int main(){
    int n=0; double vid=0; double neig_max=0; int maz; double teig_min=0; int did; int *sk_masyvas;

    ivedimas(&n, &sk_masyvas);
    vid=vidurkis(n, sk_masyvas);

    double skirtumu_masyvas[n];

    for(int i=0; i<n; i++){ //suskaiciuoja elementu ir vidurkio skirtumus
        skirtumu_masyvas[i]=sk_masyvas[i]-vid;
    }

    for(int i=0; i<n; i++){ //suranda random mazesni uz vidurki elementa
        if(skirtumu_masyvas[i]<0){
            neig_max=skirtumu_masyvas[i];
            break;
        }
    }

    for(int i=0; i<n; i++){ //suranda artimiausia mazesni uz vidurki elementa
        if(skirtumu_masyvas[i]<0 && skirtumu_masyvas[i]>neig_max){
            neig_max=skirtumu_masyvas[i];
        }
    }

    maz=neig_max+vid; //sutvarko artimiausia mazesni uz vidurki elementa

    for(int i=0; i<n; i++){ //suranda random didesni uz vidurki elementa
        if(skirtumu_masyvas[i]>0){
            teig_min=skirtumu_masyvas[i];
            break;
        }
    }

    for(int i=0; i<n; i++){ //suranda artimiausia didesni uz vidurki elementa
        if(skirtumu_masyvas[i]>0 && skirtumu_masyvas[i]<teig_min){
            teig_min=skirtumu_masyvas[i];
        }
    }

    did=teig_min+vid; //sutvarko artimiausia didesni uz vidurki elementa

    printf("artimiausias mazesnis uz vidurki skaicius yra %d\nartimiausias didesnis uz vidurki skaicius yra %d", maz, did);

    return 0;
}

void ivedimas(int *nptr, int **sk_masyvas){
    int temp=0; int n=0; int z=1;

    printf("iveskite sveika skaiciu N: \n");
    scanf("%d", &n);

    *sk_masyvas=malloc(n*sizeof(int));

    *nptr=n;
    return;
}

int vidurkis(int n, int sk_masyvas[]){
    double vid; double sum=0;

    for(int i=0; i<n; i++){
        printf("iveskite sveika skaiciu: \n");
        scanf("%d", &(sk_masyvas)[i]);
        }

    for(int i=0; i<n; i++){
        sum=sum+sk_masyvas[i];
    }

    vid=sum/n;

    return vid;
}
