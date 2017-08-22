import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class AndyFirstDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner(System.in);
		TreeSet<String> set = new TreeSet<String>();

		while (lect.hasNext()) {
			String act = lect.next();
			act = act.trim();
			act = act.toLowerCase();

			String cadena1 = "";

			for (int j = 0; j < act.length(); j++) {

				if (Character.isLetter(act.charAt(j))) {
					int cont = j + 1;
					cadena1 += act.charAt(j) + "";
					while (cont < act.length() && Character.isLetter(act.charAt(cont))) {
						cadena1 += act.charAt(cont) + "";
						cont++;
					}
					set.add(cadena1);
					cadena1 = "";
					j = cont;

				}

			}

		}
		for (Iterator i = set.iterator(); i.hasNext();) {

			System.out.println(i.next());
		}

	}

}
