/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain.production;

import org.production.business.domain.*;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */
@Entity
@Table(name = "finishedProducts", catalog = "production")
@XmlRootElement
public class FinishedProducts extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String finishedProductsId;
    private String orderNo;
    private String productNo;
    private Product product;
    
    private boolean status = true;

    public FinishedProducts() {
    }

    public FinishedProducts(String finishedProductsId) {
        this.finishedProductsId = finishedProductsId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "finishedProducts_id", nullable = false, length = 36)
    public String getFinishedProductsId() {
        return finishedProductsId;
    }

    public void setFinishedProductsId(String finishedProductsId) {
        this.finishedProductsId = finishedProductsId;
    }

    @Transient
    public String getPreferred() {
        String preferred = status ? "Active" : "Inactive";
        return preferred;
    }

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

     @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

  
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FinishedProducts)) {
            return false;
        }
        return this.getFinishedProductsId().equals(((FinishedProducts) obj).getFinishedProductsId());
    }

    @Override
    public int hashCode() {
        return finishedProductsId.hashCode();
    }

}
