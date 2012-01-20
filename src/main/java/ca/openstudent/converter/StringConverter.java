package ca.openstudent.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter( value="stringConverter" )
public class StringConverter implements Converter {


    /**
     * converts an Integer to its String representation.
     */
    public String getAsString( FacesContext context, UIComponent component,
                               Object value )
    {
    	try {  
    		int testint = Integer.valueOf((String)value);

    		return String.valueOf( testint );
    	}
    	catch(NumberFormatException nfe) {
    		 throw new IllegalArgumentException( "Cannot use integers and numbers." );
    	}
    	
    }

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return (String)arg2;
	}
}
