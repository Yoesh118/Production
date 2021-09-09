/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "company_address", catalog = "production", schema = "")
@XmlRootElement
public class CompanyAddress extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String companyAddressId;
    private String city;
    private String address1;
    private String address2;
    private boolean status = true;
    private AddressType addressType;
    private Company company;

    public CompanyAddress() {
    }

    public CompanyAddress(String companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public CompanyAddress(String companyAddressId, String city, String address1, String address2, boolean status) {
        this.companyAddressId = companyAddressId;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.status = status;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "company_address_id", nullable = false, length = 36)
    public String getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(String companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    @Basic(optional = false)
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic(optional = false)
    @Column(name = "address1", nullable = false, length = 255)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic(optional = false)
    @Column(name = "address2", nullable = false, length = 50)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Transient
    public String getPreferred() {
        String preferred = status ? "Active" : "Inactive";
        return preferred;
    }

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @JoinColumn(name = "address_type_id", referencedColumnName = "address_type_id", nullable = false)
    @ManyToOne(optional = false)
    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @XmlTransient
    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof CompanyAddress)) {
            return false;
        }
        return this.getCompanyAddressId().equals(((CompanyAddress)obj).getCompanyAddressId());
    }

    @Override
    public int hashCode() {
        return companyAddressId.hashCode();
    }

    @Override
    public String toString() {
        return address1 + " " + address2 + " " + city;
    }
}
