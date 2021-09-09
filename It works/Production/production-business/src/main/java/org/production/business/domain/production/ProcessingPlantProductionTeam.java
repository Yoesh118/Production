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
@Table(name = "processing_plant_production_team", catalog = "production")
@XmlRootElement
public class ProcessingPlantProductionTeam extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processingPlantProductionTeamId;
    private String processingPlantProductionTeamDescription;
    private String processingPlantProductionTeamName;
    private String processingPlantProductionTeamNo;
    private String processingPlantProductionTeamDuties;
    private String timeTillFree;
    private ProductionTeam productionTeam;
    private ProcessingPlant processingPlant;

    public String getProcessingPlantProductionTeamDescription() {
        return processingPlantProductionTeamDescription;
    }

    public void setProcessingPlantProductionTeamDescription(String processingPlantProductionTeamDescription) {
        this.processingPlantProductionTeamDescription = processingPlantProductionTeamDescription;
    }
    
   

    public ProcessingPlantProductionTeam() {
    }

    public ProcessingPlantProductionTeam(String processingPlantProductionTeamId) {
        this.processingPlantProductionTeamId = processingPlantProductionTeamId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "processing_plant_production_team_id", nullable = false, length = 36)
    public String getProcessingPlantProductionTeamId() {
        return processingPlantProductionTeamId;
    }

    public void setProcessingPlantProductionTeamId(String processingPlantProductionTeamId) {
        this.processingPlantProductionTeamId = processingPlantProductionTeamId;
    }

    public String getProcessingPlantProductionTeamName() {
        return processingPlantProductionTeamName;
    }

    public void setProcessingPlantProductionTeamName(String processingPlantProductionTeamName) {
        this.processingPlantProductionTeamName = processingPlantProductionTeamName;
    }

    public String getProcessingPlantProductionTeamDuties() {
        return processingPlantProductionTeamDuties;
    }

    public void setProcessingPlantProductionTeamDuties(String processingPlantProductionTeamDuties) {
        this.processingPlantProductionTeamDuties = processingPlantProductionTeamDuties;
    }

    public String getTimeTillFree() {
        return timeTillFree;
    }

    public void setTimeTillFree(String timeTillFree) {
        this.timeTillFree = timeTillFree;
    }

    public String getProcessingPlantProductionTeamNo() {
        return processingPlantProductionTeamNo;
    }

    public void setProcessingPlantProductionTeamNo(String processingPlantProductionTeamNo) {
        this.processingPlantProductionTeamNo = processingPlantProductionTeamNo;
    }

    public ProcessingPlantProductionTeam(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
    
       @JoinColumn(name = "production_team_id", referencedColumnName = "production_team_id", nullable = false)
    @ManyToOne(optional = false)
    public ProductionTeam getProductionTeam() {
        return productionTeam;
    }

    public void setProductionTeam(ProductionTeam productionTeam) {
        this.productionTeam = productionTeam;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProcessingPlantProductionTeam)) {
            return false;
        }
        return this.getProcessingPlantProductionTeamId().equals(((ProcessingPlantProductionTeam) obj).getProcessingPlantProductionTeamId());
    }

    @Override
    public int hashCode() {
        return processingPlantProductionTeamId.hashCode();
    }

    @ManyToOne
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }

  
}
