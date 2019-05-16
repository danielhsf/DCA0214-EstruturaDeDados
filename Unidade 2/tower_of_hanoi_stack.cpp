// Torre de Hanoi 
#include <iostream>
#include <math.h>

using namespace std;

// No 
struct No{  
int n;
char from; 
char to;
char aux; 
struct No *prox;
} No; 

struct No* top = NULL;

void empilha(int n, char from_rod,char to_rod, char aux_rod) {
   struct No* newnode = (struct No*) malloc(sizeof(struct No)); 
   newnode->n = n; 
   newnode->from = from_rod; 
   newnode->to = to_rod; 
   newnode->aux = aux_rod;
   top = newnode; 
}
void desempilha() {
   if (top==NULL){
         cout<<"Pilha vazia"<<endl;
   }else {     
      cout << "Mover disco " << top->n << " do pino " << top->from << " para o pino " << top->to << endl;
      top = top->prox;
   }
}

// Driver Program 
int main() 
{ 
	int n = 3;
	empilha(1,'A','C','B');
   empilha(2,'B','C','A');
   empilha(2,'B','C','A');
   desempilha();
   desempilha();
	return 0; 
} 
