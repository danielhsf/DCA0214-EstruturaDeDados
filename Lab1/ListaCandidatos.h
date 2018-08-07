#include "NoCandidato.h"
#include "Candidato.h"
#include <cstring>
#include <sstream>

#include <fstream>
#include <iostream>
#include <cstring>

using namespace std;


class ListaCandidatos{
	public:
		NoCandidato *head;
		ListaCandidatos(){
			head = NULL;
			}
		ListaCandidatos(string nomeDoArquivo){
			head = NULL;
			ifstream fcin(nomeDoArquivo);
			string dados;
			getline(fcin,dados);
			cout << "criacao da lista de candidatos de: " << dados << endl;
			while(getline(fcin,dados)){
				adicioneComoHead(new Candidato(dados));
			}
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
		bool remove(string nome, string sobrenome){
			if(tamanho() == 0){
				
				return false;
				}
			NoCandidato* it = head;
			if(head->conteudo->igual(nome,sobrenome)){
				head = head->next;
				return true;
				}
			while(it->next!= NULL){
				if(it->next->conteudo->igual(nome,sobrenome)){
					it->next = new NoCandidato(it->next->next->conteudo,NULL);
					return true;
					}
					it = it->next;
				}
			return false;
			}
};
