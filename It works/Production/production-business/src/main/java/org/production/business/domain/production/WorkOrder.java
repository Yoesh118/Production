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
 * @author Rachel Makwara
 */
@Entity
@Table(name = "work_order", catalog = "production")
@XmlRootElement
public class WorkOrder extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String workOrderId;
    private Date dateOrdered;
    private Date collectionDate;
    private String customerName;
    private Customers customers;
   // private Customer customer;
    private String customerContact;
    private BatchStatus batchStatus;
    private String workOrderNo;
    private double quantity;
    private double cost;
    private Product product;
    private String productNo;

    public WorkOrder() {
    }

    public WorkOrder(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "work_order_id", nullable = false, length = 36)
    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    @JoinColumn(name = "batch_status_id", referencedColumnName = "batch_status_id", nullable = false)
    @ManyToOne(optional = false)
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo;
    }

//    @Enumerated
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    /**
     *
     * @return
     */
    @JoinColumn(name = "customers_id", referencedColumnName = "customers_id", nullable = false)
    @ManyToOne(optional = false)
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WorkOrder)) {
            return false;
        }
        return this.getWorkOrderId().equals(((WorkOrder) obj).getWorkOrderId());
    }

    @Override
    public int hashCode() {
        return workOrderId.hashCode();
    }
}
