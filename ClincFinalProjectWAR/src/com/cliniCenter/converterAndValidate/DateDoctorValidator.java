package com.cliniCenter.converterAndValidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("DateDocValidator")
public class DateDoctorValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		
		Date receDate=null;
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String birthDay=sdf.format(arg2);
		try {
			 receDate=sdf.parse(birthDay);
			
          
			Calendar currentDate=Calendar.getInstance();
			
			currentDate.set(Calendar.HOUR_OF_DAY, 0);
			currentDate.set(Calendar.MINUTE ,0);
			currentDate.set(Calendar.SECOND ,0);
			currentDate.set(Calendar.MILLISECOND ,0);
			Calendar receivedDate=Calendar.getInstance();
			receivedDate.setTime(receDate);
	        receivedDate.set(Calendar.HOUR_OF_DAY, 0);	
	        receivedDate.set(Calendar.MINUTE, 0);		
	        receivedDate.set(Calendar.SECOND, 0);		
	        receivedDate.set(Calendar.MILLISECOND, 0);

	        int currentDay=currentDate.get(Calendar.DAY_OF_MONTH);
	        int receivedDay=receivedDate.get(Calendar.DAY_OF_MONTH);
	        
	        
	        int currentMonth=currentDate.get(Calendar.MONTH)+1;
	        int receivedMonth=receivedDate.get(Calendar.MONTH)+1;
	        
	        int diffYears=currentDate.get(Calendar.YEAR)-receivedDate.get(Calendar.YEAR);
	        int diffMonth=currentMonth-receivedMonth;
	        int days=0;
	        if(diffMonth<0)
	        {
	        	diffYears--;
	        	diffMonth=12-currentMonth+receivedMonth;
	        	
	        	System.out.println("years="+diffYears +"months :"+diffMonth);
	        	if(currentDay>receivedDay)
	        	{

	        		diffMonth--;
		        	System.out.println("years="+diffYears +"months ="+diffMonth);

	        	}
	        	
	        }
	        else 
	        	if(diffMonth== 0&& currentDay<receivedDay )
	        	{   diffYears--;
	        		diffMonth=11;
		        	System.out.println("years="+diffYears +"months ="+diffMonth+ "when he months equal Zero");

	        		
	        	}
	        
	        if(diffYears<18)
	        {
	        	
	        	FacesMessage fmg=new FacesMessage("Invalid Age", "your Age is "+diffYears +" years old");
	        	fmg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        	throw new ValidatorException(fmg);
	        }
	        	

	        // calculate the Days
	        if(currentDate.get(Calendar.DATE)>receivedDate.get(Calendar.DATE))
	        {
	        	
	        	
	        	days=currentDate.get(Calendar.DATE)-receivedDate.get(Calendar.DATE);
	        }
	        	else
	       
	        		if(currentDate.get(Calendar.DATE)<receivedDate.get(Calendar.DATE)){
	        			
                     int today=currentDate.get(Calendar.MONTH);
                     currentDate.add(Calendar.MONTH, -1);
                     days=currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)-receivedDate.getActualMaximum(Calendar.DAY_OF_MONTH)+today;
                     
	        			
	        }
	        
	        		else {
	        			days=0;
	        			if(diffMonth==0)
	        			{
	        				diffYears++;
	        				diffMonth=0;
	        				
	        			}
	        		}
	        
	        
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		
		
		
	}
	
	

}
