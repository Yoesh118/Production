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
 * @author Rachel Makwara
 */
@Entity
@Table(name = "clientJobCard", catalog = "production")
@XmlRootElement
public class ClientJobCard extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String clientJobCardId;
    private Date lastMaintained;
    private String cardNo;
    private String clientName;
    private String priorName;
    private String priorJob;
    private String priorAssessment;
    private Date currentDate;
    private String currentJob;
    private MaintananceTeam maintananceTeam;
    private Date startDate;
    private Date estimatedStopDate;
    private String delayTime;
    private boolean status = true;

    public ClientJobCard() {
    }

    public ClientJobCard(String clientJobCardId) {
        this.clientJobCardId = clientJobCardId;
    }

    public ClientJobCard(String clientJobCardId, String name, Date dateCreated) {
        this.clientJobCardId = clientJobCardId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "client_job_card_id", nullable = false, length = 36)
    public String getClientJobCardId() {
        return clientJobCardId;
    }

    public void setClientJobCardId(String clientJobCardId) {
        this.clientJobCardId = clientJobCardId;
    }

    @Transient
    public String getId() {
        return clientJobCardId;
    }

    public Date getLastMaintained() {
        return lastMaintained;
    }

    public void setLastMaintained(Date lastMaintained) {
        this.lastMaintained = lastMaintained;
    }

    public String getPriorName() {
        return priorName;
    }

    public void setPriorName(String priorName) {
        this.priorName = priorName;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public String getPriorJob() {
        return priorJob;
    }

    public void setPriorJob(String priorJob) {
        this.priorJob = priorJob;
    }

    public String getPriorAssessment() {
        return priorAssessment;
    }

    public void setPriorAssessment(String priorAssessment) {
        this.priorAssessment = priorAssessment;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    @JoinColumn(name = "maintanance_team_id", referencedColumnName = "maintanance_team_id", nullable = false)
    @ManyToOne(optional = false)
    public MaintananceTeam getMaintananceTeam() {
        return maintananceTeam;
    }

    public void setMaintananceTeam(MaintananceTeam maintananceTeam) {
        this.maintananceTeam = maintananceTeam;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEstimatedStopDate() {
        return estimatedStopDate;
    }

    public void setEstimatedStopDate(Date estimatedStopDate) {
        this.estimatedStopDate = estimatedStopDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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
        String preferred = status ? "Complete" : "Incomplete";
        return preferred;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ClientJobCard)) {
            return false;
        }
        return this.getClientJobCardId().equals(((ClientJobCard) obj).getClientJobCardId());
    }

    @Override
    public int hashCode() {
        return clientJobCardId.hashCode();
    }
}
