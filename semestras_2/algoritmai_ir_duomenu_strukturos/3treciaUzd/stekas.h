#ifndef STEKAS_H
#define STEKAS_H
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
typedef struct Stekas{
    int duomenys;
    struct Stekas *next;
} Stekas;

bool isFull();
bool isEmpty(Stekas *pradzia); // Jeigu tuščias grįžta 0
int push(Stekas **pradzia, int duomenys); //Grįžta malloco adresas
int pop(Stekas **pradzia); // Jeigu stekas tuščias grįžta NULL
int top(Stekas *pradzia); // Jeigu stekas tuščias grįžta NULL
void del(Stekas **pradzia);
#endif
