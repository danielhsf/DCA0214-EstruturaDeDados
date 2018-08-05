#include "NoCandidato.h"
#include "Candidato.h"
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
};
