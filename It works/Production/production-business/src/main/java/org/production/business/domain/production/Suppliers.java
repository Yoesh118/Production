/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain.production;

import org.production.business.domain.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Rachel Makwara
 */
@Entity
@Table(name = "suppliers", catalog = "production")
@XmlRootElement
public class Suppliers extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String suppliersId;
    private String contactDetails;
    private String suppliersAddress;
    private String bankDetails;
    private String years;
    private String orders;
    private String loyaltyDiscount;
    private String nationality;
    private String loyaltyBenefits;
    private boolean status = true;

    public Suppliers() {
    }

    public Suppliers(String suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Suppliers(String suppliersId, String name, Date dateCreated) {
        this.suppliersId = suppliersId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "suppliers_id", nullable = false, length = 36)
    public String getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(String suppliersId) {
        this.suppliersId = suppliersId;
    }

    @Transient
    public String getId() {
        return suppliersId;
    }

    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Transient
    public String getPreferred() {
        String preferred = status ? "Alternative" : "Default";
        return preferred;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getSuppliersAddress() {
        return suppliersAddress;
    }

    public void setSuppliersAddress(String suppliersAddress) {
        this.suppliersAddress = suppliersAddress;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getLoyaltyDiscount() {
        return loyaltyDiscount;
    }

    public void setLoyaltyDiscount(String loyaltyDiscount) {
        this.loyaltyDiscount = loyaltyDiscount;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLoyaltyBenefits() {
        return loyaltyBenefits;
    }

    public void setLoyaltyBenefits(String loyaltyBenefits) {
        this.loyaltyBenefits = loyaltyBenefits;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Suppliers)) {
            return false;
        }
        return this.getSuppliersId().equals(((Suppliers) obj).getSuppliersId());
    }

    @Override
    public int hashCode() {
        return suppliersId.hashCode();
    }
}
