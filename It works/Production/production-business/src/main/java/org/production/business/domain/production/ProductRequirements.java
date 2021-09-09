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
@Table(name = "product_requirements", catalog = "production")
@XmlRootElement
public class ProductRequirements extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productRequirementsId;
    private Product product;
    private String productRequirementsDescription;
    private double qty;
    private double cost;


 
    public ProductRequirements() {
    }

    public ProductRequirements(String productRequirementsId) {
        this.productRequirementsId = productRequirementsId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_requirements_id", nullable = false, length = 36)
    public String getProductRequirementsId() {
        return productRequirementsId;
    }

    public void setProductRequirementsId(String productRequirementsId) {
        this.productRequirementsId = productRequirementsId;
    }
    
        public String getProductRequirementsDescription() {
        return productRequirementsDescription;
    }

    public void setProductRequirementsDescription(String productRequirementsDescription) {
        this.productRequirementsDescription = productRequirementsDescription;
    }

    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
  
    


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductRequirements)) {
            return false;
        }
        return this.getProductRequirementsId().equals(((ProductRequirements) obj).getProductRequirementsId());
    }

    @Override
    public int hashCode() {
        return productRequirementsId.hashCode();
    }


}
