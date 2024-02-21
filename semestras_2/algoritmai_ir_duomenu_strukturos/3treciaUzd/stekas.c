#include "stekas.h"

bool isFull(){
    Stekas *stekas = (Stekas*)malloc(sizeof(Stekas));
    bool b = stekas == NULL;
    free(stekas);
    return b;
}

bool isEmpty(Stekas *pradzia){
    return pradzia == NULL;
}

int push(Stekas **pradzia, int duomenys){
    Stekas *stekas = (Stekas*)malloc(sizeof(Stekas));
    stekas->duomenys = duomenys;
    if (stekas == NULL) return stekas;

    stekas->next = *pradzia;
    *pradzia = stekas;
    return stekas;
    }

int pop(Stekas **pradzia){
    if(isEmpty(*pradzia)) return NULL;
    Stekas* temp = *pradzia;
    *pradzia = (*pradzia)->next;
    int popped = temp->duomenys;
    free(temp);

    return popped;
}

void del(Stekas **pradzia){
   Stekas *elem = *pradzia;
   Stekas *next;

   while (elem != NULL)
   {
       next = elem->next;
       free(elem);
       elem = next;
   }

   *pradzia = NULL;
}

int top(Stekas *pradzia){
    if(isEmpty(pradzia)) return NULL;
    return pradzia->duomenys;
}
