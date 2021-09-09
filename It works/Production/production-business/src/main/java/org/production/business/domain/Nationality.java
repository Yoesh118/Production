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
@Table(name = "nationality", catalog = "production")
@XmlRootElement
public class Nationality extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nationalityId;
  

    public Nationality() {
    }

   

    public Nationality(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Nationality(String nationalityId, String name, Date dateCreated) {
        this.nationalityId = nationalityId;
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "nationality_id", nullable = false, length = 36)
    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Transient
    public String getId() {
        return nationalityId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Nationality)) {
            return false;
        }
        return this.getNationalityId().equals(((Nationality) obj).getNationalityId());
    }

    @Override
    public int hashCode() {
        return nationalityId.hashCode();
    }
    
}
