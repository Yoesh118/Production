/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain.production;

import org.production.business.domain.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */

@Entity
@Table(name = "assetMaintanance", catalog = "production")
@XmlRootElement
public class AssetMaintanance extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String assetMaintananceId;
    private String assetMaintananceProduct;
     private String assetMaintananceDescription;
    private BatchStatus batchStatus;
     private String maintananceCompany;
     private double cost;
     private String companyAddress;
     private String companyBankDetails;
   
   
    public String getAssetMaintananceProduct() {
        return assetMaintananceProduct;
    }

    public void setAssetMaintananceProduct(String assetMaintananceProduct) {
        this.assetMaintananceProduct = assetMaintananceProduct;
    }
   
    private boolean status = true;

    public String getAssetMaintananceDescription() {
        return assetMaintananceDescription;
    }

    public void setAssetMaintananceDescription(String assetMaintananceDescription) {
        this.assetMaintananceDescription = assetMaintananceDescription;
    }
    
   

    public AssetMaintanance() {
    }

    public AssetMaintanance(String assetMaintananceId) {
        this.assetMaintananceId = assetMaintananceId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "assetMaintanance_id", nullable = false, length = 36)
    public String getAssetMaintananceId() {
        return assetMaintananceId;
    }

    public void setAssetMaintananceId(String assetMaintananceId) {
        this.assetMaintananceId = assetMaintananceId;
    }

 @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }
    

    public String getMaintananceCompany() {
        return maintananceCompany;
    }

    public void setMaintananceCompany(String maintananceCompany) {
        this.maintananceCompany = maintananceCompany;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyBankDetails() {
        return companyBankDetails;
    }

    public void setCompanyBankDetails(String companyBankDetails) {
        this.companyBankDetails = companyBankDetails;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AssetMaintanance)) {
            return false;
        }
        return this.getAssetMaintananceId().equals(((AssetMaintanance) obj).getAssetMaintananceId());
    }

    @Override
    public int hashCode() {
        return assetMaintananceId.hashCode();
    }


}
