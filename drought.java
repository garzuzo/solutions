import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class drought {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);
BufferedWriter escritor=new BufferedWriter(new OutputStreamWriter(System.out));
		int casos = lector.nextInt();

		while (casos > 0) {

			int a = lector.nextInt();
			int n =  lector.nextInt();
			int[] arregloX = new int[n];
			int[] arregloH = new int[n + 1];

			for (int i = 0; i < n; i++) {
				arregloX[i] =  lector.nextInt();
			}
			for (int i = 0; i < n + 1; i++) {
				arregloH[i] =  lector.nextInt();
			}
			long capacidadTotal = 0;
			long xActual = 0;
		
			int hActual = 0;
			int hSiguiente = 0;
			while (hActual < arregloH.length-1) {
					xActual = arregloX[hActual];
				hSiguiente = hActual + 1;
				boolean eraMayor = false;
				int mayor=0;
				while (hSiguiente < arregloH.length && arregloH[hActual] > arregloH[hSiguiente]) {
					if (hSiguiente >= arregloX.length) {
						eraMayor = true;
					} else {
						xActual += arregloX[hSiguiente];
						if(arregloH[hSiguiente]>mayor)
							mayor=arregloH[hSiguiente];
					}
					
					if (hSiguiente + 1 < arregloH.length ){
							if( mayor>= arregloH[hSiguiente + 1] ) {
						if (!eraMayor) {
							xActual -= arregloX[hSiguiente];
						}
						hActual = hSiguiente;
						break;
					}
					}else{
						hActual = hSiguiente;
						break;
					}
			
					hSiguiente++;

				}

				capacidadTotal += xActual * a * arregloH[hActual];
				hActual = hSiguiente;
			
			}
escritor.write(capacidadTotal+"\n");
			casos--;
		}
		escritor.close();

	}

}
