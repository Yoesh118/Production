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
@Table(name = "clientMaintanance", catalog = "production")
@XmlRootElement
public class ClientMaintanance extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String clientMaintananceId;
    private String clientMaintananceProduct;
    private String clientMaintananceDescription;
    private String clientName;
    private BatchStatus batchStatus;
    private double companyCost;
    private double clientCost;
    private ProductionTeam productionTeam;
   
   
    public String getClientMaintananceProduct() {
        return clientMaintananceProduct;
    }

    public void setClientMaintananceProduct(String clientMaintananceProduct) {
        this.clientMaintananceProduct = clientMaintananceProduct;
    }
   
    private boolean status = true;

    public String getClientMaintananceDescription() {
        return clientMaintananceDescription;
    }

    public void setClientMaintananceDescription(String clientMaintananceDescription) {
        this.clientMaintananceDescription = clientMaintananceDescription;
    }
    
   

    public ClientMaintanance() {
    }

    public ClientMaintanance(String clientMaintananceId) {
        this.clientMaintananceId = clientMaintananceId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "clientMaintanance_id", nullable = false, length = 36)
    public String getClientMaintananceId() {
        return clientMaintananceId;
    }

    public void setClientMaintananceId(String clientMaintananceId) {
        this.clientMaintananceId = clientMaintananceId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getCompanyCost() {
        return companyCost;
    }

    public void setCompanyCost(double companyCost) {
        this.companyCost = companyCost;
    }

    public double getClientCost() {
        return clientCost;
    }

    public void setClientCost(double clientCost) {
        this.clientCost = clientCost;
    }
   
     @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }
    
     @JoinColumn(name = "production_team_id", referencedColumnName = "production_team_id", nullable = false)
    @ManyToOne(optional = false)
    public ProductionTeam getProductionTeam() {
        return productionTeam;
    }

    public void setProductionTeam(ProductionTeam productionTeam) {
        this.productionTeam = productionTeam;
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
        if (!(obj instanceof ClientMaintanance)) {
            return false;
        }
        return this.getClientMaintananceId().equals(((ClientMaintanance) obj).getClientMaintananceId());
    }

    @Override
    public int hashCode() {
        return clientMaintananceId.hashCode();
    }


}
