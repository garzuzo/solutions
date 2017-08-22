

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

 class p1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		for (int i = 0; i <= 25; i++) {
			hm.put(letras[i], i);
		}
		String cipherText = lector.readLine();
		String key = lector.readLine();
		String respuesta="";
		for (int i = 0; i < cipherText.length(); i++) {
			int valor=hm.get(key.charAt(i)+"");
			int valor1=hm.get(cipherText.charAt(i)+"");
			
			int suma=valor1-valor;
			if(suma<0){
				suma=(25+valor1+1)-valor;
			}
			if(cipherText.length()>key.length()){
				key+=letras[suma];
			}
			respuesta+=letras[suma];
		}
		System.out.println(respuesta);
	}
}
