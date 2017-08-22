import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GraphConstruction {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		String caso;
		while (!(caso = lector.readLine()).equals("0")) {

			String[] degrees = caso.split(" ");

			int numVertex = Integer.parseInt(degrees[0]);

			int totalDegrees = 0;

		
			int cuentaGradoImpar = 0;
			for (int i = 1; i < degrees.length; i++) {

				totalDegrees = Integer.parseInt(degrees[i]);

				if (Integer.parseInt(degrees[i]) % 2 != 0)
					cuentaGradoImpar++;
			}

			if (cuentaGradoImpar % 2 != 0)
				System.out.println("Not possible");
			else {
				totalDegrees /= 2;

				if ((numVertex * numVertex - 1) / 2 == totalDegrees)
					System.out.println("Possible");
				else
					System.out.println("Not possible");
			}
		}
	}

}
