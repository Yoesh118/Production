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
@Table(name = "employee", catalog = "production")
@XmlRootElement
public class Employee extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String employeeId;
    private String employeeNo;
    private String employeeName;
    private String employeeAddress;
    private String qualification;
    private ProductionTeam productionTeam;
    private String productionTeamDescription;
   

    public Employee() {
    }

    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "employee_id", nullable = false, length = 36)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
    
     @JoinColumn(name = "production_team_id", referencedColumnName = "production_team_id", nullable = false)
    @ManyToOne(optional = false)
    public ProductionTeam getProductionTeam() {
        return productionTeam;
    }

    public void setProductionTeam(ProductionTeam productionTeam) {
        this.productionTeam = productionTeam;
    }

    public String getProductionTeamDescription() {
        return productionTeamDescription;
    }

    public void setProductionTeamDescription(String productionTeamDescription) {
        this.productionTeamDescription = productionTeamDescription;
    }
    
    

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        return this.getEmployeeId().equals(((Employee) obj).getEmployeeId());
    }

    @Override
    public int hashCode() {
        return employeeId.hashCode();
    }

    public Employee get(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
