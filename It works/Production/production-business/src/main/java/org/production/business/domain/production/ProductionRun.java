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
@Table(name = "production_run", catalog = "production")
@XmlRootElement
public class ProductionRun extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productionRunId;
    private String productionRunNo;
    
    private String productionRunDescription;

    public String getProductionRunDescription() {
        return productionRunDescription;
    }

    public void setProductionRunDescription(String productionRunDescription) {
        this.productionRunDescription = productionRunDescription;
    }

    public String getProductionRunNo() {
        return productionRunNo;
    }

    public void setProductionRunNo(String productionRunNo) {
        this.productionRunNo = productionRunNo;
    }
    
    
  
    public ProductionRun() {
    }

    public ProductionRun(String productionRunId) {
        this.productionRunId = productionRunId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "production_run_id", nullable = false, length = 36)
    public String getProductionRunId() {
        return productionRunId;
    }

    public void setProductionRunId(String productionRunId) {
        this.productionRunId = productionRunId;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductionRun)) {
            return false;
        }
        return this.getProductionRunId().equals(((ProductionRun) obj).getProductionRunId());
    }

    @Override
    public int hashCode() {
        return productionRunId.hashCode();
    }

   

}
