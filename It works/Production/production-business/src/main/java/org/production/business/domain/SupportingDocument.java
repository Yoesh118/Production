/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "supportingDocument", catalog = "production")
@XmlRootElement
public class SupportingDocument extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String supportingDocumentId;
    
  

    public SupportingDocument() {
    }

   

    public SupportingDocument(String supportingDocumentId) {
        this.supportingDocumentId = supportingDocumentId;
    }

    public SupportingDocument(String supportingDocumentId, String name, Date dateCreated) {
        this.supportingDocumentId = supportingDocumentId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "supportingDocument_id", nullable = false, length = 36)
    public String getSupportingDocumentId() {
        return supportingDocumentId;
    }

    public void setSupportingDocumentId(String supportingDocumentId) {
        this.supportingDocumentId = supportingDocumentId;
    }

    @Transient
    public String getId() {
        return supportingDocumentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SupportingDocument)) {
            return false;
        }
        return this.getSupportingDocumentId().equals(((SupportingDocument) obj).getSupportingDocumentId());
    }

    @Override
    public int hashCode() {
        return supportingDocumentId.hashCode();
    }
    
}
