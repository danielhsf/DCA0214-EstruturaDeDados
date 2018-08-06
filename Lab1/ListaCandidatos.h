#include "NoCandidato.h"
//#include "Candidato.h"
#include <cstring>
#include <sstream>

using namespace std;


class ListaCandidatos{
	public:
		NoCandidato *head;
		
		ListaCandidatos(){
			head = NULL;
			}
		void adicioneComoHead(Candidato* c){
			head = new NoCandidato(c, head);
			}
		bool estaVazia(){
			return head==NULL;
			}
		int tamanho(){
			int contador = 0;
			NoCandidato* aux = head;
			while(aux != NULL){
			contador+=1;
			aux = aux->next;
			}
			return contador;
			}
		string toString(){
			if(estaVazia()){
				return "0";	
			}else{
				return head->toString();
				}		 
			}
};
