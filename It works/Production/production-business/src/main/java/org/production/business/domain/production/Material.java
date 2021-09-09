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
@Table(name = "material", catalog = "production")
@XmlRootElement
public class Material extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String materialId;
    private double materialCost;
    private String companyName;
    private String contactDetails;
    private double quantity;
    private String companyAddress;
     private String materialDescription;

    public Material() {
    }

    public Material(String materialId) {
        this.materialId = materialId;
    }

    public Material(String materialId, String name, Date dateCreated, double materialCost, String companyName, String contactDetails, double quantity, String companyAddress, String materialDescription ) {
        this.materialId = materialId;
        this.companyAddress = companyAddress;
        this.companyName = companyName;
        this.contactDetails = contactDetails;
        this.materialCost = materialCost;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "material_id", nullable = false, length = 36)
    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    @Transient
    public String getId() {
        return materialId;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }
    
    
    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Material)) {
            return false;
        }
        return this.getMaterialId().equals(((Material)obj).getMaterialId());
    }

    @Override
    public int hashCode() {
        return materialId.hashCode();
    }
}
