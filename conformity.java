import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class conformity {

	public static void main(String[] args) throws IOException {

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		String caso;
		while (!(caso = lector.readLine()).equals("0")) {
			HashMap<String, Integer> tm = new HashMap<String, Integer>();
			for (int i = 0; i < Integer.parseInt(caso); i++) {

				String[] arregloActual = lector.readLine().split(" ");

				Arrays.sort(arregloActual);

				String cadenaArreglo = "";
				for (int j = 0; j < arregloActual.length; j++) {

					cadenaArreglo += arregloActual[j];
				}

				if (tm.containsKey(cadenaArreglo)) {
					int nuevoVal = tm.get(cadenaArreglo) + 1;

					tm.replace(cadenaArreglo, nuevoVal);
				} else {
					tm.put(cadenaArreglo, 1);
				}

			}
			int mayor = 0;

			int mayorEnIguales = 0;
			Iterator<Integer> it = tm.values().iterator();
			while (it.hasNext()) {
				int valorAct = it.next();
				if (valorAct > mayor) {
					mayorEnIguales = valorAct;

					mayor = valorAct;

				} else if (valorAct == mayor)
					mayorEnIguales += valorAct;
			}
			if (mayorEnIguales >= mayor)
				System.out.println(mayorEnIguales);
			else if (mayor > mayorEnIguales) {
				System.out.println(mayor);
			} else
				System.out.println(tm.size());

		}

	}

}
