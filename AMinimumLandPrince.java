import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AMinimumLandPrince {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		int caso = Integer.parseInt(lector.readLine());

		while (caso > 0) {
			int costIsland = Integer.parseInt(lector.readLine());
			ArrayList<Integer> lista = new ArrayList<Integer>();
			while (costIsland != 0) {

				lista.add(costIsland);

				costIsland = Integer.parseInt(lector.readLine());
			}
			Collections.sort(lista, Collections.reverseOrder());

			int potencia = 1;
			long resultado = 0;
			for (int i = 0; i < lista.size(); i++) {

				long elevado = lista.get(i);
				long elevStatic=elevado;
				if(potencia>1){
				for (int j = 2; j <= potencia; j++) {
					elevado *= elevStatic;
				}
				}
				elevado *= 2;
				resultado += elevado;
				if(resultado>=5000000){
					break;
				}
				potencia++;
			}
			if(resultado>=5000000)
				System.out.println("Too expensive");
			else
			System.out.println(resultado);
			caso--;
		}
	}

}
