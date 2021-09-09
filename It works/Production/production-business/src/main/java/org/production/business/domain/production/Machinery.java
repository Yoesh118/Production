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
@Table(name = "machinery", catalog = "production")
@XmlRootElement
public class Machinery extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String machineryId;
    private String machineNo;
    private String machineCapacity;

    public Machinery() {
    }

    public Machinery(String machineryId, String name, Date dateCreated, String machineNo, String machineCapacity, String description) {
        this.machineryId = machineryId;
        this.machineNo = machineNo;
        this.machineCapacity = machineCapacity;
        super.setDescription(description);
        super.setName(name);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "machinery_id", nullable = false, length = 36)
    public String getMachineryId() {
        return machineryId;
    }

    public void setMachineryId(String machineryId) {
        this.machineryId = machineryId;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getMachineCapacity() {
        return machineCapacity;
    }

    public void setMachineCapacity(String machineCapacity) {
        this.machineCapacity = machineCapacity;
    }
    

    @Transient
    public String getId() {
        return machineryId;
    }
    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Machinery)) {
            return false;
        }
        return this.getMachineryId().equals(((Machinery)obj).getMachineryId());
    }

    @Override
    public int hashCode() {
        return machineryId.hashCode();
    }
}
