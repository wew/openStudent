package ca.openstudent.dao;

import java.util.List;

import ca.openstudent.model.Province;

public interface ProvinceDao {

	public List<Province> list();

	public Province find(String value);

}
