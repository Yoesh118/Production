/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain.production;

import org.production.business.domain.*;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "production_cost", catalog = "production")
@XmlRootElement
public class ProductionCost extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productionCostId;
    private String name;
    private Set<ProcurementCost> procurementCost;
    private Set<IncidentCost> incidentCost;
    private Set<Other> other;
    
    public ProductionCost() {
    }

    public ProductionCost(String productionCostId) {
        this.productionCostId = productionCostId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "production_cost_id", nullable = false, length = 36)
    public String getProductionCostId() {
        return productionCostId;
    }

    public void setProductionCostId(String productionCostId) {
        this.productionCostId = productionCostId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     @OneToMany(mappedBy = "productionCost")
    public Set<ProcurementCost> getProcurementCost() {
        return procurementCost;
    }

    public void setProcurementCost(Set<ProcurementCost> procurementCost) {
        this.procurementCost = procurementCost;
    }
    
     @OneToMany(mappedBy = "productionCost")
    public Set<IncidentCost> getIncidentCost() {
        return incidentCost;
    }

    public void setIncidentCost(Set<IncidentCost> incidentCost) {
        this.incidentCost = incidentCost;
    }
    
     @OneToMany(mappedBy = "productionCost")
    public Set<Other> getOther() {
        return other;
    }

    public void setOther(Set<Other> other) {
        this.other = other;
    }


  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductionCost)) {
            return false;
        }
        return this.getProductionCostId().equals(((ProductionCost) obj).getProductionCostId());
    }

    @Override
    public int hashCode() {
        return productionCostId.hashCode();
    }

    
}
