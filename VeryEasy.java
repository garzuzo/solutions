import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class VeryEasy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner(System.in);

		String linea;
		while (lect.hasNext()) {

			int N = lect.nextInt();
			int A = lect.nextInt();

			BigInteger num = new BigInteger(String.valueOf(A));
			BigInteger resultado = num;
			for (int i = 2; i <= N; i++) {

				BigInteger numActual = new BigInteger(String.valueOf(i));
				resultado = resultado.add(numActual.multiply((num.pow(i))));

			}

			System.out.println(resultado);

		}

	}

}
