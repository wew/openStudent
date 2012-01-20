package ca.openstudent.auth;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * 
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

    private static final long serialVersionUID = 916055190609044881L;

    /**
     * Default constructor.
     */
    public SessionBean() {
    }

    /**
     * 
     * @return
     */
    public String getPrincipal() {
    	
    	FacesContext context = FacesContext.getCurrentInstance(); 
		String principal;
		try {
			principal = context.getExternalContext().getUserPrincipal().toString();
		} catch (Exception e) {
			//Go to login page
			return "login";
		}
    	return principal;
    }
    
    /**
     * Logs the current user out by invalidating the session.
     * @return &quot;logout&quot; which is used by the {@literal faces-config.xml}
     * to redirect back to the {@literal index.xhtml} page.
     */
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        return "logout";
    }
}
