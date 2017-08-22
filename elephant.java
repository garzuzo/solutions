import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class elephant {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner lector = new Scanner(System.in);
		int caso = lector.nextInt();
		while (caso > 0) {
			int numElephants = lector.nextInt();
			int maxWeight = lector.nextInt();
			int[] eleph = new int[numElephants];
			for (int i = 0; i < eleph.length; i++) {

				eleph[i] = lector.nextInt();
			}
			int cont = 0;
			Arrays.sort(eleph);
			long sum = 0;
			boolean parar = false;
			for (int i = 0; i < eleph.length && !parar; i++) {
				int elephAct = eleph[i];
				if (sum + elephAct <= maxWeight) {
					cont++;
					sum += elephAct;
				} else {
					parar = true;
				}
			}
			System.out.println(cont);
			caso--;
		}
		lector.close();
	}
}
