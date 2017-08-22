#include <iostream>
#include <set>
#include <iterator>
#include <stdio.h>

using namespace std;



int main(){


int tot;
scanf("%d", &tot);

while(tot!=0){

multiset<int> nSet;
long respuesta=0;
for(int i=0;i<tot;i++){
int numAct;
scanf("%d", &numAct);
for(int j=0;j<numAct;j++){
int addAct;
scanf("%d", &addAct);
nSet.insert(addAct);
}
int mayor;
int menor=*nSet.begin();

multiset<int>::iterator it;
multiset<int>::reverse_iterator it1;



for(it1=nSet.rbegin();it1!=nSet.rend();++it1){
mayor=*it1;
break;
}
respuesta+=mayor-menor;

nSet.erase(nSet.equal_range(mayor).first);
nSet.erase(nSet.equal_range(menor).first);

}

printf("%ld\n", respuesta);



scanf("%d", &tot);
}




return 0;
}
