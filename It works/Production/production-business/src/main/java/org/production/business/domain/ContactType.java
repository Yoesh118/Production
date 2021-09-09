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
@Table(name = "contact_type", catalog = "production")
@XmlRootElement
public class ContactType extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String contactTypeId;

    public ContactType() {
    }

    public ContactType(String contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public ContactType(String contactTypeId, String name, Date dateCreated) {
        this.contactTypeId = contactTypeId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "contact_type_id", nullable = false, length = 36)
    public String getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(String contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    @Transient
    public String getId() {
        return contactTypeId;
    }
    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof ContactType)) {
            return false;
        }
        return this.getContactTypeId().equals(((ContactType)obj).getContactTypeId());
    }

    @Override
    public int hashCode() {
        return contactTypeId.hashCode();
    }
}
