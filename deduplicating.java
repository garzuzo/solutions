import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class deduplicating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);

		while (true) {
			int casoActual = lector.nextInt();

			if (casoActual == 0)
				break;

			lector.nextLine();

			HashMap<Integer, ArrayList<archivo>> hm = new HashMap<Integer, ArrayList<archivo>>();

			long numColisiones = 0;
			long numArchivosUnicos = 0;
			for (int i = 0; i < casoActual; i++) {

				String cadenaActual = lector.nextLine();

				int hash = metodoHash(cadenaActual);

				if (hm.containsKey(hash)) {

					ArrayList<archivo> listaActual = hm.get(hash);
					int tam = listaActual.size();
					boolean entro = false;
					boolean repetido = false;
					for (int j = 0; j < tam; j++) {

						if (!listaActual.get(j).getNombre().equals(cadenaActual)) {

							numColisiones+=listaActual.get(j).getIguales()+1;
							
							entro = true;

						} else {
							repetido = true;
							listaActual.get(j).setIguales(listaActual.get(j).getIguales()+1);
						}

					}

					if (entro && !repetido) {
						archivo nArchivo=new archivo(cadenaActual,0);
						hm.get(hash).add(nArchivo);
						numArchivosUnicos++;
					}
				} else {

					ArrayList<archivo> nl = new ArrayList<archivo>();
					archivo nArchivo=new archivo(cadenaActual,0);
					nl.add(nArchivo);
					hm.put(hash, nl);
					numArchivosUnicos++;
				}

			}

			System.out.println(numArchivosUnicos + " " + (numColisiones));

		}
		lector.close();

	}

	
	public static int metodoHash(String cadena) {

		int resultado = 0;

		for (int i = 0; i < cadena.length(); i++) {

			resultado ^= (int) cadena.charAt(i);

		}

		return resultado;
	}

}
 class archivo {

	String nombre;
	int iguales;

	public archivo(String nombre, int iguales) {

		this.nombre = nombre;
		this.iguales = iguales;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIguales() {
		return iguales;
	}

	public void setIguales(int iguales) {
		this.iguales = iguales;
	}

}

