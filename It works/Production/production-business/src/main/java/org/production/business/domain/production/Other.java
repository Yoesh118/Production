/*
 * To change this template, choose Others | Templates
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
@Table(name = "other", catalog = "production")
@XmlRootElement
public class Other extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    String otherId;
    private String name;
    private String description;
    private double cost;
    private Date datePaid;
    private Date deadline;
    private BatchStatus batchStatus;
    private double shortfall;
    private ProductionCost productionCost;
    
   

    public Other() {
    }

    public Other(String otherId) {
        this.otherId = otherId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "other_id", nullable = false, length = 36)
    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public Other(ProductionCost productionCost) {
        this.productionCost = productionCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
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
        if (!(obj instanceof Other)) {
            return false;
        }
        return this.getOtherId().equals(((Other) obj).getOtherId());
    }    

    @Override
    public int hashCode() {
        return otherId.hashCode();
    }

    @ManyToOne
    public ProductionCost getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(ProductionCost productionCost) {
        this.productionCost = productionCost;
    }
}


