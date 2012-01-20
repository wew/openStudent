/**
 * District for Province that will include schools.
 */
package ca.openstudent;

import java.util.List;
import java.util.ArrayList;

import ca.openstudent.School;

/**
 * @author wwhite
 *
 */
public class District {

	private String name;
	private String abbreviation;
	private int number;

	private List<School> schools = new ArrayList<School>();

	/**
	 * 
	 * @param name
	 * @param number
	 */
	public District(String name, int number) {
		this(name, null, number);
	}
	
	public District(String name, String abbreviation, int number) {
		
		//create the abbreviation if none given.
		if( abbreviation == null) {
			abbreviation = "SD".concat(Integer.toString(number));
		}
		
		this.setName(name);
		this.setAbbreviation(abbreviation);
		this.setNumber(number);
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
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

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "District [name=" + name + ", abbreviation=" + abbreviation
				+ ", number=" + number + "]";
	}

	public void addSchool(School school) {
		this.schools.add(school);
	}

	/**
	 * @return the schools
	 */
	public List<School> getSchools() {
		return schools;
	}

	/**
	 * @param schools the schools to set
	 */
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

}
