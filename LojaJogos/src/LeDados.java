import java.util.Scanner;
import java.io.IOException;

public class LeDados {
	
	public static int leInt() {
		
		Scanner scInt = new Scanner(System.in);
				
		int i = 0;
		
			try {
				System.out.println("Insira um numero inteiro: ");
				i = scInt.nextInt();
			
			} catch (Exception e) {
				System.out.println("Insira um valor válido!");
				i = leInt();
			}
			
		return i;
	
	}
		
	
	
	public static float leFloat() {
		
		Scanner scFloat = new Scanner(System.in);
		
		float f = 0;
				
		try {
			System.out.println("Insira um numero real: ");
			f = scFloat.nextFloat();
		
		} catch(Exception e) {
			System.out.println("Insira um valor válido!");
			f = leFloat();
		}
		
		return f;
		
	}
	
	public static char leChar() {
		
		char c = 'a';
		
	    try {
	    	System.out.println(": ");     
	    	c = (char) System.in.read();
        
	    } catch (Exception e) {
	    	System.out.println("Insira um valor válido!");
			c = leChar();
	    }
	            
		return c;
					
	}

	public static String leString() {
		
		Scanner scString = new Scanner(System.in);
		
		String s = "0";
		
		try {
			System.out.println(": ");
			s = scString.nextLine();
		
		} catch (Exception e) {
			System.out.println("Insira um valor válido!");
			s = leString();
		}
		
		return s;
			
	}	
	
}
