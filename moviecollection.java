import java.util.Scanner;
import java.util.Stack;

public class moviecollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);
		int numTests = lector.nextInt();
		lector.nextLine();
		while (numTests > 0) {

			int numMovies = lector.nextInt();
			int numRequests = lector.nextInt();
			lector.nextLine();
			Stack<Integer> pila = new Stack<Integer>();

			Stack<Integer> pilaAux = new Stack<Integer>();
			for (int i = numMovies; i >0 ; i--) {
				pila.push(i);

			}
			String answerAct = "";
			for (int i = 0; i < numRequests; i++) {
				int reqAct = lector.nextInt();
				int posActual = 0;
				

				int tam=pila.size();
				for (int j = 0; j < tam; j++) {

					if (pila.peek() == reqAct) {
						pila.pop();
						if(i+1<numRequests)
						answerAct += posActual + " ";
						else
							answerAct += posActual;	
						break;
					} else {
						posActual++;
						pilaAux.push(pila.pop());
					}
				}
				int tam1 = pilaAux.size();
				for (int j = 0; j < tam1; j++) {

					pila.push(pilaAux.pop());
				}
				pila.push(reqAct);
				

				
			}
			
			System.out.println(answerAct);
			lector.nextLine();

			numTests--;
		}

	}

}
