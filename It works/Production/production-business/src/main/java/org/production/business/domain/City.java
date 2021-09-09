/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "city", catalog = "production", schema = "")
@XmlRootElement
public class City extends BaseMetaData implements Serializable {

    private String cityId;

    public City() {
    }

    public City(String cityId) {
        this.cityId = cityId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "city_id", nullable = false, length = 36)
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Transient
    public String getId() {
        return cityId;
    }

   
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof City)) {
            return false;
        }
        return this.getCityId().equals(((City)obj).getCityId());
    }

    @Override
    public int hashCode() {
        return cityId.hashCode();
    }
}
