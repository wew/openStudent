package ca.openstudent.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ca.openstudent.model.Student;

public class StudentDataModel extends LazyDataModel<Student> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Student> studentDao; 
	
	public StudentDataModel(List<Student> studentDao) {  
        this.studentDao = studentDao;  
    }

	@Override
	public List<Student> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, String> filters) {
		List<Student> data = new ArrayList<Student>();
		return data;
	}

}
