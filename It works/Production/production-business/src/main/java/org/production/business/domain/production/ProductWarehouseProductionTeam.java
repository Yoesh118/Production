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
@Table(name = "product_warehouse_production_team", catalog = "production")
@XmlRootElement
public class ProductWarehouseProductionTeam extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productWarehouseProductionTeamId;
    private String productWarehouseProductionTeamDescription;
    private String productWarehouseProductionTeamName;
    private String productWarehouseProductionTeamNo;
    private String productWarehouseProductionTeamDuties;
    private String timeTillFree;
    private ProductWarehouse productWarehouse;
    private ProductionTeam productionTeam; 

    public String getProductWarehouseProductionTeamDescription() {
        return productWarehouseProductionTeamDescription;
    }

    public void setProductWarehouseProductionTeamDescription(String productWarehouseProductionTeamDescription) {
        this.productWarehouseProductionTeamDescription = productWarehouseProductionTeamDescription;
    }
    
   

    public ProductWarehouseProductionTeam() {
    }

    public ProductWarehouseProductionTeam(String productWarehouseProductionTeamId) {
        this.productWarehouseProductionTeamId = productWarehouseProductionTeamId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_warehouse_production_team_id", nullable = false, length = 36)
    public String getProductWarehouseProductionTeamId() {
        return productWarehouseProductionTeamId;
    }

    public void setProductWarehouseProductionTeamId(String productWarehouseProductionTeamId) {
        this.productWarehouseProductionTeamId = productWarehouseProductionTeamId;
    }

    public String getProductWarehouseProductionTeamName() {
        return productWarehouseProductionTeamName;
    }

    public void setProductWarehouseProductionTeamName(String productWarehouseProductionTeamName) {
        this.productWarehouseProductionTeamName = productWarehouseProductionTeamName;
    }

    public String getProductWarehouseProductionTeamDuties() {
        return productWarehouseProductionTeamDuties;
    }

    public void setProductWarehouseProductionTeamDuties(String productWarehouseProductionTeamDuties) {
        this.productWarehouseProductionTeamDuties = productWarehouseProductionTeamDuties;
    }

    public String getTimeTillFree() {
        return timeTillFree;
    }

    public void setTimeTillFree(String timeTillFree) {
        this.timeTillFree = timeTillFree;
    }

    public String getProductWarehouseProductionTeamNo() {
        return productWarehouseProductionTeamNo;
    }

    public void setProductWarehouseProductionTeamNo(String productWarehouseProductionTeamNo) {
        this.productWarehouseProductionTeamNo = productWarehouseProductionTeamNo;
    }

    public ProductWarehouseProductionTeam(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
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
        if (!(obj instanceof ProductWarehouseProductionTeam)) {
            return false;
        }
        return this.getProductWarehouseProductionTeamId().equals(((ProductWarehouseProductionTeam) obj).getProductWarehouseProductionTeamId());
    }

    @Override
    public int hashCode() {
        return productWarehouseProductionTeamId.hashCode();
    }

    @ManyToOne
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }

  
}
