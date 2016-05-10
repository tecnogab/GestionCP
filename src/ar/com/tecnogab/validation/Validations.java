package ar.com.tecnogab.validation;

public class Validations {

	public static boolean isDigit(char p_char){
		boolean l_flag = false;
		// Check if the pressed key is not a digit
	      if(((p_char < '0') || (p_char > '9')) && (p_char != '\b' )){
	    	  l_flag = true;
	      }	
	      return l_flag;
	}
}
