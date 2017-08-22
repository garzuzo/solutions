import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AutomaticAnswer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(lect.readLine());
		int numActual;
		while (casos > 0) {

			numActual = Integer.parseInt(lect.readLine());

			numActual = (((((((numActual * 567) / 9) + 7492) * 235) / 47) - 498) % 100);

			numActual /= 10;
			if (numActual < 0) {
				numActual *= -1;
			}
			System.out.println(numActual);

			casos--;
		}
	}

}
