/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "company", catalog = "production")
@XmlRootElement
public class Company extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String companyId;
    private String name;
    private String companyNo;
    private double shares;
    private Province province;
    private CompanyStatus companyStatus;
    private CompanyType companyType;
    private Set<CompanyDirector> companyDirector;
    private Set<CompanyBankDetail> companyBankDetails;
    private Set<CompanyContact> companyContacts;
    private Set<CompanyAddress> companyAddresses;
    private Set<SupportingDocument> supportingDocuments;

    public Company() {
    }

    public Company(String companyId) {
        this.companyId = companyId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "company_id", nullable = false, length = 36)
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JoinColumn(name = "company_status_id", referencedColumnName = "company_status_id", nullable = true)
    @ManyToOne(optional = true)
    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    @JoinColumn(name = "province_id", referencedColumnName = "province_id", nullable = true)
    @ManyToOne(optional = true)
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

    @JoinColumn(name = "company_type_id", referencedColumnName = "company_type_id", nullable = true)
    @ManyToOne(optional = false)
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @OneToMany(mappedBy = "company")
    public Set<CompanyBankDetail> getCompanyBankDetails() {
        return companyBankDetails;
    }

    public void setCompanyBankDetails(Set<CompanyBankDetail> companyBankDetails) {
        this.companyBankDetails = companyBankDetails;
    }

    @OneToMany(mappedBy = "company")
    public Set<CompanyContact> getCompanyContacts() {
        return companyContacts;
    }

    public void setCompanyContacts(Set<CompanyContact> companyContacts) {
        this.companyContacts = companyContacts;
    }

    @OneToMany(mappedBy = "company")
    public Set<CompanyAddress> getCompanyAddresses() {
        return companyAddresses;
    }

    public void setCompanyAddresses(Set<CompanyAddress> companyAddresses) {
        this.companyAddresses = companyAddresses;
    }

    @OneToMany(mappedBy = "company")
    public Set<CompanyDirector> getCompanyDirector() {
        return companyDirector;
    }

    public void setCompanyDirector(Set<CompanyDirector> companyDirector) {
        this.companyDirector = companyDirector;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Company)) {
            return false;
        }
        return this.getCompanyId().equals(((Company) obj).getCompanyId());
    }

    @Override
    public int hashCode() {
        return companyId.hashCode();
    }

}
