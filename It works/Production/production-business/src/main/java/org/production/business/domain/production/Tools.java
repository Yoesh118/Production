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
@Table(name = "tool", catalog = "production")
@XmlRootElement
public class Tools extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String toolId;
    private String toolNo;
    

    public Tools() {
    }

    public Tools(String toolId) {
        this.toolId = toolId;
    }

    public Tools(String toolId, String name, String description, String toolNo, String inStock, Date dateCreated) {
        this.toolId = toolId;
        super.setName(name);
        this.toolNo=toolNo;
        super.setDescription(description);
        super.setDateCreated(dateCreated);
    }

    @Id
    @Basic(optional = false)
    @Column(name = "tool_id", nullable = false, length = 36)
    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getToolNo() {
        return toolNo;
    }

    public void setToolNo(String toolNo) {
        this.toolNo = toolNo;
    }

    
    @Transient
    public String getId() {
        return toolId;
    }
    

   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Tools)) {
            return false;
        }
        return this.getToolId().equals(((Tools)obj).getToolId());
    }

    @Override
    public int hashCode() {
        return toolId.hashCode();
    }
}
