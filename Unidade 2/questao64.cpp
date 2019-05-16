// Questao 64 
#include <iostream>

using namespace std;

// No 
struct No{  
int n;
struct No *prox;
}; 

struct No* novoNo(int valor) 
{ 
  // Allocate memory for new node  
  struct No* no = (struct No*)malloc(sizeof(struct No)); 
  
  // Assign data to this node 
  no->n = valor; 
  
  // Initialize left and right children as NULL 
  no->prox = NULL;  
  return(no); 
} 

void enfileirar(struct No* fila, int x){
    struct No *novo = novoNo(x);
    if(fila->prox == NULL){
        fila->prox = novo;
    }else{
        enfileirar(fila->prox, x);
    }
    
}

struct No* desenfileirar(struct No* fila){
    return(fila->prox);
}

int top(struct No* fila){
    return fila->n;
}

struct No* caminho(int m[6][6],int x, int y, struct No* fila){
    for(int i = 0;i<6;i++){
        if(m[y][i] == 1){
            enfileirar(fila,i);
            caminho(m,y,i,fila);
        }
    }
    return(fila);

}

int main() 
{ 
   int a[6][6] = {  
   {0, 1, 0, 0, 0, 0} ,   
   {0, 0, 1, 0, 0, 0} ,   
   {0, 0, 0, 0, 1, 0} , 
   {0, 0, 1, 0, 1, 0} , 
   {1, 0, 0, 0, 0, 0} ,
   {0, 1, 0, 0, 0, 0} 
};
    struct No *fila = novoNo(10);
    for(int x = 0;x<6;x++){
        for(int y = 0;y<6;y++){
            if(a[x][y] == 1){
                struct No *fila = novoNo(x);
                enfileirar(fila,y);
                fila = caminho(a,x,y,fila);
            }
        }
    }
    enfileirar(fila,20);
    enfileirar(fila,30);
    enfileirar(fila,40);
    cout << fila->n << endl;
    cout << fila->prox->n << endl;
    cout << fila->prox->prox->n << endl;
    cout << fila->prox->prox->prox->n << endl;
    fila = desenfileirar(fila);
    fila = desenfileirar(fila);
    cout << fila->n << endl;
	return 0; 
} 
