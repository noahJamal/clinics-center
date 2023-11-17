package com.cliniCenter.converterAndValidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("UserClinic.userEmailValidate")
public class CustomEmailValidator implements Validator {

	public static final String Email_Pattern="^[_A-Za-z0-9-]+(\\." +
		      "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
		      "(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	private Matcher matcher;
	
	public CustomEmailValidator()
	{
		pattern=Pattern.compile(Email_Pattern);
	}
	
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		
		matcher=pattern.matcher(arg2.toString());
		
		if(!matcher.matches())
		{
			FacesMessage msg=new FacesMessage("Email Validation Failed", "your Email Must end @EmailName.com");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Message Content"));
		}
	}

}
