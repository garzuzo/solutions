#include <cstdlib>
#include <iostream>

using namespace std;

int main(){
	
	string caso;
	cin>>caso;
	int cont=1;
	while(caso.compare("#")!=0){
		
		if(caso.compare("HELLO")==0){
			cout<< "Case "<<cont<<": "<<"ENGLISH"<<endl;
		}else if(caso.compare("HOLA")==0){
			cout<<"Case "<<cont<<": "<<"SPANISH"<<endl;
		}else if(caso.compare("HALLO")==0){
			cout<< "Case "<<cont<<": "<<"GERMAN"<<endl;
		}else if(caso.compare("BONJOUR")==0){
			cout<< "Case "<<cont<<": "<<"FRENCH"<<endl;
			
		}else if(caso.compare("CIAO")==0){
				cout<< "Case "<<cont<<": "<<"ITALIAN"<<endl;
			
		}else if(caso.compare("ZDRAVSTVUJTE")==0){
			cout<< "Case "<<cont<<": "<<"RUSSIAN"<<endl;
		}else{
			cout<< "Case "<<cont<<": "<<"UNKNOWN"<<endl;
		}
		
		
		
		cin>>caso;
		cont++;
	}
	
	
	return 0;
}
