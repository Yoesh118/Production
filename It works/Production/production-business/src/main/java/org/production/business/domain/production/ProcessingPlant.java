/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain.production;

import org.production.business.domain.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "processing_plant", catalog = "production")
@XmlRootElement
public class ProcessingPlant extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processingPlantId;
    private String processingPlantLocation;
    private String processingPlantName;
    private String functionality;
    private String capacity;
    private String capacityStatus;
    private String processingPlantDescription;
    private Set<ProcessingPlantMaterial> processingPlantMaterial;
    private Set<ProcessingPlantMachinery> processingPlantMachinery;
    private Set<ProcessingPlantProductionRun> processingPlantProductionRun;
    private Set<ProcessingPlantProductionTeam> processingPlantProductionTeam;
    private Set<ProcessingPlantTools> processingPlantTools;

    public ProcessingPlant() {
    }

    public ProcessingPlant(String processingPlantId, String processingPlantLocation, String processingPlantName, String functionality, String capacity, Date dateCreated, String capacityStatus, String processingPlantDescription) {
        this.processingPlantId = processingPlantId;
        this.processingPlantLocation = processingPlantLocation;
        this.processingPlantName = processingPlantName;
        this.functionality = functionality;
        this.capacity = capacity;
        this.capacityStatus = capacityStatus;
        this.processingPlantDescription = processingPlantDescription;
        
    }

    @Id
    @Basic(optional = false)
    @Column(name = "processing_plant_id", nullable = false, length = 36)
    public String getProcessingPlantId() {
        return processingPlantId;
    }

    public void setProcessingPlantId(String processingPlantId) {
        this.processingPlantId = processingPlantId;
    }

    @Transient
    public String getId() {
        return processingPlantId;
    }
    
     public String getProcessingPlantLocation() {
        return processingPlantLocation;
    }

    public void setProcessingPlantLocation(String processingPlantLocation) {
        this.processingPlantLocation = processingPlantLocation;
    }
    

    public String getProcessingPlantDescription() {
        return processingPlantDescription;
    }

    public void setProcessingPlantDescription(String processingPlantDescription) {
        this.processingPlantDescription = processingPlantDescription;
    }

    public String getProcessingPlantName() {
        return processingPlantName;
    }

    public void setProcessingPlantName(String processingPlantName) {
        this.processingPlantName = processingPlantName;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacityStatus() {
        return capacityStatus;
    }

    public void setCapacityStatus(String capacityStatus) {
        this.capacityStatus = capacityStatus;
    }

    @OneToMany(mappedBy = "processingPlant")
    public Set<ProcessingPlantMaterial> getProcessingPlantMaterial() {
        return processingPlantMaterial;
    }

    public void setProcessingPlantMaterial(Set<ProcessingPlantMaterial> processingPlantMaterial) {
        this.processingPlantMaterial = processingPlantMaterial;
    }

    @OneToMany(mappedBy = "processingPlant")
    public Set<ProcessingPlantMachinery> getProcessingPlantMachinery() {
        return processingPlantMachinery;
    }

    public void setProcessingPlantMachinery(Set<ProcessingPlantMachinery> processingPlantMachinery) {
        this.processingPlantMachinery = processingPlantMachinery;
    }

    @OneToMany(mappedBy = "processingPlant")
    public Set<ProcessingPlantProductionRun> getProcessingPlantProductionRun() {
        return processingPlantProductionRun;
    }

    public void setProcessingPlantProductionRun(Set<ProcessingPlantProductionRun> processingPlantProductionRun) {
        this.processingPlantProductionRun = processingPlantProductionRun;
    }

    @OneToMany(mappedBy = "processingPlant")
    public Set<ProcessingPlantProductionTeam> getProcessingPlantProductionTeam() {
        return processingPlantProductionTeam;
    }

    public void setProcessingPlantProductionTeam(Set<ProcessingPlantProductionTeam> processingPlantProductionTeam) {
        this.processingPlantProductionTeam = processingPlantProductionTeam;
    }

    @OneToMany(mappedBy = "processingPlant")
    public Set<ProcessingPlantTools> getProcessingPlantTools() {
        return processingPlantTools;
    }

    public void setProcessingPlantTools(Set<ProcessingPlantTools> processingPlantTools) {
        this.processingPlantTools = processingPlantTools;
    }

    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof ProcessingPlant)) {
            return false;
        }
        return this.getProcessingPlantId().equals(((ProcessingPlant)obj).getProcessingPlantId());
    }

    @Override
    public int hashCode() {
        return processingPlantId.hashCode();
    }
}
