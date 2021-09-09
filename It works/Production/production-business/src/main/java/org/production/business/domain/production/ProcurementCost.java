/*
 * To change this template, choose ProductionCostTools | Templates
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
@Table(name = "procurement_cost", catalog = "production")
@XmlRootElement
public class ProcurementCost extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    String procurementCostId;
    private String item;
    private double unitCost;
    private double qty;
    private Date procurementDate;
    private Date deadline;
    private BatchStatus batchStatus;
    private double shortfall;
    private ProductionCost productionCost;
    
   

    public ProcurementCost() {
    }

    public ProcurementCost(String procurementCostId) {
        this.procurementCostId = procurementCostId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "procurement_cost_id", nullable = false, length = 36)
    public String getProcurementCostId() {
        return procurementCostId;
    }

    public void setProcurementCostId(String procurementCostId) {
        this.procurementCostId = procurementCostId;
    }

    public ProcurementCost(ProductionCost productionCost) {
        this.productionCost = productionCost;
    }
    
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Date getProcurementDate() {
        return procurementDate;
    }

    public void setProcurementDate(Date procurementDate) {
        this.procurementDate = procurementDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public double getShortfall() {
        return shortfall;
    }

    public void setShortfall(double shortfall) {
        this.shortfall = shortfall;
    }
    
    @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProcurementCost)) {
            return false;
        }
        return this.getProcurementCostId().equals(((ProcurementCost) obj).getProcurementCostId());
    }    

    @Override
    public int hashCode() {
        return procurementCostId.hashCode();
    }

    @ManyToOne
    public ProductionCost getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(ProductionCost productionCost) {
        this.productionCost = productionCost;
    }
}


