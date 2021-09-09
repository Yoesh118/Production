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

/*
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "processing_plant_processingPlantMaterial", catalog = "production")
@XmlRootElement
public class ProcessingPlantMaterial extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processingPlantMaterialId;
    private String processingPlantMaterialName;
    private String processingPlantMaterialDescription;
    private String dateAcquired;
    private double quantity;
    private ProcessingPlant processingPlant;
    private Material material;
     
 

    public String getProcessingPlantMaterialName() {
        return processingPlantMaterialName;
    }

    public void setProcessingPlantMaterialName(String processingPlantMaterialName) {
        this.processingPlantMaterialName = processingPlantMaterialName;
    }
   

    public String getProcessingPlantMaterialDescription() {
        return processingPlantMaterialDescription;
    }

    public void setProcessingPlantMaterialDescription(String processingPlantMaterialDescription) {
        this.processingPlantMaterialDescription = processingPlantMaterialDescription;
    }
 
    public ProcessingPlantMaterial() {
    }

    public ProcessingPlantMaterial(String processingPlantMaterialId) {
        this.processingPlantMaterialId = processingPlantMaterialId;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public ProcessingPlantMaterial(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }

    @JoinColumn(name = "material_id", referencedColumnName = "material_id", nullable = false)
    @ManyToOne(optional = false)
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
    

    @Id
    @Basic(optional = false)
    @Column(name = "processing_plant_material_id", nullable = false, length = 36)
    public String getProcessingPlantMaterialId() {
        return processingPlantMaterialId;
    }

    public void setProcessingPlantMaterialId(String processingPlantMaterialId) {
        this.processingPlantMaterialId = processingPlantMaterialId;
    }
    


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProcessingPlantMaterial)) {
            return false;
        }
        return this.getProcessingPlantMaterialId().equals(((ProcessingPlantMaterial) obj).getProcessingPlantMaterialId());
    }

    @Override
    public int hashCode() {
        return processingPlantMaterialId.hashCode();
    }

    @ManyToOne
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }

   


}
