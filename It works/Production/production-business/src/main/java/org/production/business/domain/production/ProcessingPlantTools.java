/*
 * To change this template, choose ProcessingPlantTools | Templates
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
@Table(name = "processing_plant_tool", catalog = "production")
@XmlRootElement
public class ProcessingPlantTools extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    String processingPlantToolId;
    private String processingPlantToolNo;
    private String processingPlantToolDescription;
    private String processingPlantUsageStatus;
    private String userName;
    private String userLocation;
    private Tools tools;
    private ProductionTeam productionTeam;
    private boolean status = true;
    private ProcessingPlant processingPlant;
    
   

    public ProcessingPlantTools() {
    }

    public ProcessingPlantTools(String processingPlantToolId) {
        this.processingPlantToolId = processingPlantToolId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "processing_plant_tool_id", nullable = false, length = 36)
    public String getProcessingPlantToolId() {
        return processingPlantToolId;
    }

    public void setProcessingPlantToolId(String processingPlantToolId) {
        this.processingPlantToolId = processingPlantToolId;
    }

    public ProcessingPlantTools(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
    
    @Basic(optional = false)
    @Column(name = "processingPlantTool_description", nullable = false, length = 36)
    public String getProcessingPlantToolDescription() {
        return processingPlantToolDescription;
    }

    public void setProcessingPlantToolDescription(String processingPlantToolDescription) {
        this.processingPlantToolDescription = processingPlantToolDescription;
    }

    public String getProcessingPlantUsageStatus() {
        return processingPlantUsageStatus;
    }

    public void setProcessingPlantUsageStatus(String processingPlantUsageStatus) {
        this.processingPlantUsageStatus = processingPlantUsageStatus;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getProcessingPlantToolNo() {
        return processingPlantToolNo;
    }

    public void setProcessingPlantToolNo(String processingPlantToolNo) {
        this.processingPlantToolNo = processingPlantToolNo;
    }
    
     @JoinColumn(name = "tool_id", referencedColumnName = "tool_id", nullable = false)
    @ManyToOne(optional = false)
    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }
    
    
    @Transient
    public String getPreferred() {
        String preferred = status ? "Free" : "In Use";
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
        if (!(obj instanceof ProcessingPlantTools)) {
            return false;
        }
        return this.getProcessingPlantToolId().equals(((ProcessingPlantTools) obj).getProcessingPlantToolId());
    }    

    @Override
    public int hashCode() {
        return processingPlantToolId.hashCode();
    }

    @ManyToOne
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
}


