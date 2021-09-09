/*
 * To change this template, choose IncidentCostTools | Templates
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
@Table(name = "incident_cost", catalog = "production")
@XmlRootElement
public class IncidentCost extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    String incidentCostId;
    private ProductionCost productionCost;
    private String repairCompany;
    private String companyDetails;
    private double totalCost;
    private Date paymentDate;
    private Date deadline;
    private BatchStatus batchStatus;
    private WorkIncident workIncident;
    private double shortfall;
    
   

    public IncidentCost() {
    }

    public IncidentCost(String incidentCostId) {
        this.incidentCostId = incidentCostId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "incident_cost_id", nullable = false, length = 36)
    public String getIncidentCostId() {
        return incidentCostId;
    }

    public void setIncidentCostId(String incidentCostId) {
        this.incidentCostId = incidentCostId;
    }

    public IncidentCost(ProductionCost productionCost) {
        this.productionCost = productionCost;
    }
    
    

    public String getRepairCompany() {
        return repairCompany;
    }

    public void setRepairCompany(String repairCompany) {
        this.repairCompany = repairCompany;
    }

    public String getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(String companyDetails) {
        this.companyDetails = companyDetails;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
    
    @JoinColumn(name = "work_incident_id", referencedColumnName = "work_incident_id", nullable = false)
    @ManyToOne(optional = false)
    public WorkIncident getWorkIncident() {
        return workIncident;
    }

    public void setWorkIncident(WorkIncident workIncident) {
        this.workIncident = workIncident;
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
        if (!(obj instanceof IncidentCost)) {
            return false;
        }
        return this.getIncidentCostId().equals(((IncidentCost) obj).getIncidentCostId());
    }    

    @Override
    public int hashCode() {
        return incidentCostId.hashCode();
    }

    @ManyToOne
    public ProductionCost getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(ProductionCost productionCost) {
        this.productionCost = productionCost;
    }
}


