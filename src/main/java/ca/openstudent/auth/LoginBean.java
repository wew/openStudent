package ca.openstudent.auth;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1412415200600426717L;
	private String name;
	private String password;
	private User current;
	
	public String getName()
	{
		return name;
	}
	
	public void setName (final String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setPassword (final String password) 
	{
		this.password = password;
	}
	
	public String login() {
		 //String summary = "Login succesfully!";
		 //getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null));
		Marker fatal = MarkerFactory.getMarker("FATAL");    
		Logger logger = LoggerFactory.getLogger("Test LOGGER"); 
		
		FacesContext context = FacesContext.getCurrentInstance(); 
		
		logger.error(fatal, "User Principal",context.getExternalContext().getUserPrincipal());   
		logger.error(fatal, "ERROR CODE", context.getExternalContext().getRemoteUser());   

		return "FAIL";
	}

	public boolean isLoggedIn() 
	{ 
	        return current != null; 
	} 

    /**
     * Logs the current user out by invalidating the session.
     * @return &quot;logout&quot; which is used by the {@literal faces-config.xml}
     * to redirect back to the {@literal index.xhtml} page.
     * @throws IOException 
     */
    public String logout() throws IOException 
    {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       
        externalContext.invalidateSession();
       
        return "LOGOUT";
    }

    /**
     * 
     * @return
     */
    public String getPrincipal() 
    {
    	FacesContext context = FacesContext.getCurrentInstance(); 
		String principal;
		try {
			principal = context.getExternalContext().getUserPrincipal().toString();
		} catch (Exception e) {
			//Go to login page
			return "welcome.xhtml";
		}
    	return principal;
    }
	/*
	  HttpServletRequest#login() 
	  public void login() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	    try {
	        request.login(this.username, this.password);
	        this.user = userDAO.find(this.username, this.password);
	    } catch (ServletException e) {
	        // Handle unknown username/password in request.login().
	        context.addMessage(null, new FacesMessage("Unknown login"));
	    }
	}*/

	
}
