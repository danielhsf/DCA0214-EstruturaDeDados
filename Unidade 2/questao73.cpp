// Arvore Binaria 
#include <iostream>

using namespace std;

// No 
struct No{  
int n;
struct No *esq;
struct No *dir;
}; 

struct No* novoNo(int valor) 
{ 
  // Allocate memory for new node  
  struct No* no = (struct No*)malloc(sizeof(struct No)); 
  
  // Assign data to this node 
  no->n = valor; 
  
  // Initialize left and right children as NULL 
  no->esq = NULL; 
  no->dir = NULL; 
  return(no); 
} 

struct resultadodabusca{
    No *pt;
    int f;
};

struct resultadodabusca* Buscar(struct No* arvore, int x, int f){
      struct resultadodabusca* no = (struct resultadodabusca*)malloc(sizeof(struct resultadodabusca)); 
      no->pt = arvore;
      no->f = 0;
      if(no->pt != NULL){
          if(no->pt->n == x){
              no->pt = arvore;
              no->f = 1;
              return(no);
          }else{
              if(x < no->pt->n){
                  if(no->pt->esq == NULL){
                      no->pt = no->pt;
                      no->f = 2;
                      return(no);  
                  }else{
                      Buscar(no->pt->esq,x,f);
                  }
              }else{
                  if(no->pt->dir == NULL){
                      no->pt = no->pt;
                      no->f = 3;
                      return(no);
                  }else{
                       Buscar(no->pt->dir,x,f);
                  }
              }
          }
      }else{
          return(no);
      }
}


void inorder(struct No* temp) 
{ 
    if (!temp) 
        return; 
  
    inorder(temp->esq); 
    cout << temp->n << " "; 
    inorder(temp->dir); 
} 

void insertion(int x,struct No* arvore, int f) 
{ 
  struct resultadodabusca *testando = Buscar(arvore,x,0);
  struct No *newnode = novoNo(x);
  if(testando->f == 0){
        cout << " árvore vazia" << endl;
        arvore = newnode;
    }else if(testando->f == 1){
        cout << "Elemento ja existe " << endl;
    }else if(testando->f == 2){
        testando->pt->esq = newnode;
    }else if(testando->f == 3){
        testando->pt->dir = newnode;
    }
} 

void remove(int x,struct No* arvore){
  struct resultadodabusca *testando = Buscar(arvore,x,0);
  struct No *key_node = NULL;
  if(testando->f == 1){
        if(testando->pt->esq == NULL and testando->pt->dir == NULL){ 
            delete testando->pt; 
        }else if(testando->pt->esq != NULL and testando->pt->dir == NULL){
            testando->pt = testando->pt->esq;
        }else if(testando->pt->esq == NULL and testando->pt->dir != NULL){
            testando->pt = testando->pt->dir;
        }else{
            
        }
    }
}

int main() 
{ 
    /* Arvore  
  
          10 
        /    \ 
       8       20 
     /   \    /  \ 
    7     9  15   25
  */
    struct No *topo = novoNo(10);
    topo->dir = novoNo(20);
    topo->esq = novoNo(8);
    topo->esq->esq = novoNo(7);
    topo->esq->dir = novoNo(9);
    topo->dir->esq = novoNo(15);
    topo->dir->dir = novoNo(25);
    cout << "Arvore :" << endl;
    inorder(topo);
    cout << endl;
    cout << "Procurando 10" << endl;
    struct resultadodabusca *testando = Buscar(topo,10,0);
    if(testando->f == 0){
        cout << "Árvore vazia" << endl;
    }else if(testando->f == 1){
        cout << testando->pt->n << " encontrado e pt aponta para nó onde a chave se encontra " << endl;
    }else if(testando->f == 2){
        cout << "chave não encontrada e pt aponta para nó cuja árvore esquerda é vazia" << endl;
    }else if(testando->f == 3){
        cout << "chave não encontrada e pt aponta para nó cuja árvore direita é vazia" << endl;
    }
    cout << endl;
    cout << "Inserindo 5 :";
    insertion(5,topo,0);
    cout << endl;
    inorder(topo);
    cout << endl; 
    cout << "Removendo 5 da Arvore :" << endl;
    remove(5,topo);
    inorder(topo);
    cout << endl;
	return 0; 
} 
