package ca.openstudent.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ca.openstudent.dao.ProvinceDao;
import ca.openstudent.dao.impl.ProvinceDaoImpl;
import ca.openstudent.model.Province;

@ManagedBean (name="province")
@SessionScoped
public class ProvinceBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8773572083970721107L;
	
	
	private static ProvinceDao provinceDao = new ProvinceDaoImpl();
	private List<SelectItem> selectProvinces;
	private Province selectedProvince;

	{
        fillSelectItems();
    }

	/*
	 * Getter
	 */
	public List<SelectItem> getSelectProvinces() {
		return selectProvinces;
	}
	
	private void fillSelectItems() {
		selectProvinces = new ArrayList<SelectItem>();
        for (Province prov : provinceDao.list()) {
        	selectProvinces.add(new SelectItem(prov, prov.getName()));
        }

	}

	public Province getSelectedProvince() {
		return selectedProvince;
	}
	
	/*
	 * Setter
	 */
	public void setSelectedProvince(Province selectedProvince) {
		this.selectedProvince = selectedProvince;
	}
}
