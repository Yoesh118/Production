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
@Table(name = "capacity_plan", catalog = "production")
@XmlRootElement
public class CapacityPlan extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String capacityPlanId;
    private String capacityPlanDescription;

    private boolean status = true;
    
    
    
    //-----------Work-----------------//
    private String labour;
    private String material;
    private String equipment;
    private String machinery;
    private String demand;
    private String workOrder;
    private Date planDate;
    private String manager;
    

    public CapacityPlan() {
    }

    public CapacityPlan(String capacityPlanId) {
        this.capacityPlanId = capacityPlanId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "capacity_plan_id", nullable = false, length = 36)
    public String getCapacityPlanId() {
        return capacityPlanId;
    }

    public String getCapacityPlanDescription() {
        return capacityPlanDescription;
    }

    public void setCapacityPlanDescription(String capacityPlanDescription) {
        this.capacityPlanDescription = capacityPlanDescription;
    }

    public void setCapacityPlanId(String capacityPlanId) {
        this.capacityPlanId = capacityPlanId;
       
    }

    public String getLabour() {
        return labour;
    }

    public void setLabour(String labour) {
        this.labour = labour;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getMachinery() {
        return machinery;
    }

    public void setMachinery(String machinery) {
        this.machinery = machinery;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    
    

    @Transient
    public String getPreferred() {
        String preferred = status ? "Active" : "Inactive";
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CapacityPlan)) {
            return false;
        }
        return this.getCapacityPlanId().equals(((CapacityPlan) obj).getCapacityPlanId());
    }

    @Override
    public int hashCode() {
        return capacityPlanId.hashCode();
    }

    public CapacityPlan get(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
