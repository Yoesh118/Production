/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "companyDirector", catalog = "production")
@XmlRootElement
public class CompanyDirector extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String companyDirectorId;
    private String directorName;
    private String directorSurname;
    private String directorMiddleName;
    private String directorContact;
    private String directorAddress;
    private Company company;
    private Boolean status = Boolean.TRUE;

    public CompanyDirector() {
    }

    public CompanyDirector(String companyDirectorId) {
        this.companyDirectorId = companyDirectorId;
    }

    public CompanyDirector(String companyDirectorId, String name, Date dateCreated) {
        this.companyDirectorId = companyDirectorId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "companyDirector_id", nullable = false, length = 36)
    public String getCompanyDirectorId() {
        return companyDirectorId;
    }

    public void setCompanyDirectorId(String companyDirectorId) {
        this.companyDirectorId = companyDirectorId;
    }

    @Transient
    public String getId() {
        return companyDirectorId;
    }

    public CompanyDirector(Company company) {
        this.company = company;
    }

    @XmlTransient
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    @ManyToOne(optional = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorSurname() {
        return directorSurname;
    }

    public void setDirectorSurname(String directorSurname) {
        this.directorSurname = directorSurname;
    }

    public String getDirectorContact() {
        return directorContact;
    }

    public void setDirectorContact(String directorContact) {
        this.directorContact = directorContact;
    }

    public String getDirectorMiddleName() {
        return directorMiddleName;
    }

    public void setDirectorMiddleName(String directorMiddleName) {
        this.directorMiddleName = directorMiddleName;
    }

    public String getDirectorAddress() {
        return directorAddress;
    }

    public void setDirectorAddress(String directorAddress) {
        this.directorAddress = directorAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CompanyDirector)) {
            return false;
        }
        return this.getCompanyDirectorId().equals(((CompanyDirector) obj).getCompanyDirectorId());
    }

    @Override
    public int hashCode() {
        return companyDirectorId.hashCode();
    }

}
