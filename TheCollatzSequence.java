import java.io.IOException;
import java.util.Scanner;

public class TheCollatzSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner((System.in));

		int cont = 1;
		long A = lector.nextLong();
		long aStatic = A;
		long L = lector.nextLong();
		while (A >= 0 && L >= 0) {

			int contador = 1;
			while (A != 1 && contador <= L) {
				if (A > L) {

					contador--;
					break;
				}
				if (A % 2 == 0) {
					A /= 2;
					contador++;
				} else {
					A = A * 3 + 1;
					contador++;
				}
			}
			System.out.println(
					"Case " + cont + ": A = " + aStatic + ", limit = " + L + ", number of terms = " + contador);
			cont++;
			A = lector.nextLong();
			aStatic = A;
			L = lector.nextLong();
		}
	}

}
