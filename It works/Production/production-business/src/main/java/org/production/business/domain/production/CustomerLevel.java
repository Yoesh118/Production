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
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "customerLevel", catalog = "production")
@XmlRootElement
public class CustomerLevel extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String customerLevelId;
    private String discount;
    private String privilege;

    public CustomerLevel() {
    }

    public CustomerLevel(String customerLevelId) {
        this.customerLevelId = customerLevelId;
    }

    public CustomerLevel(String customerLevelId, String name, String description, String privilege, String discount, Date dateCreated) {
        this.customerLevelId = customerLevelId;
        super.setName(name);
        super.setDateCreated(dateCreated);
        super.setDescription(description);
        this.discount= discount;
        this.privilege = privilege;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "customer_level_id", nullable = false, length = 36)
    public String getCustomerLevelId() {
        return customerLevelId;
    }

    public void setCustomerLevelId(String customerLevelId) {
        this.customerLevelId = customerLevelId;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
    
    
    

    @Transient
    public String getId() {
        return customerLevelId;
    }
    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof CustomerLevel)) {
            return false;
        }
        return this.getCustomerLevelId().equals(((CustomerLevel)obj).getCustomerLevelId());
    }

    @Override
    public int hashCode() {
        return customerLevelId.hashCode();
    }
}
