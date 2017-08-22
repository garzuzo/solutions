import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class ILovePizza {

	public static void main(String[] args) throws NumberFormatException, IOException {
	

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		int casos = Integer.parseInt(lector.readLine());
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		tm.put("M", 0);
		tm.put("A", 0);
		tm.put("R", 0);
		tm.put("G", 0);
		tm.put("I", 0);
		tm.put("T", 0);
		while (casos > 0) {

			String lineaActual = lector.readLine();
			for (int i = 0; i < lineaActual.length(); i++) {

				if ((lineaActual.charAt(i) + "").equals("M") || (lineaActual.charAt(i) + "").equals("A")
						|| (lineaActual.charAt(i) + "").equals("R") || (lineaActual.charAt(i) + "").equals("G")
						|| (lineaActual.charAt(i) + "").equals("I") || (lineaActual.charAt(i) + "").equals("T"))

					tm.replace(lineaActual.charAt(i) + "", tm.get(lineaActual.charAt(i)+"") + 1);

			}

			int menor = Integer.MAX_VALUE;
			Set set = tm.keySet();
			for (Iterator i = set.iterator(); i.hasNext();) {

				String act = (String) i.next();
				int temp = tm.get(act);
				if (act.equals("A")) {
					temp = temp / 3;
				} else if (act.equals("R")) {
					temp = temp / 2;
				}
				if (temp < menor) {
					menor = temp;
				}

				
			}
			System.out.println(menor);
			tm.replace("M", 0);
			tm.replace("A", 0);
			tm.replace("R", 0);
			tm.replace("G", 0);
			tm.replace("I", 0);
			tm.replace("T", 0);
			casos--;
		}

	}

}
