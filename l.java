import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class l {
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		
		String linea=lector.readLine();
		
		linea=linea.replace(" ", "");
		linea=linea.replace("+", "");
		linea=linea.replace("=", "");
		
		int num1=Integer.parseInt(linea.charAt(0)+"");
				int num2=Integer.parseInt(linea.charAt(1)+"");
				linea=linea.substring(2, linea.length());
				
				if(num1+num2==Integer.parseInt(linea)){
					
					System.out.println("YES");
				}else
					System.out.println("NO");
		
		
	}

}
