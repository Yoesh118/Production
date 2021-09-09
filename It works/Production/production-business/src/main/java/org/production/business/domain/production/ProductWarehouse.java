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
import org.production.business.utils.StringUtils;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "warehouse", catalog = "production")
@XmlRootElement
public class ProductWarehouse extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
   private String warehouseId;
    private String warehouseName;
    private String warehouseDescription;
    private String warehouseCapacity;
    private String warehouseLocation;
    private String warehouseNo;
    private Machinery machinery;
    private WorkIncident workIncident;
    private WorkOrder workOrder;
    String name;
    private Set<ProductWarehousePos> productWarehousePos;
    private Set<ProductWarehouseMachinery> productWarehouseMachinery;
    private Set<ProductWarehouseProduct> productWarehouseProduct;
    private Set<ProductWarehouseProductionTeam> productWarehouseProductionTeam;
    private Set<ProductWarehouseTools> productWarehouseTools;

    public ProductWarehouse() {
    }

    public ProductWarehouse(String warehouseId, String warehouseDescription, String warehouseName, String warehouseCapacity, String warehouseLocation, String warehouseNo) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.warehouseDescription = warehouseDescription;
        this.warehouseCapacity = warehouseCapacity;
        this.warehouseLocation = warehouseLocation;
        this.warehouseNo = warehouseNo;
    }

    public ProductWarehouse(String warehouseId, String warehouseNo, Date dateCreated) {
        this.warehouseId = warehouseId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "warehouse_id", nullable = false, length = 36)
    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    
    
    public String getWarehouseDescription() {
        return warehouseDescription;
    }

    public void setWarehouseDescription(String warehouseDescription) {
        this.warehouseDescription = warehouseDescription;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }
    
   
       public String getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(String warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }
    

    @OneToMany(mappedBy = "productWarehouse")
    public Set<ProductWarehousePos> getProductWarehousePos() {
        return productWarehousePos;
    }

    public void setProductWarehousePos(Set<ProductWarehousePos> productWarehousePos) {
        this.productWarehousePos = productWarehousePos;
    }

    @OneToMany(mappedBy = "productWarehouse")
    public Set<ProductWarehouseMachinery> getProductWarehouseMachinery() {
        return productWarehouseMachinery;
    }

    public void setProductWarehouseMachinery(Set<ProductWarehouseMachinery> productWarehouseMachinery) {
        this.productWarehouseMachinery = productWarehouseMachinery;
    }

    @OneToMany(mappedBy = "productWarehouse")
    public Set<ProductWarehouseProduct> getProductWarehouseProduct() {
        return productWarehouseProduct;
    }

    public void setProductWarehouseProduct(Set<ProductWarehouseProduct> productWarehouseProduct) {
        this.productWarehouseProduct = productWarehouseProduct;
    }

    @OneToMany(mappedBy = "productWarehouse")
    public Set<ProductWarehouseProductionTeam> getProductWarehouseProductionTeam() {
        return productWarehouseProductionTeam;
    }

    public void setProductWarehouseProductionTeam(Set<ProductWarehouseProductionTeam> productWarehouseProductionTeam) {
        this.productWarehouseProductionTeam = productWarehouseProductionTeam;
    }

    @OneToMany(mappedBy = "productWarehouse")
    public Set<ProductWarehouseTools> getProductWarehouseTools() {
        return productWarehouseTools;
    }

    public void setProductWarehouseTools(Set<ProductWarehouseTools> productWarehouseTools) {
        this.productWarehouseTools = productWarehouseTools;
    }

    @ManyToOne
    @JoinColumn(name="machineryId")
    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }
    
     @Column(name = "name", nullable = true)
    public String getName() {
        return name != null ? StringUtils.toCamelCase2(name) : name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
  

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(name="workIncidentId")
    public WorkIncident getWorkIncident() {
        return workIncident;
    }

    public void setWorkIncident(WorkIncident workIncident) {
        this.workIncident = workIncident;
    }

    @ManyToOne
    @JoinColumn(name="workOrderId")
    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    
    
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }


    @Transient
    public String getId() {
        return warehouseId;
    }
    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof ProductWarehouse)) {
            return false;
        }
        return this.getWarehouseId().equals(((ProductWarehouse)obj).getWarehouseId());
    }

    @Override
    public int hashCode() {
        return warehouseId.hashCode();
    }
}
