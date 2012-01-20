package ca.openstudent.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;

import ca.openstudent.Student;
import ca.openstudent.service.StudentService;

@ManagedBean(name="studentSearch")
public class StudentSearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4818217028330965256L;
	private String gender;
	private String name;
	private Date dob;
	private String dobString;
	private String pen;
	private String id;
	
	private Student selectedStudent;
	private int keyCode; 
	
	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	private boolean rendered = false;
	
	private static List<Student> students; 
	private List<Student> results; 
	
    private final static String EDIT_STUDENT = "views/student/edit.xhtml";
    private final static String SEARCH_STUDENTS = "views/student/search.xhtml";
	
    StudentService studentService = new StudentService();
    
	public StudentSearchBean() {
		super();
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	//Business action
	public void clear(ActionEvent e) {
		System.out.println("clear StudentSearchBean business action called");
	}
	
	//Listener action
	public void clear(AjaxBehaviorEvent abe) {
		System.out.println("clear StudentSearchBean listener action called");
    }
	
	public List<Student> getStudents() {
		
		return students;		
	}
	
	public List<Student> getResults() {
		
		return results;		
	}
	
	/**
	 *
	 *
	 *@todo Need to search names, DOB, Student ID,and PEN
	 *
		1. Search ANY name {not case sensitive}
		2. Gender {radio button, narrows search from field 1}
		3. Date of birth {Hyphens added automatically, not case sensitive, month is first 3 characters of the month name, search 45 days on each side of birthdate}
		4. Student ID number_ {carry over from BCeSIS, currently 6 & 7 digit numbers}_
		5. PEN {9 character field only}
		
	 * @return
	 */
	public String search() {

		System.out.println("StudentSearchBean search()");
		rendered = true;

		results = null;

		results = studentService.searchStudents(this.name, this.gender);

		if (results.isEmpty()) {
			rendered = false;
		}

		return SEARCH_STUDENTS;
	}

	 public String updateStudentList(AjaxBehaviorEvent abe) {
		 System.out.println("UpdateStudentLIst function");
		 
		 return "update student list";
	 }

	/**
	 * @return the dob
	 */
	public Date getDob() {

		return dob;
	}

	/**
	 * Add hyphens to the Date of Birth String
	 * 
	 * @TODO need to capture backspaces, and not append
	 * 
	 * @param abe
	 */
	private static int prevcount = 0;
	public void addHyphensToDOB(AjaxBehaviorEvent abe) {
		if(prevcount >= dobString.length())
		{
			prevcount--;
			return;
		}
		StringBuilder stb = new StringBuilder(dobString);
	
		if(dobString.length() == 2) {
			//if dd append - so, dd-
			stb.append('-');
		}
		else if(dobString.length() == 6) {
			//if dd-MMM append - so, dd-MMM-
			stb.append('-');
		}
		
		dobString = stb.toString().toUpperCase();
		prevcount = dobString.length();
	}
	
	public void addHyphensToDOBDate(AjaxBehaviorEvent abe) {
	
	}
	
	/**
	 * Ajax call find student name.
	 * 
	 * @param AjaxBehaviorEvent abe
	 */
	public void findByName(AjaxBehaviorEvent abe) {
		
		if(name.length() < 3) return;

		rendered = true;
		results = studentService.findStudentsByName(this.name);
		
		if(results.isEmpty()) {
			rendered = false;
		}
		System.out.println("FindByName AjaxBehaviorEvent called");
		
	}
	
	/**
	 * Find Students Full Name from any name.
	 * 
	 * @param String nameToFind
	 * @return
	 */
	public List<String> completeFindByName(String nameToFind) {  
	 
		return studentService.findByName(nameToFind);
	      
	}  

	public Student getSelectedStudent() {  
		 return selectedStudent;  
	}  

	public void setSelectedStudent(Student selectedStudent) {  

			this.selectedStudent = selectedStudent;  
	}  


	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the pen
	 */
	public String getPen() {
		return pen;
	}

	/**
	 * @param pen the pen to set
	 */
	public void setPen(String pen) {
		this.pen = pen;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the rendered
	 */
	public boolean isRendered() {
		return rendered;
	}

	/**
	 * @param rendered the rendered to set
	 */
	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	/**
	 * @return the dobString
	 */
	public String getDobString() {
		return dobString;
	}

	/**
	 * @param dobString the dobString to set
	 */
	public void setDobString(String dobString) {
		this.dobString = dobString;
	}
	
	 public void validateStudentID( FacesContext context, 
			  UIComponent componentToValidate,
			  Object value) throws ValidatorException {
		 
		 if( ((String)value).isEmpty() )
	    	{
	    		return;
	    	}
	    	
	    	if( ((String)value).length() < 6 )
	    	{
	    		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
	    				"Student ID must be 6 or 7 digits in length", "Student ID must be more than 5.");
	    		throw new ValidatorException(message);
	    	}
	    	if( ((String)value).length() > 7)
	    	{
	    		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
	    				"Student ID must be 6 or 7 digits in length", "Student ID must be less than 8.");
	    		throw new ValidatorException(message);
	    	}
	 }
}
