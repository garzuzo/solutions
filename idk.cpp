#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;

int main(){

int tamCaso;

int arreglo[1000];
for(int i=0;i<1000;i++){
    arreglo[i]=i+1;
}
scanf("%d", &tamCaso);
while(tamCaso!=0){
        int casoActual;
        scanf("%d", &casoActual);
while(casoActual!=0){
        int cont=0;
int contCaso=0;

        int casoAct[tamCaso];
casoAct[0]=casoActual;
        for(int i=1;i<tamCaso;i++){
            scanf("%d", &casoAct[i]);
        }
stack<int> pila;
bool respuesta=false;
while(!respuesta){
while(cont<tamCaso && arreglo[cont]!=casoAct[contCaso]){
    pila.push(arreglo[cont]);
    cont++;
}
if(cont<tamCaso){
    pila.push(arreglo[cont]);
    cont++;

}
while(pila.size()!=0 &&contCaso<tamCaso && pila.top()==casoAct[contCaso]){
    pila.pop();
    contCaso++;
}
if(contCaso==tamCaso && pila.size()==0){
    printf("Yes\n");
    respuesta=true;
    break;
}else if((cont>=tamCaso || contCaso>=tamCaso) && pila.size()!=0){
printf("No\n");
respuesta=true;
break;
}
}

    scanf("%d", &casoActual);
}

printf("\n");
scanf("%d", &tamCaso);


}




return 0;
}
