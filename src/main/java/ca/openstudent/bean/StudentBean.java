package ca.openstudent.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import java.util.Collections;
import java.util.Comparator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.ToggleEvent;

import ca.openstudent.Student;

@ManagedBean (name="student")
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Student> studentArrayList; 
	private static List<Student> studentList;
	
	private boolean sortAscending = true;
	
	//@ManagedProperty ("#{student}")
	private Student student;

	public StudentBean(){

		studentArrayList = studentList;

	}
	
	public void handleToggle(ToggleEvent event) {
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());  
		FacesContext.getCurrentInstance().addMessage(null, msg);  

	}  

	
	public List<Student> getStudentList() {
		return studentArrayList;
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public Student getDetails() {
		return student;
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

	
	public Integer getCurrentAge() {
		return this.getCurrentAge(null);
	}
	 /**
		 * Convenience method: calculates the person's age on a given date based on the birthdate
		 * 
		 * @param onDate (null defaults to today)
		 * @return int value of the person's age
		 * @should get age before birthday
		 * @should get age on birthday with no minutes defined
		 * @should get age on birthday with minutes defined
		 * @should get age after birthday
		 * @should get age after death
		 * @should get age with given date after death
		 * @should get age with given date before death
		 * @should get age with given date before birth
		 */
		private Integer getCurrentAge(Date onDate) {
			
			if (onDate == null)
				return null;
			
			// Use default end date as today.
			Calendar today = Calendar.getInstance();
			// But if given, use the given date.
			if (onDate != null)
				today.setTime(onDate);
			
			// If date given is after date of death then use date of death as end date
			//if (getDeathDate() != null && today.getTime().after(getDeathDate())) {
			//	today.setTime(getDeathDate());
			//}
			
			Calendar bday = Calendar.getInstance();
			bday.setTime(this.student.getBirthdate());
			
			int age = today.get(Calendar.YEAR) - bday.get(Calendar.YEAR);
			
			// Adjust age when today's date is before the person's birthday
			int todaysMonth = today.get(Calendar.MONTH);
			int bdayMonth = bday.get(Calendar.MONTH);
			int todaysDay = today.get(Calendar.DAY_OF_MONTH);
			int bdayDay = bday.get(Calendar.DAY_OF_MONTH);
			
			if (todaysMonth < bdayMonth) {
				age--;
			} else if (todaysMonth == bdayMonth && todaysDay < bdayDay) {
				// we're only comparing on month and day, not minutes, etc
				age--;
			}
			
			return age;
		}
}
