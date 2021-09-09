/*
 * To change this template, choose ProductWarehouseTools | Templates
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
@Table(name = "product_warehouse_tool", catalog = "production")
@XmlRootElement
public class ProductWarehouseTools extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    String productWarehouseToolId;
    private String productWarehouseToolName;
    private String productWarehouseToolNo;
    private String productWarehouseToolDescription;
    private String userLocation;
    private Tools tools;
    private ProductWarehouse productWarehouse;
    private ProductionTeam productionTeam;
    private boolean status = true;
    
   

    public ProductWarehouseTools() {
    }

    public ProductWarehouseTools(String productWarehouseToolId) {
        this.productWarehouseToolId = productWarehouseToolId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_warehouse_tool_id", nullable = false, length = 36)
    public String getProductWarehouseToolId() {
        return productWarehouseToolId;
    }

    public void setProductWarehouseToolId(String productWarehouseToolId) {
        this.productWarehouseToolId = productWarehouseToolId;
    }

    public ProductWarehouseTools(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }
    
    
    public String getProductWarehouseToolName() {
        return productWarehouseToolName;
    }

    public void setProductWarehouseToolName(String productWarehouseToolName) {
        this.productWarehouseToolName = productWarehouseToolName;
    }

    public String getProductWarehouseToolDescription() {
        return productWarehouseToolDescription;
    }

    public void setProductWarehouseToolDescription(String productWarehouseToolDescription) {
        this.productWarehouseToolDescription = productWarehouseToolDescription;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getProductWarehouseToolNo() {
        return productWarehouseToolNo;
    }

    public void setProductWarehouseToolNo(String productWarehouseToolNo) {
        this.productWarehouseToolNo = productWarehouseToolNo;
    }
    
    @JoinColumn(name = "tool_id", referencedColumnName = "tool_id", nullable = false)
    @ManyToOne(optional = false)
    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }
    
       @JoinColumn(name = "production_team_id", referencedColumnName = "production_team_id", nullable = false)
    @ManyToOne(optional = false)
    public ProductionTeam getProductionTeam() {
        return productionTeam;
    }

    public void setProductionTeam(ProductionTeam productionTeam) {
        this.productionTeam = productionTeam;
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
        String preferred = status ? "Occupied" : "Free";
        return preferred;
    }

     
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductWarehouseTools)) {
            return false;
        }
        return this.getProductWarehouseToolId().equals(((ProductWarehouseTools) obj).getProductWarehouseToolId());
    }    

    @Override
    public int hashCode() {
        return productWarehouseToolId.hashCode();
    }

    @ManyToOne
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }
}


