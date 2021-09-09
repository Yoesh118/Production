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
@Table(name = "processing_plant_production_run", catalog = "production")
@XmlRootElement
public class ProcessingPlantProductionRun extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processingPlantProductionRunId;
    private String processingPlantProductionRunNo;
    private String completionDate;
    private String startDate;
    private String processingPlantProductionRunDescription;
    private ProcessingPlant processingPlant;

    public String getProcessingPlantProductionRunDescription() {
        return processingPlantProductionRunDescription;
    }

    public void setProcessingPlantProductionRunDescription(String processingPlantProductionRunDescription) {
        this.processingPlantProductionRunDescription = processingPlantProductionRunDescription;
    }
  
    public ProcessingPlantProductionRun() {
    }

    public ProcessingPlantProductionRun(String processingPlantProductionRunId) {
        this.processingPlantProductionRunId = processingPlantProductionRunId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "processing_plant_production_run_id", nullable = false, length = 36)
    public String getProcessingPlantProductionRunId() {
        return processingPlantProductionRunId;
    }

    public void setProcessingPlantProductionRunId(String processingPlantProductionRunId) {
        this.processingPlantProductionRunId = processingPlantProductionRunId;
    }

    public String getProcessingPlantProductionRunNo() {
        return processingPlantProductionRunNo;
    }

    public void setProcessingPlantProductionRunNo(String processingPlantProductionRunNo) {
        this.processingPlantProductionRunNo = processingPlantProductionRunNo;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ProcessingPlantProductionRun(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
    
    
  
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProcessingPlantProductionRun)) {
            return false;
        }
        return this.getProcessingPlantProductionRunId().equals(((ProcessingPlantProductionRun) obj).getProcessingPlantProductionRunId());
    }

    @Override
    public int hashCode() {
        return processingPlantProductionRunId.hashCode();
    }

    @ManyToOne
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }

   

}
