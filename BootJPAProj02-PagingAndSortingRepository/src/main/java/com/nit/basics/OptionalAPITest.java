package com.nit.basics;

import java.util.Date;
import java.util.Optional;

public class OptionalAPITest {

	public static Optional<Date> getDateByMonth(int no){
		     if(no>=1 && no<=12)
			      return Optional.of(new Date());
		     else
		    	 return Optional.empty();
	
	}
	public static void main(String[] args) {
		Optional<Date> opt = getDateByMonth(2);
		if(opt.isPresent()) {
			Date d = opt.get();
			System.out.println(" Recived obj: "+d);
	    }
		else {
			System.out.println(" Invalid month ");
		}
	}

}
