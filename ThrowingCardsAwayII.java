import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowingCardsAwayII {

	public static int metodo(int[] arreglo, boolean tirar) {

		if (arreglo.length == 1) {

			return arreglo[0];
		} else {
			boolean b = true;
			int[] nuevo;
			if (arreglo.length % 2 != 0)
				b = false;

			if (tirar) {

				nuevo = new int[arreglo.length / 2];

				for (int i = 1, j = 0; i < arreglo.length; i += 2, j++) {
					nuevo[j] = arreglo[i];
				}

				if (b)
					return metodo(nuevo, true);
				else
					return metodo(nuevo, false);
			} else {

				if (b)
					nuevo = new int[((arreglo.length) / 2)];
				else {
					nuevo = new int[((arreglo.length) / 2) + 1];
					b = false;
				}
				for (int i = 0, j = 0; i < arreglo.length; i += 2, j++) {
					nuevo[j] = arreglo[i];
				}
				if (b) {
					return metodo(nuevo, false);
				} else
					return metodo(nuevo, true);

			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		String act;
		while (!(act = lect.readLine()).equals("0")) {
act=act.trim();
			if (Integer.parseInt(act) == 1) {
				System.out.println(act);
			} else {
				int tam=Integer.parseInt(act);
				int[] arreglo = new int[tam / 2];

				for (int i = 2, j = 0; i <= tam; i += 2, j++) {

					arreglo[j] = i;

				}

				if (tam % 2 != 0) {
					System.out.println(metodo(arreglo, false));
				} else
					System.out.println(metodo(arreglo, true));

			}
		}
	}

}
