import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LightmoreLight {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		long caso;
		while ((caso = Long.parseLong(lector.readLine())) != 0) {

			boolean ret = false;
			for (long i = 1; i <=caso; i++) {
				if(caso%i==0){
				if (!ret)
					ret = true;
				else
					ret = false;
				}
			}
			if (ret)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

}
