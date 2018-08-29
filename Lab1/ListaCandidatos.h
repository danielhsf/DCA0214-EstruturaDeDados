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
			if(head->conteudo->igual(nome,sobrenome)){
				head = head->next;
				return true;
				}
			NoCandidato* it = head;
			while(it->next!= NULL){
				if(it->next->conteudo->igual(nome,sobrenome)){
					NoCandidato* aux = it->next;
					it->next = it->next->next;
					delete aux;
					return true;
					}
					it = it->next;
				}
			return false;
			}
			
		void filtrarCandidatos(int nota){
			NoCandidato* it = head;
			while(it!= NULL){
				if(it->conteudo->nota < nota){
					remove(it->conteudo->nome,it->conteudo->sobrenome);
					}
					it = it->next;
				}
			}

		void concatena(ListaCandidatos* l){
			NoCandidato* it = head;
			while(it->next != NULL){
					it = it->next;
				}
				it->next = l->head;
				//head = it;
			}
};
