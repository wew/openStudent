package ca.openstudent.validator;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validates that a field has an exact length, when required is false.
 * 
 */
@FacesValidator("exactLengthValidator")
public class ExactLengthValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, 
		Object value) throws ValidatorException {

		//Check if value is not empty
		if ( !value.equals( "" ) ) {

			//The String length of the value Object
			int length = stringValue(value).length();
			
			//The exact length attribute, set in the view component
			String exactLength = (String) component.getAttributes().get("exactLength");
			
			if ( length != Integer.valueOf( exactLength) ) {
			
				//Set summary and details message
				ResourceBundle rb = ResourceBundle.getBundle("messages", 
					context.getViewRoot().getLocale());
				String messageText = rb.getString("exact.length");
				String detailsText =  "Must be exaclty " + 
					exactLength + " digits long. You entered " + 
					length + " digits.";
				
				FacesMessage msg = new FacesMessage(messageText, detailsText);
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				
				throw new ValidatorException(msg);
			}
		}

	}
	
	/**
	 * Return String representation of Object
	 */
    private static String stringValue(Object attributeValue) {
    	
        if (attributeValue == null) {
            return (null);
        } else if (attributeValue instanceof String) {
            return ((String) attributeValue);
        } else {
            return (attributeValue.toString());
        }

    }

}
