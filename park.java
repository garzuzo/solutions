import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class park {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);

		int casos = lector.nextInt();

		for (int i = 0; i < casos; i++) {

			int total = lector.nextInt();;

			int lado1 = 0;
			int lado2 = 0;
			boolean lado11 = false;
			boolean lado22 = false;
			double areaInterna = 0;
			for (int j = 0; j < total; j++) {

				

				String tipo = lector.next();
				int tam = lector.nextInt();

				if (tipo.equals("C")) {

					areaInterna += tam * tam;

					if (lado1 != 0 && lado2 == 0) {
						lado11 = true;
						lado1 += tam;
					} else if (lado1 != 0 && lado2 != 0 && !lado22) {
						lado22 = true;
						lado2 += tam;
					}

				} else if (tipo.equals("S")) {

					areaInterna += tam * tam;

				} else if (tipo.equals("T")) {

					areaInterna += Math.sqrt(3) * tam * tam / 4;

				}
				if (!lado11) {
					lado1 += tam;
				} else if (!lado22) {
					lado2 += tam;
				}
			}

			double areaTot = lado1 * lado2;

			double resultado = areaTot - areaInterna;

//			if (resultado == 0) {
//				System.out.println("0.0000");
//			} else {
				DecimalFormat df = new DecimalFormat("0.0000");

				String msg = df.format(resultado);
				boolean despuesDelPunto = false;
				int cont = 0;
				int numDesp = 0;
				msg = msg.replace(",", ".");
				System.out.println(msg);
//				while (cont != msg.length()) {
//					if ((msg.charAt(cont) + "").equals(".")) {
//						despuesDelPunto = true;
//					} else if (despuesDelPunto) {
//						numDesp++;
//					}
//
//					cont++;
//				}
//				if(despuesDelPunto){
//					
//				
//				while (numDesp != 4) {
//					msg += "0";
//					numDesp++;
//				}
//
//				System.out.println(msg);
//			}else{
//				
//				msg+=".0000";
//				System.out.println(msg);
//			}
			
//			}
		}

	}

}
