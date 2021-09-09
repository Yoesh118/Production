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
 * @author Rachel Makwara
 */
@Entity
@Table(name = "product_batch", catalog = "production")
@XmlRootElement
public class ProductBatch extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productBatchId;
    private String productBatchName;
    private String batchDescription;
    private double batchQuantity;
    private ProcessingPlant processingPlant;
    private ProductWarehouse productWarehouse;
    private BatchStatus batchStatus;

    public String getProductBatchName() {
        return productBatchName;
    }

    public void setProductBatchName(String productBatchName) {
        this.productBatchName = productBatchName;
    }
    
    public ProductBatch() {
    }

    public ProductBatch(String productBatchId) {
        this.productBatchId = productBatchId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "product_batch_id", nullable = false, length = 36)
    public String getProductBatchId() {
        return productBatchId;
    }

    public void setProductBatchId(String productBatchId) {
        this.productBatchId = productBatchId;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public Double getBatchQuantity() {
        return batchQuantity;
    }

    public void setBatchQuantity(Double batchQuantity) {
        this.batchQuantity = batchQuantity;
    }

    @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }
    
    @JoinColumn(name = "processing_plant_id", referencedColumnName = "processing_plant_id", nullable = false)
    @ManyToOne(optional = false)
    public ProcessingPlant getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(ProcessingPlant processingPlant) {
        this.processingPlant = processingPlant;
    }
  
      @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id", nullable = false)
    @ManyToOne(optional = false)
    public ProductWarehouse getProductWarehouse() {
        return productWarehouse;
    }

    public void setProductWarehouse(ProductWarehouse productWarehouse) {
        this.productWarehouse = productWarehouse;
    }
  
    


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductBatch)) {
            return false;
        }
        return this.getProductBatchId().equals(((ProductBatch) obj).getProductBatchId());
    }

    @Override
    public int hashCode() {
        return productBatchId.hashCode();
    }


}
