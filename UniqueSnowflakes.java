import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class UniqueSnowflakes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out));
		int casos = Integer.parseInt(lect.readLine());
		TreeMap<Long, Integer> tm = null;
		while (casos > 0) {
			int tot = Integer.parseInt(lect.readLine());
			long[] arreglo = new long[tot];
			for (int i = 0; i < arreglo.length; i++) {
				arreglo[i] = Long.parseLong(lect.readLine().trim());
			}
			tm = new TreeMap<Long, Integer>();

			int cont = 0;

			int maximo = -1;

			int i = 0;
			for (i = 0; i < arreglo.length; i++) {

				long act = arreglo[i];
				if (!tm.containsKey(act)) {
					tm.put(act, 1);
					cont++;
				} else {

					int j2 = i - 1;
					while (j2 >= 0 && arreglo[i] != arreglo[j2]) {
						j2--;
					}
					i = j2;
					maximo = Math.max(maximo, cont);
					cont = 0;

					tm = new TreeMap<Long, Integer>();

				}

			}

			maximo = Math.max(maximo, cont);

			escritor.write(maximo + "\n");

			casos--;
		}
		escritor.close();
	}
}
