import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GodSaveMe {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);

		int casos = lector.nextInt();

		for (int i = 1; i <= casos; i++) {

			int numCasosActual = lector.nextInt();
			double resultado = 0;
			boolean mayorQueCero = false;
			ArrayList<Double> arregloPositivos = new ArrayList<Double>();
			for (int j = 0; j < numCasosActual; j++) {

				int xi = lector.nextInt();
				double pi = Double.parseDouble(lector.next());

				if (xi > 0) {
					mayorQueCero = true;
					arregloPositivos.add(pi);
				} else {
					xi *= -1;
				}
				resultado += pi * xi;

			}
			if (!mayorQueCero)
				System.out.println("Case " + i + ": God! Save me");
			else {
				double div = 0;
				for (int j = 0; j < arregloPositivos.size(); j++) {
					div += arregloPositivos.get(j);
				}
				resultado /= div;
				DecimalFormat df = new DecimalFormat("#.##");
				String impr = df.format(resultado);
				impr = impr.replace(",", ".");
				int tam = impr.length();
				boolean encontro = false;
				int cont = 0;
				for (int j = 0; j < tam; j++) {
					if ((impr.charAt(j) + "").equals(".")) {
						encontro = true;
					} else if (encontro)
						cont++;
				}
				if (!encontro) {
					impr += ".00";
				} else if (cont < 2) {
					for (int j = cont; j < 2; j++) {
						impr += "0";
					}
				}
				if (impr.length() == 1) {
					System.out.println("Case " + i + ": " + "inf");
				} else
					System.out.println("Case " + i + ": " + impr);

			}
		}

	}

}
