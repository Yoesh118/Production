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
@Table(name = "product_warehouse_pos", catalog = "production")
@XmlRootElement
public class ProductWarehousePos extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productWarehousePosId;
    private String productWarehousePosNo;
    private String orderNo;
    private BatchStatus batchStatus;
    private ProductWarehouse productWarehouse;
    
   

    public ProductWarehousePos() {
    }

    public ProductWarehousePos(String productWarehousePosId) {
        this.productWarehousePosId = productWarehousePosId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_warehouse_pos_id", nullable = false, length = 36)
    public String getProductWarehousePosId() {
        return productWarehousePosId;
    }

    public void setProductWarehousePosId(String productWarehousePosId) {
        this.productWarehousePosId = productWarehousePosId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getProductWarehousePosNo() {
        return productWarehousePosNo;
    }

    public void setProductWarehousePosNo(String productWarehousePosNo) {
        this.productWarehousePosNo = productWarehousePosNo;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductWarehousePos)) {
            return false;
        }
        return this.getProductWarehousePosId().equals(((ProductWarehousePos) obj).getProductWarehousePosId());
    }    

    @Override
    public int hashCode() {
        return productWarehousePosId.hashCode();
    }

    @ManyToOne
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }

    public ProductWarehousePos(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }

}

