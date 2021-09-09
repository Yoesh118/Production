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
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "work_incident", catalog = "production")
@XmlRootElement
public class WorkIncident extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String workIncidentId;
    private String workIncidentDescription;
    private String workIncidentName;
    private BatchStatus batchStatus;
    private Date date;
    



    public WorkIncident() {
    }

    public WorkIncident(String workIncidentId, String workIncidentDescription, String workIncidentName, BatchStatus batchStatus, Date date) {
        this.workIncidentId = workIncidentId;
        this.batchStatus = batchStatus;
        this.workIncidentName = workIncidentName;
        this.workIncidentDescription = workIncidentDescription;
        this.date = date;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "work_incident_id", nullable = false, length = 36)
    public String getWorkIncidentId() {
        return workIncidentId;
    }

    public void setWorkIncidentId(String workIncidentId) {
        this.workIncidentId = workIncidentId;
    }
    
        public String getWorkIncidentName() {
        return workIncidentName;
    }

    public void setWorkIncidentName(String workIncidentName) {
        this.workIncidentName = workIncidentName;
    }
    
    

    public String getWorkIncidentDescription() {
        return workIncidentDescription;
    }

    public void setWorkIncidentDescription(String workIncidentDescription) {
        this.workIncidentDescription = workIncidentDescription;
    }
    
     @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
     @Transient
    public String getId() {
        return workIncidentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WorkIncident)) {
            return false;
        }
        return this.getWorkIncidentId().equals(((WorkIncident) obj).getWorkIncidentId());
    }

    @Override
    public int hashCode() {
        return workIncidentId.hashCode();
    }

}
