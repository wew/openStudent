/**
 * 
 */
package ca.openstudent.model;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author wwhite
 *
 */
@Entity
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private int pen;
	
	private String legalLastName;
	private String legalFirstName;
	private String legalMiddleName;
	
	private String usualLastName;
	private String usualFirstName;
	private String usualMiddleName;
	
	private String gender = "";
	
	private int grade;
	
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Temporal(TemporalType.DATE)
	private Date admitDate;
	
	@Temporal(TemporalType.DATE)
	private Date registrationDate;

	static final int UNREGISTERED = 0;
	static final int REGISTERED = 1;
	static final int WITHDRAWN = -1;
    
	private String postalCode;
	
	private static long count = 111111;
	
	private Address homeAddress;
	
	private Address mailAddress;

	public Student(int pen, String gender, Date birthdate, String legalFirstName, String legalMiddleName, String legalLastName) {
		this(pen, gender, birthdate, legalFirstName, legalMiddleName, legalLastName,"", "", "");
	}
	
	/**
	 * 
	 * @param id
	 * @param pen
	 * @param gender
	 * @param birthdate
	 * @param legalFirstName
	 * @param legalMiddleName
	 * @param legalLastName
	 * @param usualFirstName
	 * @param usualMiddleName
	 * @param usualLastName
	 */
	public Student(int pen, String gender, Date birthdate, String legalFirstName, String legalMiddleName, String legalLastName,  String usualFirstName, String usualMiddleName, String usualLastName) {
		this.id = count++;
		this.pen = pen;
		
		this.gender = gender;
		this.birthdate = birthdate;
		
		this.legalFirstName = legalFirstName;
		this.legalMiddleName = legalMiddleName;
		this.legalLastName = legalLastName;
		
		this.usualFirstName = usualFirstName;
		this.usualMiddleName = usualMiddleName;
		this.usualLastName = usualLastName;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getPen() {
		return pen;
	}

	public void setPen(int pen) {
		this.pen = pen;
	}

	public String getLegalLastName() {
		return legalLastName;
	}

	public void setLegalLastName(String legalLastName) {
		this.legalLastName = legalLastName;
	}

	public String getLegalFirstName() {
		return legalFirstName;
	}

	public void setLegalFirstName(String legalFirstName) {
		this.legalFirstName = legalFirstName;
	}

	public String getLegalMiddleName() {
		return legalMiddleName;
	}

	public void setLegalMiddleName(String legalMiddleName) {
		this.legalMiddleName = legalMiddleName;
	}

	public String getUsualLastName() {
		return usualLastName;
	}

	public void setUsualLastName(String usualLastName) {
		this.usualLastName = usualLastName;
	}

	public String getUsualFirstName() {
		return usualFirstName;
	}

	public void setUsualFirstName(String usualFirstName) {
		this.usualFirstName = usualFirstName;
	}

	public String getUsualMiddleName() {
		return usualMiddleName;
	}

	public void setUsualMiddleName(String usualMiddleName) {
		this.usualMiddleName = usualMiddleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getFullName()
	{
		return this.legalFirstName + " " + this.legalLastName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

    /**
     * The student ID is unique for each Student. So this should compare Student by ID only.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        return (other instanceof Student) && (id != null) ? id.equals(((Student) other).id) : (other == this);
    }
    /**
     * public boolean equals(Object object)
	{
		boolean isTrue = false;
		if(object instanceof Student)
		{
			Student student = (Student) object;
			isTrue = (getPen() == student.getPen());
		}
		
		return isTrue;
	}
	
     */

    /**
     * The student ID is unique for each Student. So Student with same ID should return same hashcode.
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
    }

    /**
     * Returns the String representation of this Student. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return String.format("Student[id=%d, legalFirstName=%s, legalLastName=%s, dateOfBirth=%s, PEN=%d]", 
            id, legalFirstName, legalLastName, birthdate, pen);
    }

	/**
	 * @return the homeAddress
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the mailAddress
	 */
	public Address getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(Address mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	/**
	 * 
	 * @return Integer current age
	 */
	public Integer getCurrentAge() {

		return this.getCurrentAge(this.birthdate);
	
	}

	/**
	 * Calculates current age given birth date.
	 * @param onDate
	 * @return Integer age
	 */
	private Integer getCurrentAge(Date birthDate) {
		
		if (birthDate == null)
			return null;
		
		Calendar today = Calendar.getInstance();
		Calendar bday = Calendar.getInstance();
		
		today.setTime(new Date());
		bday.setTime(birthDate);
		
		int age = today.get(Calendar.YEAR) - bday.get(Calendar.YEAR);

		if (today.get(Calendar.MONTH) < bday.get(Calendar.MONTH)) {
			age--;
		} else if (today.get(Calendar.MONTH) == bday.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < bday.get(Calendar.DAY_OF_MONTH)) {
			
			age--;
		}
		
		return age;
	}
}
