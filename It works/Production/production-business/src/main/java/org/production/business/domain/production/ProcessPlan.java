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
@Table(name = "process_plan", catalog = "production")
@XmlRootElement
public class ProcessPlan extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processPlanId;
    private String OrderNo;
    private String processStages;
    private String stageNo;
    private String description;
    private ProcessingPlant processingPlant;
    private ProductWarehouse productWarehouse;
    private BatchStatus batchStatus;
    private Date startDate;
    private Date endDate;
    

    public ProcessPlan() {
    }

    public ProcessPlan(String processPlanId) {
        this.processPlanId = processPlanId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "process_plan_id", nullable = false, length = 36)
    public String getProcessPlanId() {
        return processPlanId;
    }

    public void setProcessPlanId(String processPlanId) {
        this.processPlanId = processPlanId;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }

    public String getProcessStages() {
        return processStages;
    }

    public void setProcessStages(String processStages) {
        this.processStages = processStages;
    }

    public String getStageNo() {
        return stageNo;
    }

    public void setStageNo(String stageNo) {
        this.stageNo = stageNo;
    }

     @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }
    
    @JoinColumn(name = "processing_plant_id", referencedColumnName = "processing_plant_id", nullable = false)
    @ManyToOne(optional = false)
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
  
      @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id", nullable = false)
    @ManyToOne(optional = false)
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
  
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProcessPlan)) {
            return false;
        }
        return this.getProcessPlanId().equals(((ProcessPlan) obj).getProcessPlanId());
    }

    @Override
    public int hashCode() {
        return processPlanId.hashCode();
    }

   

}
