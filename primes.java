import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class primes {

	public static void main(String[] args) throws IOException {

		boolean[] sieve = new boolean[1000001];
	
		sieve[0] = sieve[1] = true;

		for (int i = 2; i * i <= 1000000; i++) {

			if (!sieve[i]) {
				
				for (int j = i * i; j <= 1000000; j += i) {
					sieve[j] = true;
				}
			}
		}
		

		Scanner lector = new Scanner(System.in);
	
		BufferedWriter esc=new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			int n = lector.nextInt();
			if (n == 0)
				break;
			for (int i = 3; i <= n/2; i++) {
				if (sieve[i]==false && sieve[n-i]==false) {
						esc.write(n + " = " + i + " + " + (n-i) + "\n");
						break;
					

				}
			}
		
			
		}
		esc.flush();
	}

}
