package ImplementacionLista;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class FullTank {

	public static void main(String[] args) throws IOException {

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		String[] tam = lector.readLine().split(" ");
		int vertices = Integer.parseInt(tam[0]);
		int aristas = Integer.parseInt(tam[1]);

		Grafo grafo = new Grafo(true);

		grafo.setVerticesAgregados(new Vertice[vertices][101]);
		grafo.setListaAdy(new ArrayList[vertices * 101]);
		String[] arregloCostoGasolina = lector.readLine().split(" ");

		int[] arregloPrecios = new int[arregloCostoGasolina.length];

		for (int i = 0; i < arregloCostoGasolina.length; i++) {

			arregloPrecios[i] = Integer.parseInt(arregloCostoGasolina[i]);
		}

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < 101; j++) {
				grafo.agregar(i, j);
				if (j > 0) {
					grafo.conectar(i, j - 1, j, arregloPrecios[i]);
				}
			}
		}

		for (int i = 0; i < aristas; i++) {
			String[] datos = lector.readLine().split(" ");
			int inicio = Integer.parseInt(datos[0]);
			int fin = Integer.parseInt(datos[1]);
			int costo = Integer.parseInt(datos[2]);

			for (int j = costo; j < 101; j++) {
				grafo.conectar(grafo.buscar(inicio, j), grafo.buscar(fin, j - costo), 0);
				grafo.conectar(grafo.buscar(fin, j), grafo.buscar(inicio, j - costo), 0);
			}
		}

		int numLlamados = Integer.parseInt(lector.readLine());

		for (int i = 0; i < numLlamados; i++) {

			String[] casos = lector.readLine().split(" ");

			int capacidadTanque = Integer.parseInt(casos[0]);
			int inicio = Integer.parseInt(casos[1]);
			int fin = Integer.parseInt(casos[2]);
			grafo.Dijkstra(inicio, fin, capacidadTanque);
			int ret = grafo.getL()[grafo.buscar(fin, 0).getPos()];

			if (ret != Integer.MAX_VALUE) {
				System.out.println(ret);
			} else {
				System.out.println("impossible");
			}
		}
	}
}

class Grafo {

	private int size;

	private boolean dirigido;

	private int[] l;

	private Vertice[][] verticesAgregados;

	private static int MAX = Integer.MAX_VALUE;

	private ArrayList<Arista>[] listaAdy;

	public Grafo() {
		size = 0;
		dirigido = false;
	}

	public Grafo(boolean dirigido) {
		size = 0;
		this.dirigido = dirigido;
	}

	public boolean agregar(int v, int c) {
		Vertice ver = new Vertice(v, c);
		verticesAgregados[v][c] = ver;
		return agregar(ver);
	}

	private boolean agregar(Vertice v) {
		v.setPos(size);
		listaAdy[size] = new ArrayList<Arista>();
		size++;
		return true;
	}

	public boolean conectar(int i, int v1, int v2, int costo) {
		Vertice inicio = buscar(i, v1);
		Vertice fin = buscar(i, v2);
		return conectar(inicio, fin, costo);
	}

	public boolean conectar(Vertice inicio, Vertice fin, int costo) {
		if (!dirigido) {
			if (listaAdy[inicio.getPos()] != null && listaAdy[fin.getPos()] != null) {
				Arista aristTemp = new Arista(inicio, fin, costo);
				listaAdy[inicio.getPos()].add(aristTemp);
				Arista aristTemp2 = new Arista(inicio, fin, costo);
				listaAdy[fin.getPos()].add(aristTemp2);
				return true;
			} else {
				return false;
			}
		} else if (listaAdy[inicio.getPos()] != null && listaAdy[fin.getPos()] != null) {
			Arista aristTemp = new Arista(inicio, fin, costo);
			listaAdy[inicio.getPos()].add(aristTemp);
			return true;
		} else {
			return false;
		}
	}

	private int consultarCosto(Vertice vertice1, Vertice vertice2) {

		int tam = listaAdy[vertice1.getPos()].size();
		for (int i = 0; i < tam; i++) {
			Arista temp = listaAdy[vertice1.getPos()].get(i);
			if (temp.getVertex2() == vertice2) {

				return temp.getCost();
			}
		}
		return 0;
	}

	public Vertice buscar(int valor, int cost) {
		return verticesAgregados[valor][cost];
	}

	public void Dijkstra(int valor, int fin, int capacidad) {
		Dijkstra(buscar(valor, 0), buscar(fin, 0), capacidad);
	}

	public void Dijkstra(Vertice a, Vertice fin, int capacidad) {
		int[] verticesVicitados = new int[size];

		l = new int[size];

		for (int i = 0; i < l.length; i++) {
			l[i] = MAX;
		}
		l[a.getPos()] = 0;

		PriorityQueue<nodo> pq = new PriorityQueue<nodo>();

		pq.add(new nodo(a, 0, a.getPos()));
		while (!pq.isEmpty() && verticesVicitados[fin.getPos()] == 0) {
			nodo n;
			while (pq.size() > 0 && verticesVicitados[pq.peek().getPos()] != 0) {
				pq.poll();
			}
			if (!pq.isEmpty()) {
				n = pq.poll();
				Vertice u = n.getVertice();
				verticesVicitados[u.getPos()] = 1;

				for (int i = 0; i < listaAdy[u.getPos()].size(); i++) {

					Vertice v = listaAdy[u.getPos()].get(i).getVertex2();

					if (verticesVicitados[v.getPos()] == 0) {
						int costo = consultarCosto(u, v);
						int posActual = u.getPos();
						int posAdyacente = v.getPos();
						if (capacidad >= u.getCosto() && l[posAdyacente] > l[posActual] + costo) {
							l[posAdyacente] = l[posActual] + costo;
							pq.add(new nodo(v, l[posAdyacente], v.getPos()));

						}
					}
				}
			}
		}
	}

	class nodo implements Comparable<nodo> {

		private int costo;
		private Vertice vertice;
		private int pos;

		public nodo(Vertice v, int c, int pos) {
			costo = c;
			vertice = v;
			this.pos = pos;
		}

		public int getPos() {
			return pos;
		}

		public void setPos(int pos) {
			this.pos = pos;
		}

		public double getCosto() {
			return costo;
		}

		public void setCosto(int distancia) {
			this.costo = distancia;
		}

		public Vertice getVertice() {
			return vertice;
		}

		public void setVertice(Vertice vertice) {
			this.vertice = vertice;
		}

		@Override
		public int compareTo(Grafo.nodo o) {
			if (costo < o.costo) {
				return -1;
			} else if (costo > o.costo) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public int size() {
		return size;
	}

	public Vertice[][] getVerticesAgregados() {
		return verticesAgregados;
	}

	public void setVerticesAgregados(Vertice[][] verticesAgregados) {
		this.verticesAgregados = verticesAgregados;
	}

	public int[] getL() {
		return l;
	}

	public void setL(int[] l) {
		this.l = l;
	}

	public ArrayList<Arista>[] getListaAdy() {
		return listaAdy;
	}

	public void setListaAdy(ArrayList<Arista>[] listaAdy) {
		this.listaAdy = listaAdy;
	}
}

class Vertice implements Comparable<Vertice> {

	private int value;
	private int costo;
	private int pos;

	public Vertice(int val, int costo) {
		value = val;

		this.costo = costo;
	}

	public Vertice(int val) {
		value = val;

	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public int compareTo(Vertice o) {
		return costo - o.costo;
	}

}

class Arista implements Comparable<Arista> {

	private Vertice vertex1;

	private Vertice vertex2;

	private int cost;

	public Arista(Vertice vertex1, Vertice vertex2, int cost) {
		this.vertex2 = vertex2;
		this.cost = cost;

	}

	public Arista(Vertice vertex1, Vertice vertex2) {
		cost = 0;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public Vertice getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertice vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertice getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertice vertex2) {
		this.vertex2 = vertex2;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Arista o) {
		if (cost > o.cost) {
			return 1;
		} else if (cost < o.cost) {
			return -1;
		} else {
			return 0;
		}
	}

}
