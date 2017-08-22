import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class OpenSource {

	public static void main(String[] args) throws IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String caso = lector.readLine();
		while (!caso.equals("0")) {
			HashMap<String, String> map = new HashMap<String, String>();
			HashMap<String, Integer> projName = new HashMap<String, Integer>();
			String ProjActual = caso;
			Character cActual = ProjActual.charAt(0);
			projName.put(ProjActual, 0);
			String id;
			while (!caso.equals("1")) {
				if (cActual.isUpperCase(cActual)) {
					id = lector.readLine();
					cActual = id.charAt(0);
					while (!cActual.isUpperCase(cActual) && !id.equals("1")) {

						if (map.containsKey(id)) {
							if (!map.get(id).equals(ProjActual)) {
								map.replace(id, "0");
							} else
								map.replace(id, ProjActual);
						} else {
							map.put(id, ProjActual);
						}

						id = lector.readLine();
						cActual = id.charAt(0);
					}
					if (!id.equals("1")) {
						ProjActual = id;
						projName.put(ProjActual, 0);
					} else {
						caso = "1";
					}
				}
			}
			// ;) you know what to do...
			Iterator<String> it = map.keySet().iterator();

			while (it.hasNext()) {
				String act = it.next();
				if (!map.get(act).equals("0"))
					projName.replace(map.get(act), projName.get(map.get(act)) + 1);
			}
			Iterator<Map.Entry<String, Integer>> ite = projName.entrySet().iterator();
			ArrayList<par> array = new ArrayList<par>();
			while (ite.hasNext()) {
				Entry act = ite.next();

				par parActual = new par(act.getKey().toString(), (int) act.getValue());
				array.add(parActual);

			}
			Collections.sort(array, new Comparator<par>() {
				public int compare(par par1, par par2) {
					int valor = par1.getValor();
					int valor2 = par2.getValor();
					String cadena1 = par1.getCadena();
					String cadena2 = par2.getCadena();
					if (valor < valor2) {
						return -1;
					} else if (valor > valor2) {
						return 1;
					} else {
						return cadena2.compareTo(cadena1);

					}
				}
			});
			for (int i = array.size() - 1; i >= 0; i--) {

				par act = array.get(i);
				System.out.println(act.getCadena() + " " + act.getValor());
			}
			caso = lector.readLine();
		}
	}

}
class par {
	String cadena;
	int valor;

	public par(String cadena, int valor) {
		this.cadena = cadena;
		this.valor = valor;
	}

	public String getCadena() {
		return cadena;
	}

	public int getValor() {
		return valor;
	}

}
