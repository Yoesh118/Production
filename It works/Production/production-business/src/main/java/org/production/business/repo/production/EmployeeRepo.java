/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface EmployeeRepo extends AbstractRepo<Employee, String> {

    @Override
    public List<Employee> findAll();

    public List<Employee> findByActiveOrderByEmployeeNameAsc(Boolean active);

    @Query("from Employee e  where  e.active=:active and (e.employeeName Like :employeeName%  or e.employeeName Like :employeeName%) order by e.employeeName ASC")
    public List<Employee> findByEmployeeName(@Param("employeeName") String employeeName, @Param("active") Boolean active);
}
