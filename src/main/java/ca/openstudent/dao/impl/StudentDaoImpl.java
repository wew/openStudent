package ca.openstudent.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ca.openstudent.Name;
import ca.openstudent.dao.BaseDAO;
import ca.openstudent.model.Student;

public class StudentDaoImpl extends BaseDAO {

	private StudentDaoImpl() {
	}
	
	public static class Factory {

		private final static StudentDaoImpl INSTANCE = new StudentDaoImpl();

		public static StudentDaoImpl getInstance() {
			return INSTANCE;
		}
	}


	public boolean delete(Long id) {
		return delete(id, Student.class);
	}

	public Student findById(Long id) {
		return (Student) findById(id, Student.class);
	}

	public List<?> findAll() {
		return  findAll("FROM Student");
	}


	/**
	 * StudentDAO
	 */
	private static Map<Long, Student> STUDENTS_TABLE = null;
	{
		this.loadStudentsMap();
	}
	
	/**
	 * Find by name
	 * 
	 * @param String name
	 * @return List<Student> nameList
	 */
	public List<String> findByName(String name) {
		
		List<String> nameList = new ArrayList<String>();
		
		for(Entry<Long, Student> e : STUDENTS_TABLE.entrySet()) {
			
			Student s = (Student)e.getValue();
			String tempName = "";
			if( s.getLegalFirstName().toLowerCase().startsWith(name.toLowerCase())) {
				tempName = s.getLegalFirstName();
			}
			else if( s.getLegalLastName().toLowerCase().startsWith(name.toLowerCase())) {
				tempName = s.getLegalLastName();
			}
			else if( s.getLegalMiddleName().toLowerCase().startsWith(name.toLowerCase())) {
				tempName = s.getLegalMiddleName();
			}
			else if( s.getUsualLastName().toLowerCase().startsWith(name.toLowerCase())) {
				tempName = s.getUsualLastName();
			}
			else if( s.getUsualFirstName().toLowerCase().startsWith(name.toLowerCase())) {
				tempName = s.getUsualFirstName();
			}
		
			if( !nameList.contains(tempName) && !tempName.equals("") ) {
				//Only add if not already in list or if not empty
				nameList.add(tempName);
			}
		}
		
		return nameList;
	}
	
	public List<Student> findByGender(String gender) {
		List<Student> studentGenderList = new ArrayList<Student>();
		
		for(Entry<Long, Student> e : STUDENTS_TABLE.entrySet()) {
			Student s = (Student)e.getValue();
			
			if(s.getGender().toLowerCase().equals(gender.toLowerCase())) {
				studentGenderList.add(s);
			}
		}
		
		return studentGenderList;
	}
	
	public List<Student> findStudentsByName(String name, String gender) {
		List<Student> studentList = new ArrayList<Student>();
		List<Student> listToSearch = new ArrayList<Student>();
		if(gender == null ) {
			listToSearch =  new ArrayList<Student>(STUDENTS_TABLE.values());
		}
		else listToSearch = this.findByGender(gender);
	
		
		for (Student s : listToSearch) {
			Student tempStudent = null;
			if( s.getLegalFirstName().toLowerCase().startsWith(name.toLowerCase())) {
				tempStudent = s;
			}
			else if( s.getLegalLastName().toLowerCase().startsWith(name.toLowerCase())) {
				tempStudent = s;
			}
			else if( s.getLegalMiddleName().toLowerCase().startsWith(name.toLowerCase())) {
				tempStudent = s;
			}
			else if( s.getUsualLastName().toLowerCase().startsWith(name.toLowerCase())) {
				tempStudent = s;
			}
			else if( s.getUsualFirstName().toLowerCase().startsWith(name.toLowerCase())) {
				tempStudent = s;
			}
		
			if( !studentList.contains(tempStudent) && tempStudent != null ) {
				//Only add if not already in list or if not empty
				studentList.add(tempStudent);
			}
		}
		return studentList;
	}
	
	
	private void loadStudentsMap() {
		
		//key id
		int i = 0;
		
		//Students dummy table, representing actual database table of students
		STUDENTS_TABLE = new LinkedHashMap<Long, Student>();
	
		//STUDENTS_TABLE.put(key, new Student( PEN, "Male", Birthdate new Date(), "Warren", "E", "White"));
		STUDENTS_TABLE.put((long) ++i, new Student( i, "Male", new Date(),"Administrator", "A", "Admin"));
		STUDENTS_TABLE.put((long) ++i, new Student( i, "Male", new Date(), "Warren", "E", "WHite" ));
		STUDENTS_TABLE.put((long) ++i, new Student( i, "Female", new Date(), "Mr.", "D", "Skunk"));
        STUDENTS_TABLE.put((long) ++i, new Student( i, "Male", new Date(), "Tim", "", "Agnew")); 
        STUDENTS_TABLE.put((long) ++i, new Student( i, "Male", new Date(), "Gregg", "", "Ferrie")); 
       
        List<Name> names = new ArrayList<Name>();
        Name tempName = new Name();
        for(; i < tempName.getLastNameListSize(); i++) {

    	   String gender = "Female";
    	   if( (i % 2) == 0) {
    		  gender = "Male";
    	   }
    	   STUDENTS_TABLE.put((long) i, new Student(i, gender, new Date(), tempName.getFirstNameList().get(i), "", tempName.getLastNameList().get(i) )); 
   
       }
	}
}

