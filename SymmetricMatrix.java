import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		int casos = Integer.parseInt(lector.readLine());

		for (int c = 1; c <= casos; c++) {

			String[] arrTam = lector.readLine().split(" ");
			int tam = Integer.parseInt(arrTam[2]);
			long[][] matrix = new long[tam][tam];
			boolean nonSymetric = true;
			for (int i = 0; i < matrix.length; i++) {
				String[] filaAct = lector.readLine().split(" ");
				for (int j = 0; j < matrix.length && nonSymetric; j++) {

					long numActual = Long.parseLong(filaAct[j]);
					if (numActual >= 0)
						matrix[i][j] = numActual;
					else
						nonSymetric = false;
				}

			}
			if (nonSymetric) {
				int mitad;
				if (matrix.length % 2 == 0) {

					for (int i = 0, fin = matrix.length - 1; i < matrix.length / 2; i++, fin--) {
						for (int j = 0, fin1 = matrix.length - 1; j < matrix.length; j++, fin1--) {

							if (matrix[i][j] != matrix[fin][fin1]) {
								nonSymetric = false;
							}

						}
					}

				} else {
					mitad = (matrix.length / 2) + 1;
					if (matrix[mitad - 1][mitad - 1] < 0) {
						nonSymetric = false;
					} else {

						for (int i = 0, fin = matrix.length - 1; i < matrix.length / 2 && nonSymetric; i++, fin--) {
							for (int j = 0, fin1 = matrix.length - 1; j < matrix.length && nonSymetric; j++, fin1--) {

								if (matrix[i][j] != matrix[fin][fin1]) {
									nonSymetric = false;
								}

							}
							if (matrix[mitad - 1][i] != matrix[mitad - 1][fin]) {
								nonSymetric = false;
							}
						}
					}
				}
			}
			if (!nonSymetric)
				System.out.println("Test #" + c + ": Non-symmetric.");
			else
				System.out.println("Test #" + c + ": Symmetric.");

		}

	}

}
