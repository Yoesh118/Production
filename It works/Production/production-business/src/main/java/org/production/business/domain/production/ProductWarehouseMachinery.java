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
@Table(name = "product_warehouse_machinery", catalog = "production")
@XmlRootElement
public class ProductWarehouseMachinery extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productWarehouseMachineryId;
    private String productWarehouseMachineryDescription;
    private Machinery machinery;
    private String productWarehouseMachineryNo;
    private String productWarehouseMachineryCapacity;
    private boolean machineStatus = true;
    private boolean userStatus = true;
    private String userName;
    private String userLocation;
    private ProductWarehouse productWarehouse;
    private ProductionTeam productionTeam;
  
    public String getProductWarehouseMachineryDescription() {
        return productWarehouseMachineryDescription;
    }

    public void setProductWarehouseMachineryDescription(String productWarehouseMachineryDescription) {
        this.productWarehouseMachineryDescription = productWarehouseMachineryDescription;
    }
   
  
   

    public ProductWarehouseMachinery() {
    }

    public ProductWarehouseMachinery(String productWarehouseMachineryId) {
        this.productWarehouseMachineryId = productWarehouseMachineryId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_warehouse_machinery_id", nullable = false, length = 36)
    public String getProductWarehouseMachineryId() {
        return productWarehouseMachineryId;
    }

    public void setProductWarehouseMachineryId(String productWarehouseMachineryId) {
        this.productWarehouseMachineryId = productWarehouseMachineryId;
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


    public String getProductWarehouseMachineryCapacity() {
        return productWarehouseMachineryCapacity;
    }

    public void setProductWarehouseMachineryCapacity(String productWarehouseMachineryCapacity) {
        this.productWarehouseMachineryCapacity = productWarehouseMachineryCapacity;
    }

        @Basic(optional = false)
    @Column(name = "user_status", nullable = false)
    public boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    
           @Basic(optional = false)
    @Column(name = "machine_status", nullable = false)
    public boolean getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(boolean machineStatus) {
        this.machineStatus = machineStatus;
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

    public String getProductWarehouseMachineryNo() {
        return productWarehouseMachineryNo;
    }

    public void setProductWarehouseMachineryNo(String productWarehouseMachineryNo) {
        this.productWarehouseMachineryNo = productWarehouseMachineryNo;
    }

    public ProductWarehouseMachinery(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }
    
    
    
    



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductWarehouseMachinery)) {
            return false;
        }
        return this.getProductWarehouseMachineryId().equals(((ProductWarehouseMachinery) obj).getProductWarehouseMachineryId());
    }

    @Override
    public int hashCode() {
        return productWarehouseMachineryId.hashCode();
    }

    @ManyToOne
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }

   

}
