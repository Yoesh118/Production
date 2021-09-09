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
 * @author Rachel Makwara
 */
@Entity
@Table(name = "maintanance_team", catalog = "production")
@XmlRootElement
public class MaintananceTeam extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String maintananceTeamId;
    private String maintananceTeamMembers;
    private String maintananceTeamDescription;
    private String teamNo;
    private String timeTillFree;
    private boolean status = true;

    public MaintananceTeam() {
    }

    public MaintananceTeam(String maintananceTeamId) {
        this.maintananceTeamId = maintananceTeamId;
    }

    public MaintananceTeam(String maintananceTeamId, String name, String maintananceTeamMembers, String maintananceTeamName, String teamNo, String maintananceTeamDescription, String timeTillFree, boolean status) {
        this.maintananceTeamId = maintananceTeamId;
        this.maintananceTeamDescription = maintananceTeamDescription;
        this.maintananceTeamMembers = maintananceTeamMembers;
        super.setName(name);
        this.timeTillFree = timeTillFree;
        this.status = status;
        this.teamNo = teamNo;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "maintanance_team_id", nullable = false, length = 36)
    public String getMaintananceTeamId() {
        return maintananceTeamId;
    }

    public void setMaintananceTeamId(String maintananceTeamId) {
        this.maintananceTeamId = maintananceTeamId;
    }

    @Transient
    public String getId() {
        return maintananceTeamId;
    }

    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMaintananceTeamMembers() {
        return maintananceTeamMembers;
    }

    public void setMaintananceTeamMembers(String maintananceTeamMembers) {
        this.maintananceTeamMembers = maintananceTeamMembers;
    }

  
    public String getMaintananceTeamDescription() {
        return maintananceTeamDescription;
    }

    public void setMaintananceTeamDescription(String maintananceTeamDescription) {
        this.maintananceTeamDescription = maintananceTeamDescription;
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
        if (!(obj instanceof MaintananceTeam)) {
            return false;
        }
        return this.getMaintananceTeamId().equals(((MaintananceTeam) obj).getMaintananceTeamId());
    }

    @Override
    public int hashCode() {
        return maintananceTeamId.hashCode();
    }
}
