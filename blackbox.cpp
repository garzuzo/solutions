#include <iostream>
#include <set>
#include <vector>
#include <iterator>
#include <stdio.h>
using namespace std;


int main(){

int totalCases=0;

scanf("%d", &totalCases);

while(totalCases>0){

int totalM=0;
int totalQueries=0;
scanf("%d %d", &totalM, &totalQueries);
int arregloASet[totalM];
int arregloConsultas[totalQueries];

for(int i=0;i<totalM;i++){


scanf("%d", &arregloASet[i]);

}

for(int i=0;i<totalQueries;i++){


scanf("%d", &arregloConsultas[i]);

}

multiset<int> setActual;
int puntero=0;
int unaI=0;
multiset<int>::iterator it1;
for(int i=0;i<totalM;i++){


setActual.insert(arregloASet[i]);


int tamAct=setActual.size();





while(puntero!=totalQueries+1 && tamAct==arregloConsultas[puntero]){
	
	multiset<int>::iterator it=setActual.begin();

if(unaI!=0){
	it=it1;
	
}
//look here
advance(it,unaI);
it1=it;



printf("%d\n", *it);
unaI++;
puntero++;
}

}

totalCases--;
if(totalCases>0){
	printf("\n");
}
}

return 0;
}

