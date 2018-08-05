//#ifndef _NOCANDIDATO_H
//#define _NOCANDIDATO_H
#include <cstring>
#include <sstream>
#include "Candidato.h"

using namespace std;

class NoCandidato{
	public:
        Candidato *conteudo;
        NoCandidato *next;
		
        NoCandidato(Candidato* inicio, NoCandidato* prox){
                this->conteudo = inicio;
                this->next = prox;
		}
		
		string toString(){
			stringstream stream;
			stream << conteudo->toString();
			NoCandidato* aux = next;
			while(aux != NULL){
			stream << " -> " << aux->conteudo->toString();
			aux = aux->next;
			}
			stream << " -> " << aux;
			return stream.str();
		}
};
