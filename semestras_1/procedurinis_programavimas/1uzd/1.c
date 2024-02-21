//3uzd
#include <stdio.h>
main(){
int n=0; int sum=0; int digit=0; int ats=0; int f=1;

printf("iveskite sveiku skaiciu seka, kurios pabaiga zymima skaiciumi 0: ");

scanf("%d", &n);

for(;n>0;){
    while(n>0){
        digit = n%10;
        sum+=digit;
        n/=10;
    }

    if(sum%2!=0){
        ats=ats+1;
    }

    scanf("%d", &n);
}

printf("skaiciu, kuriu suma nelygine skaicius:%d\n",ats);
printf("%d", f+f);
}
