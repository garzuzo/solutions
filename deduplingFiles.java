import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class deduplicating {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner lector = new Scanner(System.in);

        while (true) {
            int casoActual = lector.nextInt();

            if (casoActual == 0)
                break;

            lector.nextLine();

            HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();

            long numColisiones = 0;
            long numArchivosUnicos = 0;
            for (int i = 0; i < casoActual; i++) {

                String cadenaActual = lector.nextLine();

                int hash = metodoHash(cadenaActual);

                if (hm.containsKey(hash)) {

                    ArrayList<String> listaActual = hm.get(hash);
                    int tam = listaActual.size();
                    boolean entro=false;
                    boolean repetido=false;
                    for (int j = 0; j < tam; j++) {

                        if (!listaActual.get(j).equals(cadenaActual)) {

                            numColisiones++;
                        entro=true;

                        }else{
                        repetido=true;  
                        }

                    }

                    if(entro && !repetido){
                        hm.get(hash).add(cadenaActual);
                        numArchivosUnicos++;
                    }
                } else {

                    ArrayList<String> nl = new ArrayList<String>();
                    nl.add(cadenaActual);
                    hm.put(hash, nl);
                    numArchivosUnicos++;
                }

            }

            System.out.println(numArchivosUnicos + " " + (numColisiones));

        }
        lector.close();

    }

    public static int metodoHash(String cadena) {

        int resultado = 0;

        for (int i = 0; i < cadena.length(); i++) {

            resultado ^= (int) cadena.charAt(i);

        }

        return resultado;
    }

}
