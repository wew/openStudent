package ca.openstudent.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter( value="birthdateConverter" )
public class BirthDateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		System.out.println("Get As Object Birthdate Converter." + value);
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		Object date = null;
		
		if(value.length() == 2) {
			//if dd append - so, dd-
			value.concat("-");
		}
		else if(value.length() == 6) {
			//if dd-MMM append - so, dd-MMM-
			value.concat("-");
		}
		
		if(value.length() < 11 ) return value;
		
		
		//check days
		//check months
		//check year
		
		try {
			
			date = df.parse(value);
			return date;
		} catch (ParseException e) {

			return value;
		}
		
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if (value == null) {
             return "";
         }

         // If the incoming value is still a string, play nice
         // and return the value unmodified
         if (value instanceof String) {
             return (String) value;
         }
         DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
         try {
        	 
         // Perform the requested formatting
         df.format(value).toUpperCase();
	 } catch (ConverterException e) {
        System.out.println("ERROR1");
     } catch (Exception e) {
         System.out.println("ERROR2");
     }
	
         return  df.format(value).toUpperCase();
	}

}
