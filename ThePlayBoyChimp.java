import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThePlayBoyChimp {

	public static void main(String[] args) throws IOException {

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(lect.readLine());

		String[] Nnum = lect.readLine().split(" ");
		int[] Nnumbers = new int[Nnum.length];
		for (int i = 0; i < Nnumbers.length; i++) {
			Nnumbers[i] = Integer.parseInt(Nnum[i]);
		}
		int Q = Integer.parseInt(lect.readLine());
		String[] Qnum = lect.readLine().split(" ");
		int[] QNumbers = new int[Qnum.length];

		for (int i = 0; i < QNumbers.length; i++) {
			QNumbers[i] = Integer.parseInt(Qnum[i]);

			String n1 = menor(Nnumbers, QNumbers[i], 0, 0, 0, Nnumbers.length - 1);
			String n2 = mayor(Nnumbers, QNumbers[i], 0, 0, 0, Nnumbers.length - 1);
			System.out.println(n1 + " " + n2);

		}
		

	}

	public static String mayor(int[] arreglo, int num, int mid, int temp, int inicio, int fin) {

		if (arreglo[mid] == num) {

			try {
				return arreglo[mid + 1] + "";
			} catch (Exception e) {
				return "X";
			}

		} else if (mid == fin) {
			if (arreglo[mid] <= num) {
				return "X";
			} else
				return temp + "";
		} else {
			int mitad = (inicio + fin) / 2;
			temp = arreglo[mitad];
			if (num <= arreglo[mitad]) {

				if (mitad - 1 > -1 && arreglo[mitad - 1] >= num) {
					return mayor(arreglo, num, mitad, temp, 0, mitad);
				} else{
					if(num>=arreglo[mitad-1] && num<arreglo[mitad]){
						return arreglo[mitad]+"";
					}else{
						return mayor(arreglo, num, mitad, temp, mitad + 1, fin);
					}
				}
					

			} else {
				if (mitad - 1 > -1 && arreglo[mitad - 1] >= num) {
					return menor(arreglo, num, mitad-1, temp, 0, mitad);
				} else
					return mayor(arreglo, num, mitad, temp, mitad + 1, fin);
			}
		}

	}

	public static String menor(int[] arreglo, int num, int mid, int temp, int inicio, int fin) {

		if (arreglo[mid] == num) {

			try {
				return arreglo[mid - 1] + "";
			} catch (Exception e) {
				return "X";
			}

		} else if (mid == fin) {
			if (arreglo[mid] >= num) {
				return "X";
			} else
				return temp + "";
		} else {
			int mitad = (inicio + fin) / 2;
			temp = arreglo[mitad];
			if (num >= arreglo[mitad]) {

				if (arreglo.length > mitad + 1 && num >= arreglo[mitad + 1]) {
					return menor(arreglo, num, mitad, temp, mitad + 1, fin);
				} else {
					if(num<=arreglo[mitad+1] && num>arreglo[mitad]){
						return arreglo[mitad]+"";
				}else{
					
					return menor(arreglo, num, mitad, temp, 0, mitad);
				}

			}
				} else {

				if (mitad - 1 > -1 && arreglo[mitad - 1] <= num) {
					return menor(arreglo, num, mitad-1, temp, 0, mitad);
				} else
					return menor(arreglo, num, mitad, temp, mitad + 1, fin);
			}
		}

	}

}