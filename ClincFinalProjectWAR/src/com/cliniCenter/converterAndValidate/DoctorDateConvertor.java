package com.cliniCenter.converterAndValidate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("doctorDateConv")
public class DoctorDateConvertor implements Converter {

	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		doctorDate ();

		if(value != null)
		{
		  try {
			
			  SimpleDateFormat inputFormat=new SimpleDateFormat("dd/MM/yy");
			  Date temp=inputFormat.parse(value.toString());
			  SimpleDateFormat outputFormat=new SimpleDateFormat("dd-MM-yyyy");
			 Date temp1=outputFormat.parse(outputFormat.format(temp));
			  return  temp1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		}
		
		return null;
	}

	
	public void doctorDate (){
		System.out.println();}


	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		FacesMessage sdf;
		
		return null;
	}

}
