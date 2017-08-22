#include <iostream>
#include <map>
#include <vector>
#include <cmath>

using namespace std;

class Grafo{
	public:
	int size;
	map< Vertex, vector<Arista>> vMap;
	bool dirigido;
	Vertex added[];
	
	
	 Grafo(int siz){
		size=0;
		dirigido=false;
		added=new Vertex[siz];
	}
	 Grafo(bool dirig, int siz){
		size=0;
		
		dirigido=dirig;
		added=new Vertex[siz];
	}
	 add(int nVertex){
		
		Vertex nV=new Vertex(nVertex);
		added[size]=nV;
		size++;
		vector<Arista> nArista;
		vMap.insert(make_pair(nV,nArista));
		
		
	}
	
	 connect(int v1,int v2,int cost){
		
		if(dirigido){
				Vertex vAdd1=Added[v1];
			Vertex vAdd2=Added[v2]:
				Edge edge1=new Edge(vAdd1,vAdd2,cost);
				
			
		}else{
			
			Vertex vAdd1=Added[v1];
			Vertex vAdd2=Added[v2]:
			
			Edge edge1=new Edge(vAdd1,vAdd2,cost);
				Edge edge2=new Edge(vAdd2,vAdd1,cost);
			
			vMap[vAdd1].push_back(edge1);
			vMap[vAdd2].push_back(edge2);
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	 Vertex search(int n){
		
	
	return added[n];	
		
	}
	
	
	
	
	
};


class Vertex{
	public:
	int value;
	
	 Vertex(int val){
		value=val;
	}
	 int getValue(){return value;}
	 void setValue(int nVal){value=nVal;}
	
	
	
	
};

class Edge{
	public:
	
	int weight;
	Vertex vertex1;
	Vertex vertex2;
	
	
	
	
	 Edge(Vertex v1,Vertex v2){
		
		vertex1=v1;
		vertex2=v2;
		
	}
	Edge(Vertex v1,Vertex v2,int w){
		
		vertex1=v1;
		vertex2=v2;
		weight=w;
	}
	
	 int getWeight(){return weight;}
	 Vertex getVertex1(){return vertex1;}
	 Vertex getVertex2(){return vertex2;}
	
	 void setWeight(int nWeight){weight=nWeight;}
	 void setVertex1(Vertex vNew){vertex1=vNew;}
	 void setVertex2(Vertex vNew){vertex2=vNew;}
	
		
	
};
int main(){


return 0;
}
