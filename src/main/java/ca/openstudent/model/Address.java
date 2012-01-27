package ca.openstudent.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author wwhite
 */
@Entity
public class Address implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    
    private Student student;

    public Address() {
    }

    public Address(Long addressId) {
        this.id = addressId;
    }

    public Address(Long addressId, String line1, String city, String region, String country, String postalCode) {
        this.id = addressId;
        this.line1 = line1;
        this.city = city;
        this.province = region;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Long getAddressId() {
        return id;
    }

    public void setAddressId(Long addressId) {
        this.id = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String region) {
        this.province = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Student getClient() {
        return student;
    }

    public void setClient(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ca.openstudent.model.Address[addressId=" + id + "]";
    }

}
