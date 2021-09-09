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
@Table(name = "production_team", catalog = "production")
@XmlRootElement
public class ProductionTeam extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productionTeamId;
    private String productionTeamMembers;
    private String productionTeamName;
    private String productionTeamDescription;
    private String teamNo;
    private String timeTillFree;
    private boolean status = true;
    
    public ProductionTeam() {
    }

    public ProductionTeam(String productionTeamId) {
        this.productionTeamId = productionTeamId;
    }

    public ProductionTeam(String productionTeamId, String productionTeamMembers, String productionTeamName, String teamNo, String productionTeamDescription, String timeTillFree, boolean status ) {
        this.productionTeamId = productionTeamId;
        this.productionTeamDescription = productionTeamDescription;
        this.productionTeamMembers = productionTeamMembers;
        this.productionTeamName = productionTeamName;
        this.timeTillFree = timeTillFree;
        this.status = status;
        this.teamNo = teamNo;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "production_team_id", nullable = false, length = 36)
    public String getProductionTeamId() {
        return productionTeamId;
    }

    public void setProductionTeamId(String productionTeamId) {
        this.productionTeamId = productionTeamId;
    }


    @Transient
    public String getId() {
        return productionTeamId;
    }
    
         @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
    public String getProductionTeamMembers() {
        return productionTeamMembers;
    }

    public void setProductionTeamMembers(String productionTeamMembers) {
        this.productionTeamMembers = productionTeamMembers;
    }

    public String getProductionTeamName() {
        return productionTeamName;
    }

    public void setProductionTeamName(String productionTeamName) {
        this.productionTeamName = productionTeamName;
    }

    public String getProductionTeamDescription() {
        return productionTeamDescription;
    }

    public void setProductionTeamDescription(String productionTeamDescription) {
        this.productionTeamDescription = productionTeamDescription;
    }

    public String getTimeTillFree() {
        return timeTillFree;
    }

    public void setTimeTillFree(String timeTillFree) {
        this.timeTillFree = timeTillFree;
    }

    public String getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(String teamNo) {
        this.teamNo = teamNo;
    }

    
    
  
    @Transient
    public String getPreferred() {
        String preferred = status ? "Active" : "Inactive";
        return preferred;
    }

    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof ProductionTeam)) {
            return false;
        }
        return this.getProductionTeamId().equals(((ProductionTeam)obj).getProductionTeamId());
    }

    @Override
    public int hashCode() {
        return productionTeamId.hashCode();
    }
}
