package ca.openstudent.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.ToggleEvent;

import ca.openstudent.model.Student;
import ca.openstudent.service.StudentService;

@ManagedBean (name="studentBean")
@ViewScoped
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Student> studentArrayList = new ArrayList<Student>(); 
	private static List<Student> studentList = new ArrayList<Student>();
	
	private boolean sortAscending = true;
	
	//@ManagedProperty ("#{student}")
	private Student student;

	private StudentService studentService = new StudentService();

	public StudentBean(){
		this.student = new Student(999999999,"", null, "", "", "");
	}
	
	public void handleToggle(ToggleEvent event) {
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());  
		FacesContext.getCurrentInstance().addMessage(null, msg);  

	}  

	public List<Student> getStudentList() {
		return studentArrayList;
	}
	
	public String create() {
		System.out.println("create student");
		if(student != null) {
			this.studentService.create(student);
			/**
			 * @TODO need to clear form, 
			 */
			this.student = new Student(999999999,"", null, "", "", "");
		}
		
		return "";
	}
	
	/**
	 * 
	 * @return Student
	 */
	public Student getStudent() {
		
		return this.student;
	
	}
	
	public void setStudent(Student student) {
		
		System.out.println("set student." + this.student);
	}
	
	public String showDetails(Student student)
    {
		this.student = student;
        return "DETAILS";
    }
	
	public String update()
	{
	  //  student = studentSessionBean.update(student);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
	            "Sucessful", "Record successfully saved!"));
	    return "SAVED";
	}

	public String findByName(AjaxBehaviorEvent event) {
		return "TestName";
	}
	
	/**
	 * action = #{student.getSearchResults}
	 * value  = #{student.searchResults}
	 * @return
	 */
	public String getSearchResults() {
		return "SearchResults.xhtml";
	}
	
	//sort by order no
	public String sortStudentId() {
 
	   if(sortAscending){
 
		//ascending order
		Collections.sort(studentArrayList, new Comparator<Student>() {
 
			@Override
			public int compare(Student s1, Student s2) {
				
				return s1.getId().compareTo(s2.getId());

			}
 
		});
		sortAscending = false;
 
	   }else{
 
		//descending order
		Collections.sort(studentArrayList, new Comparator<Student>() {
 
			@Override
			public int compare(Student s1, Student s2) {
				
				return s2.getId().compareTo(s1.getId());

			}
 
		});
		sortAscending = true;
	   }
 
	   return null;
	}
	
	private String searchString; 
	public void updateStudent(AjaxBehaviorEvent event) { 
        student = studentList.get(2); 
    } 
 
    public String getSearchString() { 
        return searchString; 
    } 
 
    public void setSearchString(String searchString) { 
        this.searchString = searchString; 
    } 
    
    public void getGender() { 
       this.student.getGender();
    } 

    public void setGender(String gender) { 
        this.student.setGender(gender);
     } 
    
    
    
	public String getFullName()
	{
		return this.student.getLegalFirstName() + " " + this.student.getLegalLastName();
	}

	
	
}
