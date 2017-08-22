import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ICanGuesstheDataStructure {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));

		String linea;
		Stack<String> pila;
		Queue<String> cola;
		PriorityQueue<Integer> colaPrioridad;
		String pilaMsg;
		String colaMsg;
		String colaPrioridadMsg;
		String msg;
		while ((linea = lect.readLine()) != null) {
			pila = new Stack<String>();
			cola = new ArrayDeque<String>();
			colaPrioridad = new PriorityQueue<Integer>(Collections.reverseOrder());
			pilaMsg = "";
			colaMsg = "";
			colaPrioridadMsg = "";
			msg = "";
			int numCasos = Integer.parseInt(linea);
			int cont = 0;
			while (numCasos > cont) {
				String[] numAgregar = lect.readLine().split(" ");
				int agregarVerificar = Integer.parseInt(numAgregar[0]);
				String num = numAgregar[1];

				if (agregarVerificar == 1) {

					pila.push(num);
					cola.add(num);
					colaPrioridad.offer(Integer.parseInt(num));
				} else {

					msg += num;
					if (!pila.isEmpty()) {
						pilaMsg += pila.pop();
					}
					if (!cola.isEmpty()) {
						colaMsg += cola.poll();
					}
					if (!colaPrioridad.isEmpty()) {
						colaPrioridadMsg += colaPrioridad.poll();
					}
				}

				cont++;
			}

			int cont1 = 0;
			String resultado = "";
			if (pilaMsg.equals(msg)) {
				cont1++;
				resultado = "stack";
			}
			if (colaMsg.equals(msg)) {
				cont1++;
				resultado = "queue";
			}
			if (colaPrioridadMsg.equals(msg)) {
				cont1++;
				resultado = "priority queue";
			}

			if (cont1 == 1) {

				System.out.println(resultado);

			} else if (cont1 > 1) {
				System.out.println("not sure");
			} else {
				System.out.println("impossible");
			}

		}
	}

}
