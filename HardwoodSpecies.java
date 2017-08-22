import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HardwoodSpecies {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> treemap;

		int casos = Integer.parseInt(lect.readLine());
		String linea;
		linea = lect.readLine();
		while (casos != 0) {
			casos--;
			int contTotal = 0;
			treemap = new TreeMap<String, Integer>();

			
			
			if(casos!=0){
				linea = lect.readLine();
			while ( !linea.equals("")) {
				
				if (treemap.containsKey(linea)) {
					int num = treemap.get(linea);
					treemap.replace(linea, num += 1);
					contTotal++;
				} else {

					treemap.put(linea, 1);
					contTotal++;

				}
				linea = lect.readLine();
			}
			}else{
				while (lect.ready()) {
					linea = lect.readLine();
					if (treemap.containsKey(linea)) {
						int num = treemap.get(linea);
						treemap.replace(linea, num += 1);
						contTotal++;
					} else {

						treemap.put(linea, 1);
						contTotal++;

					}
					
				}
			}

			Set set = treemap.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {

				Map.Entry mentry = (Map.Entry) iterator.next();
				DecimalFormat decimales = new DecimalFormat("0.0000");



				double por = (double) (((((double) (Integer) mentry.getValue())) / (double) contTotal) * 100);
				String porcentaje = decimales.format(por);
				porcentaje = porcentaje.replace(",", ".");

				System.out.println((mentry.getKey() + " " + porcentaje) );
			}
		
			if (casos != 0) {

				System.out.println();
			}
		}

	}

}
