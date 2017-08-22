import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class tresnmas1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner((System.in));

		while (lect.hasNext()) {

			int n1 = lect.nextInt();
			int n2 = lect.nextInt();
			int n11 = n1;
			int n22 = n2;
			int sum = 0;

			if (n11 > n22) {
				int temp = n11;
				n11 = n22;
				n22 = temp;

			}

			for (int i = n11; i <= n22; i++) {
				int contador = i;
				int sumActual = 0;
				while (contador != 1) {

					if (contador % 2 == 0) {
						sumActual++;
						contador /= 2;
					} else {
						sumActual++;
						contador = (3 * contador) + 1;
					}
				}
				sumActual++;
				if (sum < sumActual)
					sum = sumActual;

			}

			System.out.println(n1 + " " + n2 + " " + sum);
		}
	}

}
