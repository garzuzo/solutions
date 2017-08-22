import java.math.BigDecimal;

public class password {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double num=1/101;
		BigDecimal bd=new BigDecimal(1);
		BigDecimal bd1=new BigDecimal(758);
		BigDecimal res=new BigDecimal(0);
		res=bd.divide(bd1);
	
		System.out.println(num);
		
		
		System.out.println(	res.toBigInteger());
		
	}

}
