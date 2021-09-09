package org.production.business.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "company_status", catalog = "production", schema = "")
@XmlRootElement
public class CompanyStatus extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String companyStatusId;

    public CompanyStatus() {
    }

    public CompanyStatus(String companyStatusId) {
        this.companyStatusId = companyStatusId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "company_status_id", nullable = false, length = 36)
    public String getCompanyStatusId() {
        return companyStatusId;
    }

    public void setCompanyStatusId(String companyStatusId) {
        this.companyStatusId = companyStatusId;
    }

    @Transient
    public String getId() {
        return companyStatusId;
    }
    
    @Transient
    public Boolean getCompanyStatus(){
        if(getName().equalsIgnoreCase("Inactive")){
            return false;
        }else{
            return true;
        }
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof CompanyStatus)) {
            return false;
        }
        return this.getCompanyStatusId().equals(((CompanyStatus)obj).getCompanyStatusId());
    }

    @Override
    public int hashCode() {
        return companyStatusId.hashCode();
    }
}