#ifndef TEST_H_INCLUDED
#define TEST_H_INCLUDED
struct node{
    int data;
    struct node *next;
};
typedef struct node node;

struct queue{
    int count;
    node *front;
    node *rear;
};
typedef struct queue queue;

void sukurtiTuciaEile(queue *q); //sukuria tuscia eile, nieko negrazina
int eileTuscia(queue *q); //jei eile tuscia, grazinamas vienetas
void idejimas(queue *q, int value); //i eile iterpiamas elementas, perduodama elemento reiksme
int isemimas(queue *q); //panaikinamas pirmas eiles elementas, konsoleje grazinama jo reiksme
int pilnas(queue *q); //grazinamas 1 (funkcija iskvieciama tuo atveju, jei iterpiant elementa eile yra pilna)
int kiekis(queue *q); //isvedamas elementu skaicius
int gautiPirmoReiksme(queue *q); //gaunama pirmo elemento reiksme, bet jis is eiles nedingsta
void naikintiEile(queue *q); //eile istrinama

#endif
