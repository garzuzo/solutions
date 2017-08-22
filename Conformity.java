import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class Conformity {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));

		int casos;

		while ((casos=Integer.parseInt(lect.readLine())) != 0) {
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
			for (int i = 0; i < casos; i++) {

				String[] arreglo = lect.readLine().split(" ");

				for (int j = 0; j < arreglo.length; j++) {

					if (!tm.containsKey(arreglo[j])) {
						tm.put(arreglo[j], 1);
					} else {

						tm.replace(arreglo[j], tm.get(arreglo[j]) + 1);
					}

				}

			}
			
			
			int cont=0;
			for(int i=0;i<tm.size();i++)
			{
				int cont1= (int) new Vector(tm.values()).get(i);
			   if(cont<cont1)
			cont=cont1;
			}
					
			System.out.println(cont);
		

		}

	}

}
