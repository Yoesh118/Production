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
@Table(name = "processingPlantMachinery", catalog = "production")
@XmlRootElement
public class ProcessingPlantMachinery extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processingPlantMachineryId;
    private String processingPlantMachineryDescription;
    private String processingPlantMachineryName;
    private String processingPlantMachineryNo;
    private String processingPlantMachineryCapacity;
   private boolean status = true;
   private ProductionTeam productionTeam;
    private String userLocation;
    private ProcessingPlant processingPlant;
    private Machinery machinery;

    public String getProcessingPlantMachineryName() {
        return processingPlantMachineryName;
    }

    public void setProcessingPlantMachineryName(String processingPlantMachineryName) {
        this.processingPlantMachineryName = processingPlantMachineryName;
    }
  
    public String getProcessingPlantMachineryDescription() {
        return processingPlantMachineryDescription;
    }

    public void setProcessingPlantMachineryDescription(String processingPlantMachineryDescription) {
        this.processingPlantMachineryDescription = processingPlantMachineryDescription;
    }
   
  
   

    public ProcessingPlantMachinery() {
    }

    public ProcessingPlantMachinery(String processingPlantMachineryId) {
        this.processingPlantMachineryId = processingPlantMachineryId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "processingPlantMachinery_id", nullable = false, length = 36)
    public String getProcessingPlantMachineryId() {
        return processingPlantMachineryId;
    }

    public void setProcessingPlantMachineryId(String processingPlantMachineryId) {
        this.processingPlantMachineryId = processingPlantMachineryId;
    }

    public String getProcessingPlantMachineryCapacity() {
        return processingPlantMachineryCapacity;
    }

    public void setProcessingPlantMachineryCapacity(String processingPlantMachineryCapacity) {
        this.processingPlantMachineryCapacity = processingPlantMachineryCapacity;
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
        String preferred = status ? "Active" : "Inactive";
        return preferred;
    }

    
    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getProcessingPlantMachineryNo() {
        return processingPlantMachineryNo;
    }

    public void setProcessingPlantMachineryNo(String processingPlantMachineryNo) {
        this.processingPlantMachineryNo = processingPlantMachineryNo;
    }

    public ProcessingPlantMachinery(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
    
    @JoinColumn(name = "machinery_id", referencedColumnName = "machinery_id", nullable = false)
    @ManyToOne(optional = false)
    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
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
        if (!(obj instanceof ProcessingPlantMachinery)) {
            return false;
        }
        return this.getProcessingPlantMachineryId().equals(((ProcessingPlantMachinery) obj).getProcessingPlantMachineryId());
    }

    @Override
    public int hashCode() {
        return processingPlantMachineryId.hashCode();
    }

    @ManyToOne
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }

   

}
