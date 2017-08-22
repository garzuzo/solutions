import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class babyMe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int casos = Integer.parseInt(br.readLine());
		int caso = 1;
		String numeros = "0123456789";
		while (casos != 0) {

			String arreglo = br.readLine();

			String res = "";
			arreglo.replace(" ", "");
			for (int j = 0; j < arreglo.length(); j++) {

				boolean stop = false;
				for (int i = 0; i < numeros.length() && !stop && res.length() <= 3; i++) {

					if ((arreglo.charAt(j) + "").equals(numeros.charAt(i) + "")) {

						res += arreglo.charAt(j) + "";
						stop = true;
					}
				}
			}

			int primerNumero = 0;
			double numA = 0.5;
			double numB = 0.05;
			int segundoNumero = 0;

			if (res.length() == 1) {
				primerNumero = Integer.parseInt(res);
			} else if (res.length() == 2) {

				if (res.equals("10")) {
					primerNumero = Integer.parseInt(arreglo.charAt(0) + "" + arreglo.charAt(1) + "");
				} else {
					primerNumero = Integer.parseInt(res.charAt(0) + "");
					segundoNumero = Integer.parseInt(res.charAt(1) + "");
				}
			} else {
				primerNumero = Integer.parseInt(arreglo.charAt(0) + "" + arreglo.charAt(1) + "");
				segundoNumero = Integer.parseInt(res.charAt(2) + "");
			}

			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.###", simbolos);

			String res1 = df.format(primerNumero * numA + segundoNumero * numB);
			System.out.println("Case " + caso + ": " + res1);
			caso++;

			casos--;
		}

	}

}
