typedef struct node{ //struktura, kuria sudaro 2nariai: elementas ir kito elemento adresas
    int data;
    struct node *kitas; //link
}node;

node *pirmas=NULL;

void elementoSukurimas(int elementas, node **pirmas){
    node *naujasElementas=(node*)malloc(sizeof(node)); //sukuriamas node
    naujasElementas->data=elementas; //i "data" isikeliame elemento reiksme
    naujasElementas->kitas=NULL; //i "kitas" isikeliame null reiksme, tai nurodo, kad elementas KOL KAS yra paskutinis
    node *temp=*pirmas; //

    if(*pirmas==NULL){
        *pirmas=naujasElementas;
    }
    else
    {
        while(temp->kitas!=NULL)
            temp=temp->kitas;
            temp->kitas=naujasElementas;
    }
}

void trynimas(int n){
    node *temp1=pirmas;

    if(n==1){
    temp1=pirmas;
    pirmas=temp1->kitas;
    temp1->kitas=NULL;
    free(temp1);
    }
    else{
        int i;
        for(i=0;i<n-2;i++){
            temp1=temp1->kitas;
        }
        node *temp2=temp1->kitas;
        temp1->kitas=temp2->kitas;
        free(temp2);
    }
}

void printList(node *pirmas){
    node *p=pirmas;

    while(p!=NULL){
        printf("%d\t", p->data);
        p=p->kitas;
    }
}
