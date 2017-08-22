
import java.math.BigInteger;
import java.util.Scanner;

public class YouCanSay11 {

	public static void main(String[] args) {

		
		Scanner lector = new Scanner(System.in);
		String num1;
		
		while (!(num1 = lector.next()).equals("0")) {

			BigInteger num=new BigInteger(num1);
			BigInteger m=new BigInteger("11");
			BigInteger resultado=num.mod(m);
				if (resultado.toString().equals("0")) {
					System.out.println(num1 + " is a multiple of 11.");
				} else {
					System.out.println(num1 + " is not a multiple of 11.");
				}
			

	}
	}

}
