package ca.openstudent.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ca.openstudent.dao.ProvinceDao;
import ca.openstudent.model.Province;

public class ProvinceDaoImpl implements ProvinceDao{

	
	
	private static Map<String, Province> provincesMap;
	
	public List<Province> list() {
		return new ArrayList<Province>(provincesMap.values());
	}

	public Province find(String key) {
		return provincesMap.get(key);
	}
	
	
	{
		this.loadProvincesMap();
	}
	private void loadProvincesMap() {
		provincesMap = new LinkedHashMap<String, Province>();
		
		provincesMap.put("BC", new Province("British Columbia"));
		provincesMap.put("AB", new Province("Alberta"));
		provincesMap.put("SK", new Province("Saskatchewan"));
		provincesMap.put("MB", new Province("Manitoba"));
		provincesMap.put("ON", new Province("Ontario"));
		provincesMap.put("QC", new Province("Quebec"));
		provincesMap.put("NS", new Province("Nova Scotia"));
		provincesMap.put("NB", new Province("New Brunswick"));
		provincesMap.put("NL", new Province("Newfoundland and Labrador"));
		provincesMap.put("PE", new Province("Prince Edward Island"));
		provincesMap.put("NU", new Province("Nunavut"));
		provincesMap.put("NT", new Province("Northwest Territories"));
		provincesMap.put("YT", new Province("Yukon"));

	}

}
