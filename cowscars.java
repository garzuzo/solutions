import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class cowscars {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String caso;

		while ((caso = br.readLine()) != null) {

			String[] act = caso.split(" ");
			double nCows = Integer.parseInt(act[0]);
			double nCars = Integer.parseInt(act[1]);
			double nShows = Integer.parseInt(act[2]);

			double tot = nCows + nCars;
			double menosUno = nCows + nCars -nShows- 1;

			double mult1 = (nCows / tot) * (nCars / menosUno);
			double mult2 = (nCars / tot) * ((nCars - 1) / menosUno);
			DecimalFormat df = new DecimalFormat("0.00000");

			String res = df.format((double) mult1 + mult2);
			res = res.replace(",", ".");
			System.out.println(res);

		}
	}

}
