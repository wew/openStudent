package ca.openstudent;

public class School {

	private String name;
	private int code;
	private District district;
	
	/**
	 * Create a school given name and code.
	 * 
	 * @param name
	 * @param code
	 */
	public School(String name, int code) {
		this.name = name;
		this.code = code;
	}
	
	public School(String name, String code) {
		this.name = name;
		this.code = Integer.parseInt(code);
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setCode(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return this.code;
	}

	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [name=" + name + ", code=" + code + ", district="
				+ district + "]";
	}

}
