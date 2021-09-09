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
@Table(name = "assetJobCard", catalog = "production")
@XmlRootElement
public class AssetJobCard extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String assetJobCardId;
    private Suppliers suppliers;
    private String cardNo;
    private Date lastMaintained;
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

    public AssetJobCard() {
    }

    public AssetJobCard(String assetJobCardId) {
        this.assetJobCardId = assetJobCardId;
    }

    public AssetJobCard(String assetJobCardId, String name, Date dateCreated) {
        this.assetJobCardId = assetJobCardId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "asset_job_card_id", nullable = false, length = 36)
    public String getAssetJobCardId() {
        return assetJobCardId;
    }

    public void setAssetJobCardId(String assetJobCardId) {
        this.assetJobCardId = assetJobCardId;
    }

    @Transient
    public String getId() {
        return assetJobCardId;
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

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    @JoinColumn(name = "suppliers_id", referencedColumnName = "suppliers_id", nullable = false)
    @ManyToOne(optional = false)
    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @JoinColumn(name = "maintanance_team_id", referencedColumnName = "maintanance_team_id", nullable = false)
    @ManyToOne(optional = false)
    public MaintananceTeam getMaintananceTeam() {
        return maintananceTeam;
    }

    public void setMaintananceTeam(MaintananceTeam maintananceTeam) {
        this.maintananceTeam = maintananceTeam;
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
        if (!(obj instanceof AssetJobCard)) {
            return false;
        }
        return this.getAssetJobCardId().equals(((AssetJobCard) obj).getAssetJobCardId());
    }

    @Override
    public int hashCode() {
        return assetJobCardId.hashCode();
    }
}
