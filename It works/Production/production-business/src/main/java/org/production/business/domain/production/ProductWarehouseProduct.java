/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.domain.production;

import org.production.business.domain.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  Rachel Makwara
 */

@Entity
@Table(name = "product_warehouse_product", catalog = "production")
@XmlRootElement
public class ProductWarehouseProduct extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    String productWarehouseProductId;
    private String productWarehouseProductNo;
    private String productWarehouseProductDescription;
    private double qty;
    private Product product;
    private ProductWarehouse productWarehouse;
 
    private boolean status = true;
    
   

    public ProductWarehouseProduct() {
    }

    public ProductWarehouseProduct(String productWarehouseProductId) {
        this.productWarehouseProductId = productWarehouseProductId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "productWarehouseProduct_id", nullable = false, length = 36)
    public String getProductWarehouseProductId() {
        return productWarehouseProductId;
    }

    public void setProductWarehouseProductId(String productWarehouseProductId) {
        this.productWarehouseProductId = productWarehouseProductId;
    }

    @Basic(optional = false)
    @Column(name = "product_warehouse_product_description", nullable = false, length = 36)
    public String getProductWarehouseProductDescription() {
        return productWarehouseProductDescription;
    }

    public void setProductWarehouseProductDescription(String productWarehouseProductDescription) {
        this.productWarehouseProductDescription = productWarehouseProductDescription;
    }

    public String getProductWarehouseProductNo() {
        return productWarehouseProductNo;
    }

    public void setProductWarehouseProductNo(String productWarehouseProductNo) {
        this.productWarehouseProductNo = productWarehouseProductNo;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

     @ManyToOne
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }

    public ProductWarehouseProduct(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }
    
        @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    
    @Transient
    public String getPreferred() {
        String preferred = status ? "Available" : "Unavailable";
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductWarehouseProduct)) {
            return false;
        }
        return this.getProductWarehouseProductId().equals(((ProductWarehouseProduct) obj).getProductWarehouseProductId());
    }    

    @Override
    public int hashCode() {
        return productWarehouseProductId.hashCode();
    }
  }


