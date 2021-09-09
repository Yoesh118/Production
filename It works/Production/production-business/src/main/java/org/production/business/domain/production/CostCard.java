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
@Table(name = "costCard", catalog = "production")
@XmlRootElement
public class CostCard extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String costCardId;
    private String costCardNo;
    private String reason;
    private boolean status = true;
    private String alternatives;
    private double quantity;
    private double totalCost;
    private boolean approved = true;

    public CostCard() {
    }

    public CostCard(String costCardId) {
        this.costCardId = costCardId;
    }

    public CostCard(String costCardId, String name, Date dateCreated, String description) {
        this.costCardId = costCardId;
        super.setName(name);
        super.setDescription(description);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "cost_card_id", nullable = false, length = 36)
    public String getCostCardId() {
        return costCardId;
    }

    public void setCostCardId(String costCardId) {
        this.costCardId = costCardId;
    }

    @Transient
    public String getId() {
        return costCardId;
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
        String preferred = status ? "Urgent" : "Not Urgent";
        return preferred;
    }

    @Basic(optional = false)
    @Column(name = "Approved", nullable = false)
    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Transient
    public String getPrefer() {
        String prefer = approved ? "Approved" : "Declined";
        return prefer;
    }

    public String getCostCardNo() {
        return costCardNo;
    }

    public void setCostCardNo(String costCardNo) {
        this.costCardNo = costCardNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CostCard)) {
            return false;
        }
        return this.getCostCardId().equals(((CostCard) obj).getCostCardId());
    }

    @Override
    public int hashCode() {
        return costCardId.hashCode();
    }
}
