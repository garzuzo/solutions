import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class mrfeynmann {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		String caso;
//		int[] arreglo = new int[1000];
//		int j = 0;
//		for (int i = 1; i <= arreglo.length; i++) {
//
//			arreglo[i - 1] = i * i;
//
//		}
		while (!(caso = lector.readLine()).equals("0")) {

			double actual = Double.parseDouble(caso);

			boolean stop = false;
			double a = 0;
			for (int i = 1; i <= 1000 && !stop; i++) {

				int inferior = i;
				int superior = i + 1;

				int inf = inferior * inferior;
				int sup = superior * superior;
				if (inf <= actual && sup >= actual) {
					stop = true;
					if (actual - inf > sup - actual) {
						a = superior;
					} else {
						a = inferior;
					}
				}

			}

			double part=1 / (2*a);
			double dx =(double) part * (double)(actual - (a * a));

			double raiz = a + dx;

			DecimalFormat df = new DecimalFormat("0.0000");
			String res = df.format(raiz);
			res = res.replace(",", ".");
			System.out.println(res);
		}
	}
}
