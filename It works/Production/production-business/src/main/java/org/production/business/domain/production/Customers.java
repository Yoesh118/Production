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
@Table(name = "customers", catalog = "production")
@XmlRootElement
public class Customers extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String customersId;
    private String contactDetails;
    private String customersAddress;
    private String years;
    private String orders;
    private String loyaltyDiscount;
    private CustomerLevel customerLevel;
    private String nationality;

    public Customers() {
    }

    public Customers(String customersId) {
        this.customersId = customersId;
    }

    public Customers(String customersId, String name, String nationality, Date dateCreated, String contactDetails, String customersAddress, String years, String orders, String loyaltyDiscount, CustomerLevel customerLevel) {
        this.customersId = customersId;
        this.years = years;
        this.orders = orders;
        this.loyaltyDiscount = loyaltyDiscount;
        this.customerLevel = customerLevel;
        this.customersAddress = customersAddress;
        this.contactDetails = contactDetails;
        this.nationality = nationality;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "customers_id", nullable = false, length = 36)
    public String getCustomersId() {
        return customersId;
    }

    public void setCustomersId(String customersId) {
        this.customersId = customersId;
    }

    @Transient
    public String getId() {
        return customersId;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getCustomersAddress() {
        return customersAddress;
    }

    public void setCustomersAddress(String customersAddress) {
        this.customersAddress = customersAddress;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    @JoinColumn(name = "customer_level_id", referencedColumnName = "customer_level_id", nullable = false)
    @ManyToOne(optional = false)
    public CustomerLevel getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(CustomerLevel customerLevel) {
        this.customerLevel = customerLevel;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Customers)) {
            return false;
        }
        return this.getCustomersId().equals(((Customers) obj).getCustomersId());
    }

    @Override
    public int hashCode() {
        return customersId.hashCode();
    }
}
