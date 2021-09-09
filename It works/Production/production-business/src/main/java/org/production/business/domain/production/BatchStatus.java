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
@Table(name = "batchStatus", catalog = "production")
@XmlRootElement
public class BatchStatus extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String batchStatusId;

    public BatchStatus() {
    }

    public BatchStatus(String batchStatusId) {
        this.batchStatusId = batchStatusId;
    }

    public BatchStatus(String batchStatusId, String name, Date dateCreated) {
        this.batchStatusId = batchStatusId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "batch_status_id", nullable = false, length = 36)
    public String getBatchStatusId() {
        return batchStatusId;
    }

    public void setBatchStatusId(String batchStatusId) {
        this.batchStatusId = batchStatusId;
    }

    @Transient
    public String getId() {
        return batchStatusId;
    }
    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof BatchStatus)) {
            return false;
        }
        return this.getBatchStatusId().equals(((BatchStatus)obj).getBatchStatusId());
    }

    @Override
    public int hashCode() {
        return batchStatusId.hashCode();
    }
}
