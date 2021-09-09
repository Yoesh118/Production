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
@Table(name = "product", catalog = "production")
@XmlRootElement
public class Product extends BaseMetaData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productId;
    private boolean status = true;

    public Product() {
    }

    public Product(String productId, String name, String description, String productNo, String inStock, Date dateCreated, boolean status) {
        this.productId = productId;
        super.setName(name);
        super.setProductNo(productNo);
        super.setDescription(description);
        super.setInStock(inStock);
        super.setDateCreated(dateCreated);
        this.status = status;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_id", nullable = false, length = 36)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Transient
    public String getId() {
        return productId;
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
        String preferred = status ? "In Stock" : "Out of Stock";
        return preferred;
    }

    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Product)) {
            return false;
        }
        return this.getProductId().equals(((Product)obj).getProductId());
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }
}
