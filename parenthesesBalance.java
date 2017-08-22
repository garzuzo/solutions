import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> pila = new Stack<String>();
		int casos = Integer.parseInt(lect.readLine());

		while (casos != 0) {
			String order = lect.readLine();
			ArrayList<String> tot = new ArrayList<>();
			for (int i = 0; i < order.length(); i++) {

				tot.add(String.valueOf(order.charAt(i)));

				pila.push(String.valueOf(order.charAt(i)));
			}

			casos--;
		}
	}

}
