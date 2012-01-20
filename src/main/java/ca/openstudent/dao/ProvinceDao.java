package ca.openstudent.dao;

import java.util.List;

import ca.openstudent.Province;

public interface ProvinceDao {

	public List<Province> list();

	public Province find(String value);

}
