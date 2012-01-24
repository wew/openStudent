package ca.openstudent.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ca.openstudent.dao.ProvinceDao;
import ca.openstudent.dao.impl.ProvinceDaoImpl;
import ca.openstudent.model.Province;

public class ProvinceConverter implements Converter {

	private static ProvinceDao provinceDAO = new ProvinceDaoImpl();
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return provinceDAO.find( value );
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Province) value).getName();
	}

}
