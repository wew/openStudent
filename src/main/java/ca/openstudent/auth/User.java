package ca.openstudent.auth;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.SelectableDataModel;

@Entity
public class User  implements SelectableDataModel<Object>
{
    @Id private Long id;  
    private String username;
    private String email;
    private String phone;
    
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String gender;
    private String address;
    
  //  @ManyToMany
   // private Set<Role> roles;
    
    public User()
    {}
    public User(Long userId, String username, String email, String phone,
            Date dob, String gender, String address)
    {
        this.id = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }
    //setter and getters    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public Object getRowData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getRowKey(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}