void sukurtiTuciaEile(queue *q){
    q->count = 0; //elementu skaitliukas
    q->front = NULL; //priekis nerodo niekur
    q->rear = NULL; //galas nerodo niekur
}

int eileTuscia(queue *q){
    return (q->rear == NULL); //1 - eileTuscia :)
}

void idejimas(queue *q, int value){
    node *tmp;
    tmp = malloc(sizeof(node)); //naujo node sukurimas

    if(tmp==NULL){
        pilnas(q);
    }

    tmp->data = value; //vertes priskyrimas naujam node'ui
    tmp->next = NULL; //last node atm
    if(!eileTuscia(q)){ //eile netuscia
        q->rear->next = tmp; //eiles galas rodo i si node
        q->rear = tmp; //sitas node DABAR yra galas
    }
    else{ //eile tuscia
        q->front = q->rear = tmp; //ir priekis ir galas rodo i node
    }
    q->count++; //didinam skaitliuka
}

int isemimas(queue *q){
    if (q->front == NULL){
        return;
    }
    node *tmp;

    int n = q->front->data; //issisaugom data node'o, kuri istrinsim
    tmp = q->front; //temp node rodo i prieki
    q->front = q->front->next; //rodo i kita node
    q->count--; //sumazinam skaitliuka
    free(tmp);

    if (q->front == NULL) {
        q->rear = NULL;
    }
    return(n); //grazinam isimto node reiksme
}

int pilnas(queue *q){
    return 1;
}

int kiekis(queue *q){
    return q->count;
}

int gautiPirmoReiksme(queue *q){
    return q->front->data;
}

void naikintiEile(queue *q){
int counter = q->count;
    for(int i=0; i<counter; i++)
    {
        isemimas(q);
    }

    free(q);
}
